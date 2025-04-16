import http from 'k6/http';
import { Rate, Trend } from 'k6/metrics'
import { check, group, sleep } from 'k6';
import {parseJwt} from "./util.js";
import { scenario } from 'k6/execution';

// Load data from file
const users = JSON.parse(open('./users.json'));
const code = [
    open('./TestCode/TestStringParser_empty.java'),
    open('./TestCode/TestStringParser_notCompile.java'),
    open('./TestCode/TestStringParser_win.java')
];

// Metriche personalizzate
let successRate = new Rate('success_rate');
let responseTime = new Trend('response_time');
let errorRate = new Rate('error_rate');

/*
export const options = {
    scenarios: {
        ramping_test: {
            executor: 'ramping-vus',
            startVUs: 10,
            stages: [
                { duration: '5m', target: 10 },
                { duration: '2m', target: 70 },
                { duration: '90m', target: 70 },
                { duration: '30m', target: 40 },
                { duration: '5m', target: 40 },
            ],
        },
    },
};

 */

export const options = {
    // Definizione delle metriche di soglia
    /*
    thresholds: {
        'http_req_duration': ['p(95)<500'],
        'http_req_failed': ['rate<0.01'],
        'success_rate': ['rate>0.95'],
    },

     */

    // Configurazione dell'output InfluxDB
    ext: {
        influxdb: {
            url: 'http://localhost:9090',
            database: 'k6db',
            precision: 's',
        },
    },

    scenarios: {
        gradual_test: {
            executor: 'per-vu-iterations',
            vus: 50,
            iterations: 1,
            maxDuration: '90m',
        },
    },
};


/*
export const options = {
    scenarios: {
        two_users_test: {
            executor: 'per-vu-iterations',
            vus: 1,                 // only 2 virtual users
            iterations: 1,          // only 1 iteration per user
            maxDuration: '180m',
        },
    },
};
 */


export default function () {
    startGame();
}

function startGame() {
    sleep(Math.random() * 9 + 1);

    const vuIndex = __VU - 1; // __VU -> number of virtual user, start at 1
    const user = users[vuIndex % users.length];

    if (!user) {
        console.error(`Nessun utente disponibile per VU ${__VU}`);
        return;
    }

    const email = user.email;
    const password = user.password;

    // Phase 1: Login
    const loginPayload = {
        email: email,
        password: password,
    };

    const loginHeader = {
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
        redirects: 0,
    };

    let resLogin = http.post('http://localhost/login', loginPayload, loginHeader);

    let loginSuccess = check(resLogin, {
        'Login avvenuto con successo': (r) => r.status === 200 || r.status === 302,
    });

    if (!loginSuccess) {
        console.error(`Login fallito per ${email}: ${resLogin.status}`);
        console.error(resLogin.body);
        return;
    } else {
        console.log(`Login avvenuto con successo per ${email}`);
    }

    let jwt = null;
    let playerId = null;

    if (resLogin.cookies && resLogin.cookies.jwt && resLogin.cookies.jwt.length > 0) {
        jwt = resLogin.cookies.jwt[0].value;
        playerId =  parseJwt(jwt).userId;
        console.log(`JWT estratto dal cookie per ${email}:`, jwt);
        console.log(`Decode JWT in userId per ${email}: ${parseJwt(jwt)} -> ${playerId}`);
    } else {
        console.error(`JWT non trovato nei cookie per ${email}`);
        return;
    }

    sleep(Math.random() * 9 + 1);

    // Access to view /main to creare Session for user
    const mainHeader = {
        cookies: {
            lang: 'en',
            jwt: jwt,
        },
    };

    let resMain = http.get(`http://localhost/main`, null, mainHeader);

    if (resMain.status <= 299) {
        console.log(`Access main succeeded, session created`);
    } else {
        console.error(`Error accessing view /main`);
        console.error(resMain.body);
    }

    // Verify if there is a previous game
    const gameModeHeader = {
        "Content-Type": "application/json",
    };

    let resGameMode = http.get(`http://localhost/session/gamemode/${playerId}?mode=PartitaSingola`, null, gameModeHeader);

    if (resGameMode.status <= 299) {
        console.error(`There is a previous game for user ${email} - ${playerId}`);
        console.error(resGameMode.body);
    } else {
        console.log(`There is no previous game for user ${email} - ${playerId}: ${resGameMode.status}`);
    }


    // Phase 2: Start game
    //{
    //   "playerId": "101",
    //   "typeRobot": "Randoop",
    //   "difficulty": "1",
    //   "mode": "PartitaSingola",
    //   "underTestClassName": "StringParser",
    //   "remainingTime": 7200
    // }
    const startGamePayload = JSON.stringify({
        playerId: playerId,
        typeRobot: "Randoop",
        difficulty: "1",
        mode: "PartitaSingola",
        underTestClassName: "StringParser",
        remainingTime: 7200,
    });

    console.log(startGamePayload);

    const startGameHeader = {
        headers: {
            'Content-Type': 'application/json',
        },
        cookies: {
            lang: 'en',
            jwt: jwt,
        },
    };

    let startGameRes = http.post('http://localhost/StartGame', startGamePayload, startGameHeader);

    if (startGameRes.status > 299) {
        console.error(`Errore StartGame per ${email}:`, startGameRes.body);
    } else {
        console.log(`StartGame OK per ${email}`);
    }

    let startSuccess = check(startGameRes, {
        'Avvio partita avvenuto con successo': (r) => r.status === 200,
    });

    sleep(Math.random() * 9 + 1);

    // Random time between 5 and 2 minutes before the end of the scenario.
    const timeToExit = scenario.time_remaining - (Math.random() * (5 - 2) * 60 * 1000 + 2 * 60 * 1000);
    let canWin = false;
    group('T5 /run', () => {
        // Loop of the game
        while (true) {
            canWin = runGame(playerId, jwt, email);

            // If the game can be won, exit the loop with a 40% of probability. Else exit with a 5% of probability
            const randomValue = Math.random();
            if ((canWin && randomValue < 0.4) || (!canWin && randomValue < 0.05)) {
                console.log(`Uscita dal ciclo per esito partita: canWin=${canWin}, randomValue=${randomValue.toFixed(2)}`);
                break;
            }

            // If the remaining time is less than the random selected time, exit the loop
            const timeRemaining = scenario.time_remaining;
            if (timeRemaining <= timeToExit) {
                console.log(`Uscita dal ciclo per tempo random: manca ${Math.floor(timeRemaining)}`);
                break;
            }
        }
    });

    endGame(playerId, jwt, email, canWin);
}

function runGame(playerId, jwt, email) {
    const selectedCode = Math.floor(Math.random() * 3);
    console.log("selectedCode: ", selectedCode);
    const testCode = code[selectedCode];

    // Phase 3: Play
    const runPayload = JSON.stringify({
        playerId: playerId,
        mode: "PartitaSingola",
        testingClassCode: testCode,
        remainingTime: 7000,
    });

    const runHeader = {
        headers: {
            'Content-Type': 'application/json',
        },
        cookies: {
            lang: 'en',
            jwt: jwt,
        },
        timeout: '600s'
    };

    let runRes = http.post('http://localhost/run', runPayload, runHeader);

    try {
        const runBody = JSON.parse(runRes.body);
        const userScore = runBody.userScore;
        const robotScore = runBody.robotScore;
        const canWin = runBody.canWin;
        const compilationResult = runBody.userCoverageDetails.xml_coverage;
        console.log(`{"compilationResult": ${compilationResult !== null? "not null" : "null"}, "canWin": ${canWin}, "userScore": ${userScore}, "robotScore": ${robotScore}}`);

        if (runRes.status > 299) {
            console.error(`Errore /run per ${email}: ${runRes.body}`);
        } else {
            console.log(`run OK per ${email}`);
        }

        const checks = {
            0: { name: '/run codice vuoto', fn: (r) => compilationResult !== null && userScore === 0 },
            1: { name: '/run codice non compilabile', fn: (r) => compilationResult === null },
            2: { name: '/run codice ad alta copertura', fn: (r) => compilationResult !== null && userScore >= robotScore },
        };

        let runSuccess = check(runRes, {
            [checks[selectedCode].name]: checks[selectedCode].fn,
        });

        // Registra il successo delle richieste
        successRate.add(runRes.status === 200);
        errorRate.add(runRes.status !== 200);
        responseTime.add(runRes.timings.duration);

        sleep(Math.random() * 9 + 1);

        return canWin;
    } catch (e) {
        console.error(e);
        console.error(runRes);
        let runTimeout = check(runRes, {
            "/run timeout error": (r) => false,
        });

        return true;
    }
}

function endGame(playerId, jwt, email, canWin) {
    const runHeader = {
        headers: {
            'Content-Type': 'application/json',
        },
        cookies: {
            lang: 'en',
            jwt: jwt,
        },
    };

    const runPayload = JSON.stringify({
        playerId: playerId,
        mode: "PartitaSingola",
        testingClassCode: "",
        remainingTime: 1,
    });

    let runRes = http.post('http://localhost/EndGame', runPayload, runHeader);

    const endBody = JSON.parse(runRes.body);
    console.log(endBody);

    if (runRes.status > 299) {
        console.error(`Errore /EndGame per ${email}:`, runRes.body);
    } else {
        console.log(`/EndGame OK per ${email}`);
    }

    let runSuccess = check(runRes, {
        'Terminazione partita completata con successo': (r) => r.status === 200,
    });

    sleep(Math.random() * 9 + 1);
}
