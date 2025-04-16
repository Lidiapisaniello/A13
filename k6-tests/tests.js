import http from 'k6/http';
import { check, sleep } from 'k6';
import { randomString } from 'https://jslib.k6.io/k6-utils/1.4.0/index.js';

export let options = {
    stages: [
        { duration: '1m', target: 1 },
        //{ duration: '3m', target: 50 },
        //{ duration: '2m', target: 70 },
        //{ duration: '1m', target: 0 },
    ],
};

let users = [];
let jwtTokens = {};

export default function () {

    let name = `User${randomString(5)}`;
    let surname = `Test${randomString(5)}`;
    let email = `${randomString(5)}@e.com`;
    let password = `Test@1234`;

    let payload = {
        name: name,
        surname: surname,
        email: email,
        password: password,
        check_password: password,
        studies: 'BSc',
    };

    let params = {
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
    };

    // **Fase 1: Registrazione**
    let resRegister = http.post('http://localhost/register', payload, params);

    let registrationSuccess = check(resRegister, {
        'Registrazione avvenuta con successo': (r) => r.status === 200 || r.status === 201 || r.status === 302,
    });

    if (registrationSuccess) {
        users.push({ email: email, password: password });
        sleep(1);
    } else {
        console.log(`Registrazione fallita: ${resRegister.status}`);
        return;
    }

    // **Fase 2: Login**
    let loginPayload = {
        email: email,
        password: password,
    };

    /*
     * {redirects: 0} è necessario per catturare l'header della risposta di redirect, che contiene nei cookie il valore del
     * jwt.
     * L'operazione GET /login restituisce un redirect a /main in caso di successo; k6 cattura solo la risposta
     * di GET /main (200) e non quella del redirect (302), che contiene i cookie di interesse.
     *
     * https://community.grafana.com/t/issues-extracting-details-from-http-redirects/132061
     */
    let resLogin = http.post('http://localhost/login', loginPayload, {...params, redirects: 0});

    let loginSuccess = check(resLogin, {
        'Login avvenuto con successo': (r) => r.status === 200 || r.status === 302,
    });

    if (!loginSuccess) {
        console.log(`Login fallito: ${resLogin.status}`);
        return;
    }

    console.log(resLogin.headers);
    console.log(resLogin.status);

    let cookies = resLogin.cookies;
    let jwt = null;

    if (cookies) {
        const jwtCookie = cookies.jwt[0].value;
        if (jwtCookie) {
            console.log(jwtCookie);
            jwt = parseJwt(jwtCookie);
            console.log('JWT estratto dal cookie:', jwt);
        } else {
            console.log('JWT non trovato nei cookie');
        }
    } else {
        console.log('Nessun cookie nella risposta');
    }

    if (jwt === null)
        return;

    jwtTokens[email] = jwt;
    sleep(1);

    // **Fase 3: Avvio partita**
    let authParams = {
        headers: {
            'Content-Type': 'application/json',
        },
        cookies: {
            lang: 'en',
            jwt: `${jwtTokens[email]}`,
        },
    };

    let startGameBody = {
        difficulty: "1",
        mode: "PartitaSingola",
        playerId: parseJwt(jwtTokens[email]),
        remainingTime: 7200,
        typeRobot: "Randoop",
        underTestClassName: "StringParser",
    }

    let resAuthCheck = http.post('http://localhost/StartGame', startGameBody, authParams);

    check(resAuthCheck, {
        'Accesso a endpoint /StartGame riuscito': (r) => r.status === 200,
    });

    if (resAuthCheck.status !== 200) {
        console.log(`Errore accesso endpoint protetto: ${resAuthCheck.status}, Body: ${resAuthCheck.body}`);
    }

    sleep(1);
}

const parseJwt = (token) => {
    try {
        return JSON.parse(atob(token.split(".")[1]));
    } catch (e) {
        console.error(e);
        return null;
    }
};