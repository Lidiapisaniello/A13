import http from 'k6/http';
import { check, group, sleep } from 'k6';
import { Trend, Rate, Counter } from 'k6/metrics';
import { parseJwt } from "./util.js";
import { scenario } from 'k6/execution';
import { textSummary } from 'https://jslib.k6.io/k6-summary/0.0.1/index.js';

// Endpoint ngrok
//const ENDPOINT = "https://51b5-143-225-28-159.ngrok-free.app";
const ENDPOINT = "http://localhost";

// Test type
const testType = 1

// Codici utente da testare per StringParser
const users = JSON.parse(open('./users.json'));
const code = [
    open('./TestCode/TestStringParser_empty.java'),
    open('./TestCode/TestStringParser_notCompile.java'),
    open('./TestCode/TestStringParser_win.java')
];

// Metriche custom
export let run_duration = new Trend('run_duration', true);                                                    // Durata (ms) di ogni chiamata all'endpoint /run
export let run_duration_successful = new Trend('run_duration_successful', true);                              // Durata (ms) di ogni chiamata all'endpoint /run terminata con successo
export let run_duration_successful_with_retries = new Trend('run_duration_successful_with_retry', true);      // Durata (ms) di ogni chiamata all'endpoint /run terminata con successo contando il tempo dei retries
export let failed_run_duration = new Trend('run_duration_failure', true);                                     // Durata (ms) di ogni chiamata all'endpoint /run non completata per errore 504 o 429
export let failed_run_duration_other_errors = new Trend('run_duration_failure_other', true);                  // Durata (ms) di ogni chiamata all'endpoint /run non completata per altri motivi

export let total_retries = new Counter('total_retries');                                                // Numero totale di retry su /run per errori 504 o 429
export let retry_due_to_timeout = new Counter('retry_due_to_timeout');                                  // Numero totale di retry su /run per errori 504
export let retry_due_to_too_many_requests = new Counter('retry_due_to_too_many_requests');              // Numero totale di retry su /run per errori 429

export let delay_between_retry = new Trend('delay_between_retry', true);                                                  // Tempo (ms) di sleep tra retries
export let successful_run_rate = new Rate('successful_run_rate');                                                   // Tasso di fallimento delle chiamate a /run
export let successful_run_rate_after_retries = new Rate('successful_run_rate_after_retries');                       // Tasso di successo delle chiamate a /run
export let total_failed_run_rate = new Rate('total_failed_run_rate');                                               // Tasso di successo delle chiamate a /run con retries
export let failed_run_due_to_gateway_timeout_rate = new Rate('failed_run_due_to_gateway_timeout_rate');             // Numero di errori 504 GATEWAY_TIMEOUT ricevuti da /run
export let failed_run_due_to_too_many_requests_rate = new Rate('failed_run_due_to_too_many_requests_rate');         // Numero di errori 429 TOO_MANY_REQUESTS ricevuti da /run
export let successful_run_count = new Counter('successful_run_count');                                              // Numero di chiamate /run completate con successo
export let failed_run_count_total = new Counter('failed_run_count_total');                                          // Numero totale di chiamate /run fallite
export let failed_run_count_due_to_max_retry = new Counter('failed_run_count_due_to_max_retry');                    // Chiamate fallite definitivamente per superamento retry su timeout/too many requests

export let total_retry_attempts = new Trend('run_retry_count');                   // Numero di retry per ogni chiamata a /run andata in timeout

export let checkEmptyCode = new Counter('check_empty_code');                    // Codice vuoto compilato correttamente (caso test 0)
export let checkNotCompilable = new Counter('check_not_compilable');            // Codice non compilabile (caso test 1)
export let checkHighCoverage = new Counter('check_high_coverage');              // Codice con copertura >= robot (caso test 2)

// Configurazione
export const options = {
    ext: {
        influxdb: {
            url: 'http://localhost:9090',
            database: 'k6db',
            precision: 's',
        },
    },
    scenarios: {
        // Scenario attuale
        mixed: {
            executor: 'per-vu-iterations',
            vus: 70,
            iterations: 1,
            maxDuration: '120m',
        },
    },
};

export default function () {
    startGame()
}

function weightedRandom() {
    const weights = [0.2, 0.1, 0.7]; // 0, 1, 2
    const r = Math.random();
    let acc = 0;
    for (let i = 0; i < weights.length; i++) {
        acc += weights[i];
        if (r < acc) return i;
    }
    return weights.length - 1;
}

// ==============================
// Avvio partita
// ==============================
function startGame() {
    sleep(Math.random() * 9 + 1);
    const vuIndex = __VU - 1;
    const user = users[vuIndex % users.length];
    const email = user.email;
    const password = user.password;

    const loginPayload = { email, password };
    /*
    * {redirects: 0} è necessario per catturare l'header della risposta di redirect, che contiene nei cookie il valore del
    * jwt.
    * L'operazione GET /login restituisce un redirect a /main in caso di successo; k6 cattura solo la risposta
    * di GET /main (200) e non quella del redirect (302), che contiene i cookie di interesse.
    *
    * https://community.grafana.com/t/issues-extracting-details-from-http-redirects/132061
    */
    const loginHeader = { headers: { 'Content-Type': 'application/x-www-form-urlencoded' }, redirects: 0 };
    let resLogin = http.post(`${ENDPOINT}/login`, loginPayload, loginHeader);

    if (!(check(resLogin, { 'Login success': (r) => r.status === 200 || r.status === 302 }))) return;

    let jwt = resLogin.cookies?.jwt?.[0]?.value;
    let playerId = parseJwt(jwt).userId;
    sleep(Math.random() * 9 + 1);

    const mainHeader = { cookies: { lang: 'en', jwt } };
    http.get(`${ENDPOINT}/main`, null, mainHeader);

    const gameModeHeader = { "Content-Type": "application/json" };
    http.get(`${ENDPOINT}/session/gamemode/${playerId}?mode=PartitaSingola`, null, gameModeHeader);

    const startGamePayload = JSON.stringify({
        playerId, typeRobot: "Randoop", difficulty: "1", mode: "PartitaSingola",
        underTestClassName: "StringParser", remainingTime: 7200
    });

    const startGameHeader = {
        headers: { 'Content-Type': 'application/json' },
        cookies: { lang: 'en', jwt }
    };

    let startGameRes = http.post(`${ENDPOINT}/StartGame`, startGamePayload, startGameHeader);
    check(startGameRes, { 'StartGame success': (r) => r.status === 200 });

    sleep(Math.random() * 59 + 1);

    const timeToExit = scenario.time_remaining - (Math.random() * (5 - 2) * 60 * 1000 + 2 * 60 * 1000);
    let canWin = false;


    if (testType === 0) {
        while (true) {
            let selectedCode = weightedRandom()
            let canWin = false;

            group('T5 /run', () => {
                canWin = runGame(playerId, jwt, email, selectedCode);
            });

            if ((canWin && Math.random() < 0.25) || (!canWin && Math.random() < 0.05)) break;
            if (scenario.time_remaining <= timeToExit) break;
        }
    } else {
        for (let i = 0; i < 10; i++) {
            const timeToExit = scenario.time_remaining - (Math.random() * (5 - 2) * 60 * 1000 + 2 * 60 * 1000);
            let canWin = false;

            group('T5 /run', () => {
                canWin = runGame(playerId, jwt, email, 2);
            });

            if (scenario.time_remaining <= timeToExit) break;
        }
    }


    endGame(playerId, jwt, email, canWin);
}

// ==============================
// Esecuzione partita
// ==============================
function runGame(playerId, jwt, email, selectedCode) {
    const testCode = code[selectedCode];

    let retryCount = 0;
    let baseDelay = 60; // 60 secondi
    // let totalDelay = 0;
    const maxRetries = 10;

    const runPayload = JSON.stringify({
        playerId,
        mode: "PartitaSingola",
        testingClassCode: testCode,
        remainingTime: 7000,
    });

    const runHeader = {
        headers: { 'Content-Type': 'application/json' },
        cookies: { lang: 'en', jwt },
        timeout: '600s'
    };

    const startTime = Date.now();
    while (retryCount < maxRetries) {
        const startTryTime = Date.now();
        let res = http.post(`${ENDPOINT}/run`, runPayload, runHeader);
        const endTryTime = Date.now();
        const duration = endTryTime - startTryTime;

        run_duration.add(duration); // Tempo di risposta totale

        let body = null;
        try {
            body = JSON.parse(res.body);
        } catch (e) {
            body = null;
        }

        const is504Error = body !== null && (res.status === 504 || (body && res.body.includes('504 GATEWAY_TIMEOUT')));
        const is429Error = body !== null && ( res.status === 429 || (body && res.body.includes('429 TOO_MANY_REQUESTS')));

        successful_run_rate.add(body !== null && res.status <= 299);
        total_failed_run_rate.add(body === null || (body && res.status > 299));

        if (body !== null && res.status <= 299) {
            successful_run_rate_after_retries.add(retryCount === 0);
        } else {
            failed_run_due_to_gateway_timeout_rate.add(is504Error);
            failed_run_due_to_too_many_requests_rate.add(is429Error);
        }

        if (is504Error || is429Error) {
            failed_run_duration.add(duration);

            retryCount++;

            total_retries.add(1);
            if (is504Error) {
                retry_due_to_timeout.add(1);
                failed_run_due_to_gateway_timeout_rate.add(1);
            } else {
                retry_due_to_too_many_requests.add(1);
                failed_run_due_to_too_many_requests_rate.add(1);
            }

            const delay = Math.random() * 30 + baseDelay * retryCount;
            // totalDelay += delay;
            delay_between_retry.add(delay * 1000);

            if (retryCount === maxRetries) {
                // Timeout definitivo
                failed_run_count_due_to_max_retry.add(1);
                failed_run_count_total.add(1);
                total_retry_attempts.add(retryCount);
                console.error(`Timeout definitivo per ${email} dopo ${retryCount} tentativi`);
                return false;
            }

            console.warn(`Tentativo ${retryCount} fallito per timeout. Ritento tra ${delay.toFixed(2)}s...`);
            sleep(delay);
            continue;
        }

        if (body !== null) {
            const compilationResult = body.userCoverageDetails?.xml_coverage;
            const userScore = body.userScore;
            const robotScore = body.robotScore;
            const canWin = body.canWin;

            if (res.status > 299) {
                failed_run_duration_other_errors.add(duration);
                failed_run_count_total.add(1);
                console.error(`/run error ${res.status}: `, body);
            } else {
                run_duration_successful.add(duration);

                if (retryCount !== 0)
                    run_duration_successful_with_retries.add(endTryTime - startTime);

                successful_run_count.add(1);
            }

            const checks = {
                2: { name: '/run codice ad alta copertura', fn: () => compilationResult !== null && userScore >= robotScore, metric: checkHighCoverage },
            };

            const checkResult = check(res, {
                [checks[selectedCode].name]: checks[selectedCode].fn
            });
            if (checkResult) checks[selectedCode].metric.add(1);

            total_retry_attempts.add(retryCount); // anche se è 0

            sleep(Math.random() * 59 + 1);
            return canWin;

        } else {
            failed_run_count_total.add(1);
            console.error(`/run error parsing response: `, res);
            return false;
        }
    }

    // Fallback finale se esce dal ciclo
    failed_run_count_total.add(1);
    failed_run_count_due_to_max_retry.add(1);
    total_retry_attempts.add(retryCount);
    return false;
}

// ==============================
// Chiusura partita
// ==============================
function endGame(playerId, jwt, email, canWin) {
    const payload = JSON.stringify({
        playerId,
        mode: "PartitaSingola",
        testingClassCode: "",
        remainingTime: 1
    });

    const headers = {
        headers: { 'Content-Type': 'application/json' },
        cookies: { lang: 'en', jwt }
    };

    let res = http.post(`${ENDPOINT}/EndGame`, payload, headers);
    check(res, { 'EndGame success': (r) => r.status === 200 });
    sleep(Math.random() * 9 + 1);
}


// ==============================
// Funzione per stampare i risultati
// ==============================
export function handleSummary(data) {
    const now = new Date();
    const pad = (n) => (n < 10 ? '0' + n : n);
    const timestamp = `${pad(now.getDate())}-${pad(now.getMonth() + 1)}-${now.getFullYear()}_${pad(now.getHours())}-${pad(now.getMinutes())}-${pad(now.getSeconds())}`;
    const filePath = `summary-${timestamp}.json`;

    return {
        [filePath]: JSON.stringify(data, null, 2),
        stdout: textSummary(data, { indent: ' ', enableColors: true }),
    };
}



/*
// ==============================
// Stampa risultati
// ==============================
export function handleSummary(data) {
    const now = new Date();
    const pad = (n) => (n < 10 ? '0' + n : n);
    const timestamp = `${pad(now.getDate())}-${pad(now.getMonth() + 1)}-${now.getFullYear()}_${pad(now.getHours())}-${pad(now.getMinutes())}`;
    const filePath = `summary-${timestamp}.json`;

    const metrics = data.metrics;

    // Funzione per convertire secondi/millisecondi nel formato "XmYs"
    function convertToMinSecFormat(value, unit) {
        if (unit === "ms") value /= 1000; // Se millisecondi, trasformiamo in secondi
        const minutes = Math.floor(value / 60);
        const seconds = Math.floor(value % 60);
        return `${minutes}m${seconds < 10 ? '0' : ''}${seconds}s`;
    }

    // Elenco delle metriche che rappresentano TEMPI
    const timeMetrics = [
        'run_duration',
        'run_retry_delay',
        'run_total_retry_delay'
    ];

    const summary = {};

    for (const [name, metric] of Object.entries(metrics)) {
        const isTimeMetric = timeMetrics.includes(name);

        summary[name] = {
            type: metric.type,
            unit: metric.unit,
            count: metric.count,
            min: isTimeMetric ? convertToMinSecFormat(metric.min, metric.unit) : metric.min,
            max: isTimeMetric ? convertToMinSecFormat(metric.max, metric.unit) : metric.max,
            avg: isTimeMetric ? convertToMinSecFormat(metric.avg, metric.unit) : metric.avg,
            p90: isTimeMetric ? convertToMinSecFormat(metric['p(90)'], metric.unit) : metric['p(90)'],
            p95: isTimeMetric ? convertToMinSecFormat(metric['p(95)'], metric.unit) : metric['p(95)'],
        };
    }

    return {
        [filePath]: JSON.stringify(summary, null, 2),
        stdout: textSummary(data, { indent: ' ', enableColors: true }),
    };
}

 */