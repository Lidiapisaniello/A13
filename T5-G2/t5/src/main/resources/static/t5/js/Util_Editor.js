/*
 *   Copyright (c) 2024 Stefano Marano https://github.com/StefanoMarano80017
 *   All rights reserved.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

/* UTIL_Editor.js
   Funzioni di utilità per l'editor.
*/

// === FUNZIONI PER COSTRUIRE L'URL E IL REPORT ===
function createApiUrl(formData, orderTurno) {
	const underTestClassName = localStorage.getItem("underTestClassName");
	const playerId = formData.get("playerId");
	// Costruisce il percorso per la classe
	formData.append("className", underTestClassName);
	const classePath = `VolumeT0/FolderTree/ClassUT/unmodified_src/${underTestClassName}/${underTestClassName}.java`;
	// Ottiene il percorso del test generato
	const testPath = generaPercorsoTest(orderTurno, formData);
	// Costruisce l'URL dell'API
	const apiUrl = `/api/${classePath}+${testPath}+/app+${playerId}`;
	return apiUrl;
}

// Funzione per generare il percorso del test
function generaPercorsoTest(orderTurno, formData) {
	let modalita = localStorage.getItem("modalita");
	const playerId = formData.get("playerId");
	const gameId = formData.get("gameId");
	const roundId = formData.get("roundId");
	const classeLocal = formData.get("className");

	modalita = (modalita === "Allenamento") ? "Sfida" : modalita;
	
	// Verifica la modalità e costruisce il percorso appropriato
	if (modalita === "Scalata" || modalita === "Sfida") {
		const scalataPart =
			modalita === "Scalata"
				? `/${localStorage.getItem("SelectedScalata")}${localStorage.getItem(
						"scalataId"
				  )}`
				: "";

		return `/VolumeT0/FolderTree/StudentLogin/Player${playerId}/${modalita}${scalataPart}/${classeLocal}/Game${gameId}/Round${roundId}/Turn${orderTurno}/TestReport`;
	} else {
		console.error("Errore: modalità non trovata");
		window.location.href = "/main";
		return null;
	}
}

// Funzione per estrarre la terza colonna di un CSV
function extractThirdColumn(csvContent) {
	const rows = csvContent.split("\n"); // Divide le righe
	const thirdColumnValues = [];

	// Inizia il ciclo dalla seconda riga (indice 1)
	rows.slice(1).forEach((row) => {
		const cells = row.split(","); // Divide le celle
		if (cells.length >= 3) {
			thirdColumnValues.push(cells[2]); // Aggiunge la terza colonna
		}
	});

	return thirdColumnValues;
}

// === FUNZIONI PER GENERARE IL TESTO DI OUTPUT ===
const you_win = `
__     ______  _    _  __          _______ _   _ 
\\ \\   / / __ \\| |  | | \\ \\        / /_   _| \\ | |
 \\ \\_/ / |  | | |  | |  \\ \\  /\\  / /  | | |  \\| |
  \\   /| |  | | |  | |   \\ \\/  \\/ /   | | | . \` |
   | | | |__| | |__| |    \\  /\\  /   _| |_| |\\  |
   |_|  \\____/ \\____/      \\/  \\/   |_____|_| \\_|
`;

const you_lose = `
__     ______  _    _   _      ____   _____ ______ 
\\ \\   / / __ \\| |  | | | |    / __ \\ / ____|  ____|
 \\ \\_/ / |  | | |  | | | |   | |  | | (___ | |__   
  \\   /| |  | | |  | | | |   | |  | |\\___ \\|  __|  
   | | | |__| | |__| | | |___| |__| |____) | |____ 
   |_|  \\____/ \\____/  |______\\____/|_____/|______|
`;

const error = `
______ _____  _____   ____   _____  
|  ____|  __ \|  __ \ / __ \ / ____| 
| |__  | |__) | |__) | |  | | (___   
|  __| |  _  /|  _  /| |  | |\___ \  
| |____| | \ \| | \ \| |__| |____) | 
|______|_|  \_\_|  \_\\____/|_____/  
`;

function getConsoleTextCoverage(valori_csv, robotEvoSuiteCoverage, coverageDetails, robotJacocoCoverage) {
	let lineCoveragePercentage = roundToTwoDecimals(coverageDetails.line.covered / (coverageDetails.line.covered + coverageDetails.line.missed) * 100);
	let BranchCoveragePercentage = roundToTwoDecimals(coverageDetails.branch.covered / (coverageDetails.branch.covered + coverageDetails.branch.missed) * 100);
	let instructionCoveragePercentage = roundToTwoDecimals(coverageDetails.instruction.covered / (coverageDetails.instruction.covered + coverageDetails.instruction.missed) * 100);

	let robotLineCoveragePercentage = roundToTwoDecimals(robotJacocoCoverage.line.covered / (robotJacocoCoverage.line.covered + robotJacocoCoverage.line.missed) * 100);
	let robotBranchCoveragePercentage = roundToTwoDecimals(robotJacocoCoverage.branch.covered / (robotJacocoCoverage.branch.covered + robotJacocoCoverage.branch.missed) * 100);
	let robotInstructionCoveragePercentage = roundToTwoDecimals(robotJacocoCoverage.instruction.covered / (robotJacocoCoverage.instruction.covered + robotJacocoCoverage.instruction.missed) * 100);

	consoleText =
`============================== JaCoCo ===============================
Your Line Coverage COV%:  ${lineCoveragePercentage}% LOC
covered: ${coverageDetails.line.covered}  
missed: ${coverageDetails.line.missed}
Robot Line Coverage COV%:  ${robotLineCoveragePercentage}% LOC
robot covered: ${robotJacocoCoverage.line.covered}
robot missed: ${robotJacocoCoverage.line.missed}
----------------------------------------------------------------------
Your Branch Coverage COV%:  ${BranchCoveragePercentage}% LOC
covered: ${coverageDetails.branch.covered} 
missed: ${coverageDetails.branch.missed}
Robot Branch Coverage COV%:  ${robotBranchCoveragePercentage}% LOC
robot covered: ${robotJacocoCoverage.branch.covered}
robot missed: ${robotJacocoCoverage.branch.missed}
----------------------------------------------------------------------
Your Instruction Coverage COV%:  ${instructionCoveragePercentage}% LOC
covered: ${coverageDetails.instruction.covered} 
missed: ${coverageDetails.instruction.missed}
Robot Instruction Coverage COV%:  ${robotInstructionCoveragePercentage}% LOC
robot covered: ${robotJacocoCoverage.instruction.covered}
robot missed: ${robotJacocoCoverage.instruction.missed}
============================== EvoSuite ===============================
Il tuo punteggio EvoSuite:  ${roundToTwoDecimals(valori_csv[0]*100)}% Line
Il punteggio EvoSuite del robot:  ${roundToTwoDecimals(robotEvoSuiteCoverage[0])}% Line
----------------------------------------------------------------------
Il tuo punteggio EvoSuite: ${roundToTwoDecimals(valori_csv[1]*100)}% Branch
Il punteggio EvoSuite del robot: ${roundToTwoDecimals(robotEvoSuiteCoverage[1])}% Branch
----------------------------------------------------------------------
Il tuo punteggio EvoSuite: ${roundToTwoDecimals(valori_csv[2]*100)}% Exception
Il punteggio EvoSuite del robot: ${roundToTwoDecimals(robotEvoSuiteCoverage[2])}% Exception
----------------------------------------------------------------------
Il tuo punteggio EvoSuite: ${roundToTwoDecimals(valori_csv[3]*100)}% WeakMutation
Il punteggio EvoSuite del robot: ${roundToTwoDecimals(robotEvoSuiteCoverage[3])}% WeakMutation
----------------------------------------------------------------------
Il tuo punteggio EvoSuite: ${roundToTwoDecimals(valori_csv[7]*100)}% CBranch
Il punteggio EvoSuite del robot: ${roundToTwoDecimals(robotEvoSuiteCoverage[7])}% CBranch
======================================================================`;

	// Restituisce il testo generato
	return consoleText;
}

 
function roundToTwoDecimals(numStr) {
	return (Math.round(parseFloat(numStr * 100)) / 100).toFixed(2);
}

function getConsoleTextRun(valori_csv, robotEvoSuiteCoverage, coverageDetails, robotJacocoCoverage, gameScore, robotScore, isWinner) {
	let lineCoveragePercentage = roundToTwoDecimals(coverageDetails.line.covered / (coverageDetails.line.covered + coverageDetails.line.missed) * 100);
	let BranchCoveragePercentage = roundToTwoDecimals(coverageDetails.branch.covered / (coverageDetails.branch.covered + coverageDetails.branch.missed) * 100);
	let instructionCoveragePercentage = roundToTwoDecimals(coverageDetails.instruction.covered / (coverageDetails.instruction.covered + coverageDetails.instruction.missed) * 100);

	let robotLineCoveragePercentage = roundToTwoDecimals(robotJacocoCoverage.line.covered / (robotJacocoCoverage.line.covered + robotJacocoCoverage.line.missed) * 100);
	let robotBranchCoveragePercentage = roundToTwoDecimals(robotJacocoCoverage.branch.covered / (robotJacocoCoverage.branch.covered + robotJacocoCoverage.branch.missed) * 100);
	let robotInstructionCoveragePercentage = roundToTwoDecimals(robotJacocoCoverage.instruction.covered / (robotJacocoCoverage.instruction.covered + robotJacocoCoverage.instruction.missed) * 100);

	var consoleText2 = (valori_csv[0]*100) >= robotScore ? you_win : you_lose;
	consoleText =
`===================================================================== \n` +
		consoleText2 +
		"\n" +
`============================== Results ===============================
Il tuo punteggio:${gameScore}pt
----------------------------------------------------------------------
Il punteggio del robot:${robotScore}pt
============================== JaCoCo ===============================
Your Line Coverage COV%:  ${lineCoveragePercentage}% LOC
covered: ${coverageDetails.line.covered}  
missed: ${coverageDetails.line.missed}
Robot Line Coverage COV%:  ${robotLineCoveragePercentage}% LOC
robot covered: ${robotJacocoCoverage.line.covered}
robot missed: ${robotJacocoCoverage.line.missed}
----------------------------------------------------------------------
Your Branch Coverage COV%:  ${BranchCoveragePercentage}% LOC
covered: ${coverageDetails.branch.covered} 
missed: ${coverageDetails.branch.missed}
Robot Branch Coverage COV%:  ${robotBranchCoveragePercentage}% LOC
robot covered: ${robotJacocoCoverage.branch.covered}
robot missed: ${robotJacocoCoverage.branch.missed}
----------------------------------------------------------------------
Your Instruction Coverage COV%:  ${instructionCoveragePercentage}% LOC
covered: ${coverageDetails.instruction.covered} 
missed: ${coverageDetails.instruction.missed}
Robot Instruction Coverage COV%:  ${robotInstructionCoveragePercentage}% LOC
robot covered: ${robotJacocoCoverage.instruction.covered}
robot missed: ${robotJacocoCoverage.instruction.missed}
============================== EvoSuite ===============================
Il tuo punteggio EvoSuite:  ${roundToTwoDecimals(valori_csv[0]*100)}% Line
Il punteggio EvoSuite del robot:  ${roundToTwoDecimals(robotEvoSuiteCoverage[0])}% Line
----------------------------------------------------------------------
Il tuo punteggio EvoSuite: ${roundToTwoDecimals(valori_csv[1]*100)}% Branch
Il punteggio EvoSuite del robot: ${roundToTwoDecimals(robotEvoSuiteCoverage[1])}% Branch
----------------------------------------------------------------------
Il tuo punteggio EvoSuite: ${roundToTwoDecimals(valori_csv[2]*100)}% Exception
Il punteggio EvoSuite del robot: ${roundToTwoDecimals(robotEvoSuiteCoverage[2])}% Exception
----------------------------------------------------------------------
Il tuo punteggio EvoSuite: ${roundToTwoDecimals(valori_csv[3]*100)}% WeakMutation
Il punteggio EvoSuite del robot: ${roundToTwoDecimals(robotEvoSuiteCoverage[3])}% WeakMutation
----------------------------------------------------------------------
Il tuo punteggio EvoSuite: ${roundToTwoDecimals(valori_csv[7]*100)}% CBranch
Il punteggio EvoSuite del robot: ${roundToTwoDecimals(robotEvoSuiteCoverage[7])}% CBranch
======================================================================`;

	// Restituisce il testo generato
	return consoleText;
}

function getConsoleTextError(){
	return  `===================================================================== \n` 
			+ error +  "\n" +
			`============================== Results =============================== \n
			Ci sono stati errori di compilazione, controlla la console !`;
}

// === FUNZIONI PER LA SESSIONE ===
async function fetchPreviousGameData() {
    const playerId = String(parseJwt(getCookie("jwt")).userId);
    const current_mode = GetMode();
    try {
        const response = await fetch(`/session/${playerId}`);
        const data = await response.json();
        if (
            data && 
            data.modalita &&
            data.modalita[current_mode] && 
            data.modalita[current_mode].gameobject) 
        {
            console.log("[fetchPreviousGameData] Trovato gameobject per la modalità " + current_mode + ":", data.modalita[current_mode].gameobject);
            return data.modalita[current_mode].gameobject;
        }
        return null;
    } catch (error) {
        console.error("Errore durante il recupero della sessione:", error);
        return null;
    }
}

async function getFormData() {
	const formData = new FormData();
    const gameObject = await fetchPreviousGameData();
    if (gameObject) {
        console.log("[getFormData] Recuperato game object dalla sessione:", gameObject);
        formData.append("playerId", gameObject.player_id);
        formData.append("mode", gameObject.mode.toLowerCase());
        formData.append("underTestClassName", gameObject.class_ut);
        if (gameObject.game_id) formData.append("gameId", gameObject.game_id);
        if (gameObject.round_id) formData.append("roundId", gameObject.round_id);
        formData.append("testingClassCode", editor_utente.getValue());
    } else {
        console.warn("[getFormData] Nessun game object trovato in sessione;");
    }

	return formData;
}

// Funzione per analizzare l'output di Maven
function parseMavenOutput(output) {
    const lines = output.split('\n');
    let results = {
        errors: 0,
        warnings: 0
    };

    lines.forEach(line => {
        // Regex per contare avvisi
        const warningMatch = line.match(/^\[INFO\] (\d+) warning/);
        if (warningMatch) {
            results.warnings = parseInt(warningMatch[1], 10);
        }

        // Regex per contare errori
        const errorMatch = line.match(/^\[INFO\] (\d+) error/);
        if (errorMatch) {
            results.errors = parseInt(errorMatch[1], 10);
        }
    });

	document.getElementById("error_compiler").textContent = results.errors;
	document.getElementById("warning_compiler").textContent =  results.warnings;
    return results;
}

async function ajaxRequest(url, method = "POST", data = null, isJson = true, dataType = "json") {
    try {
        let processedData, contentType, processData;
        if (data instanceof FormData) {
            processedData = data;
            contentType = false;
            processData = false;
        } else {
            processedData = isJson && data ? JSON.stringify(data) : data;
            contentType = isJson ? "application/json; charset=UTF-8" : false;
            processData = true;
        }
        const options = {
            url: url,
            type: method,
            dataType: dataType,
            data: processedData,
            contentType: contentType,
            processData: processData,
            xhrFields: { withCredentials: true }
        };
        console.log("[ajaxRequest] Options:", options);
        const response = await $.ajax(options);
        console.log("[ajaxRequest] Risposta:", response);
        return response;
    } catch (error) {
        console.error("Si è verificato un errore in ajaxRequest:", error);
        throw error;
    }
}

function toggleLoading(showSpinner, divId, buttonId) {
	const divElement = document.getElementById(divId);
	const button = document.getElementById(buttonId);
	if (!divElement) {
		console.error(`Elemento con ID "${divId}" non trovato.`);
		return;
	}
	const spinner = divElement.querySelector(".spinner-border");
	const statusText = divElement.querySelector('[role="status"]');
	const icon = divElement.querySelector("i");
	if (showSpinner) {
		spinner.style.display = "inline-block"; // Mostra lo spinner
		statusText.innerText = loading; // Mostra il testo "Loading..."
		icon.style.display = "none"; // Nascondi l'icona
	} else {
		spinner.style.display = "none"; // Nascondi lo spinner
		statusText.innerText =  statusText.getAttribute('data-title'); // Nascondi il testo "Loading..."
		icon.style.display = "inline-block"; // Mostra l'icona
	}
}

// Definizione degli stati predefiniti
const statusMessages = {
	sending:    { showSpinner: true,  text: status_sending	},
    loading: 	{ showSpinner: true,  text: status_loading  },
    compiling: 	{ showSpinner: true,  text: status_compiling},
    ready: 		{ showSpinner: false, text: status_ready 	},
    error: 		{ showSpinner: false, text: status_error    },
	turn_end:   { showSpinner: false, text: status_turn_end },
	game_end:   { showSpinner: false, text: status_game_end }
};

// Funzione per comunicare lo stato in cui si trova l'editor 
function setStatus(statusName) {
    const divElement = document.getElementById("status_compiler");
    if (!divElement) {
        console.error(`Elemento con ID "status_compiler" non trovato.`);
        return;
    }
    const spinner = divElement.querySelector(".spinner-border");
    const statusText = divElement.querySelector('#status_text');
    const icon = divElement.querySelector("i");
    // Recupera le impostazioni per lo stato specificato
    const status = statusMessages[statusName];
    if (!status) {
        console.error(`Stato "${statusName}" non definito.`);
        return;
    }
    // Controlla lo stato attuale dello spinner e inverte la visibilità
    if (status.showSpinner) {
        spinner.style.display = "inline-block"; // Mostra lo spinner
        statusText.innerText = status.text; // Mostra il testo personalizzato
        icon.style.display = "none"; // Nascondi l'icona
    } else {
        spinner.style.display = "none"; // Nascondi lo spinner
        statusText.innerText = status.text; // Mostra il testo personalizzato
        icon.style.display = "inline-block"; // Mostra l'icona
    }
}

function highlightCodeCoverage(reportContent, robotContent, editor) {
	// Analizza il contenuto del file di output di JaCoCo per individuare le righe coperte, non coperte e parzialmente coperte
	// Applica lo stile appropriato alle righe del tuo editor
	var coveredLines = [];
	var uncoveredLines = [];
	var partiallyCoveredLines = [];

	var coveredLinesRobot = [];
	var uncoveredLinesRobot = [];
	var partiallyCoveredLinesRobot = [];

	reportContent.querySelectorAll("line").forEach(function (line) {
		if (line.getAttribute("mi") == 0)
			coveredLines.push(line.getAttribute("nr"));
		else if (line.getAttribute("mb") > 0 && line.getAttribute("cb") > 0)
			partiallyCoveredLines.push(line.getAttribute("nr"));
		else uncoveredLines.push(line.getAttribute("nr"));
	});

	robotContent.querySelectorAll("line").forEach(function (line) {
		if (line.getAttribute("mi") == 0)
			coveredLinesRobot.push(line.getAttribute("nr"));
		else if (line.getAttribute("mb") > 0 && line.getAttribute("cb") > 0)
			partiallyCoveredLinesRobot.push(line.getAttribute("nr"));
		else uncoveredLinesRobot.push(line.getAttribute("nr"));
	});

	coveredLinesRobot.forEach(function (lineNumber) {
		editor.removeLineClass(lineNumber - 2, "gutter", "bg-danger");
		editor.removeLineClass(lineNumber - 2, "gutter", "bg-warning");
		editor.addLineClass	(lineNumber - 2, "gutter", "  bg-success");
	});

	uncoveredLinesRobot.forEach(function (lineNumber) {
		editor.removeLineClass(lineNumber - 2, "gutter", "bg-warning");
		editor.removeLineClass(lineNumber - 2, "gutter", "bg-success");
		editor.addLineClass	(lineNumber - 2, "gutter", "bg-danger");
	});

	partiallyCoveredLinesRobot.forEach(function (lineNumber) {
		editor.removeLineClass(lineNumber - 2, "gutter", "bg-danger");
		editor.removeLineClass(lineNumber - 2, "gutter", "bg-success");
		editor.addLineClass	(lineNumber - 2, "gutter", "bg-warning");
	});

	coveredLines.forEach(function (lineNumber) {
		editor.removeLineClass(lineNumber - 2, "background", "bg-coverage-danger");
		editor.removeLineClass(lineNumber - 2, "background", "bg-coverage-warning");
		editor.addLineClass	(lineNumber - 2, "background", " bg-coverage-success");
	});

	uncoveredLines.forEach(function (lineNumber) {
		editor.removeLineClass(lineNumber - 2, "background", "bg-coverage-warning");
		editor.removeLineClass(lineNumber - 2, "background", "bg-coverage-success");
		editor.addLineClass	(lineNumber - 2, "background", "bg-coverage-danger");
	});

	partiallyCoveredLines.forEach(function (lineNumber) {
		editor.removeLineClass(lineNumber - 2, "background", "bg-coverage-danger");
		editor.removeLineClass(lineNumber - 2, "background", "bg-coverage-success");
		editor.addLineClass	(lineNumber - 2, "background", "bg-coverage-warning");
	});

	// Forzo il refresh dell'editor, altrimenti il background viene caricato solo dopo aver scollato
	editor.refresh();
}

async function ajaxRequest(
	url,
	method = "POST",
	data = null,
	isJson = true,
	dataType = "json"
) {
	try {
		const options = {
			url: url,
			type: method,
			dataType: dataType,
			processData: isJson, // Set to true to encode data properly
			contentType: isJson
				? false
				: "application/x-www-form-urlencoded; charset=UTF-8",
			data: isJson && data ? $.param(data) : data, // Convert data to URL-encoded string
		};

		const response = await $.ajax(options);
		return response;
	} catch (error) {
		console.error("Si è verificato un errore:", error);
		throw error;
	}
}

async function ajaxRequest_ForT8(
	url,
	method = "POST",
	data = null,
	isJson = true,
	dataType = "json"
) {
	try {
		const options = {
			url: url,
			type: method,
			dataType: "text",
			processData: false, // Set to true to encode data properly
			contentType: "text/plain; charset=UTF-8",
			data: data, // Convert data to URL-encoded string
		};

		const response = await $.ajax(options);
		return response;
	} catch (error) {
		console.error("Si è verificato un errore:", error);
		throw error;
	}
}

async function ajaxRequest_ForStartGame(
	url,
	method = "POST",
	data = null,
	isJson = true,
	dataType = "json"
) {
	try {
		const options = {
			url: url,
			type: method,
			dataType: dataType,
			processData: !isJson, // Se è JSON, disabilita processData
			contentType: isJson ? "application/json" : "application/x-www-form-urlencoded; charset=UTF-8",
			data: isJson && data ? JSON.stringify(data) : data, // Serializza JSON
		};

		const response = await $.ajax(options);
		return response;
	} catch (error) {
		console.error("Si è verificato un errore:", error);
		throw error;
	}
}

async function ajaxRequest_ForRun(
	url,
	method = "POST",
	data = null,
	isFormData = false,
	dataType = "json"
) {
	try {
		const options = {
			url: url,
			type: method,
			processData: false, // Se è FormData, non elaborarlo
			contentType: false,
			data: data, // Passa i dati direttamente senza modificarli
		};

		const response = await $.ajax(options);
		return response;
	} catch (error) {
		console.error("Si è verificato un errore:", error);
		throw error;
	}
}





function controlloScalata(
	iswin,
	current_round_scalata,
	total_rounds_scalata,
	displayRobotPoints
) {
	// Check if the player has won the round
	if (isWin) {
		/*The player has won the round, check if the player has 
        completed the Scalata (current_round_scalata == total_rounds_scalata)
        */
		if (current_round_scalata == total_rounds_scalata) {
			// alert("Hai completato la scalata!");
			calculateFinalScore(localStorage.getItem("scalataId"))
				.then((data) => {
					console.log("calculateFinalScore response: ", data.finalScore);
					closeScalata(
						localStorage.getItem("scalataId"),
						true,
						data.finalScore,
						current_round_scalata
					).then((data) => {
						swal(
							"Complimenti!",
							`Hai completato la scalata!\n${displayRobotPoints}\n A breve verrai reindirizzato alla classifica.`,
							"success"
						).then((value) => {
							window.location.href = "/leaderboardScalata";
						});
					});
				})
				.catch((error) => {
					console.log("Error:", error);
					swal(
						"Errore!",
						"Si è verificato un errore durante il recupero dei dati. Riprovare.",
						"error"
					);
				});
		} else {
			//The player has completed the round, not the Scalata
			swal(
				"Complimenti!",
				`Hai completato il round ${current_round_scalata}/${total_rounds_scalata}!\n${displayRobotPoints}`,
				"success"
			).then((value) => {
				current_round_scalata++;
				localStorage.setItem("current_round_scalata", current_round_scalata);
				classe = getScalataClasse(
					current_round_scalata - 1,
					localStorage.getItem("scalata_classes")
				);
				localStorage.setItem("classe", classe);
				console.log(
					"[editor.js] classes in scalata: " +
						localStorage.getItem("scalata_classes") +
						"\n\
                      selected class: " +
						classe
				);
				incrementScalataRound(
					localStorage.getItem("scalataId"),
					current_round_scalata
				)
					.then((data) => {
						console.log(
							"[editor.js] Creating new game for next round in scalata with parameters: \
                Robot: evosuite\n\
                Classe: " +
								classe +
								"\n\
                Difficulty: 1\n\
                ScalataId: " +
								localStorage.getItem("scalataId") +
								"\n\
                Username: " +
								localStorage.getItem("username") +
								"."
						);
						createGame(
							"evosuite",
							classe,
							1,
							localStorage.getItem("scalataId"),
							localStorage.getItem("username")
						).then((data) => {
							console.log(data);
							window.location.href = "/editor";
						});
					})
					.catch((error) => {
						console.log("Error:", error);
						swal(
							"Errore!",
							"Si è verificato un errore durante il recupero dei dati. Riprovare.",
							"error"
						);
					});
			});
		}
	} else {
		//The player has lost the round
		closeScalata(
			localStorage.getItem("scalataId"),
			false,
			0,
			current_round_scalata
		)
			.then((data) => {
				console.log("Close Scalata response: ", data);
				swal(
					"Peccato!",
					`Hai perso al round ${current_round_scalata}/${total_rounds_scalata} della scalata, la prossima volta andrà meglio!\n${displayRobotPoints}`,
					"error"
				).then((value) => {
					window.location.href = "/main";
				});
			})
			.catch((error) => {
				console.log("Error:", error);
				swal(
					"Errore!",
					"Si è verificato un errore durante il recupero dei dati. Riprovare.",
					"error"
				);
			});
	}
}
// === FUNZIONI DI UTILITÀ PER L'EDITOR E LA SESSIONE ===

//Funzione per fare il replace del testo dell'editor 
function replaceText(text, replacements) {
    return text.replace(/\b(TestClasse|username|userID|date)\b/g, match => replacements[match] || match);
}

function SetInitialEditor(replacements) {
    const text = editor_utente.getValue();
    console.log("[SetInitialEditor] Testo originale:", text);
    const newContent = replaceText(text, replacements);
    console.log("[SetInitialEditor] Testo aggiornato:", newContent);
    editor_utente.setValue(newContent);
}

//Ottieni parametro dal URL
function getParameterByName(name) {
    const url = window.location.href;
    name = name.replace(/[\[\]]/g, "\\$&");
    const regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)");
    const results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return "";
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}

//DA CONTROLLARE
function GetMode() {
    const mode = getParameterByName("mode");
    if (mode) {
        const trimmed = mode.replace(/[^a-zA-Z0-9\s]/g, " ").trim();
        return (trimmed.toLowerCase() === "sfida") ? "Sfida" : trimmed;
    }
    return "Sfida";
}

// modal info
function openModalWithText(text_title, text_content, buttons = []) {
	document.getElementById('Modal_title').innerText = text_title;
	// Imposta il testo nel corpo del modal
	document.getElementById('Modal_body').innerText = text_content;

	// Pulisci eventuali bottoni esistenti nel footer
	var modalFooter = document.getElementById('Modal_footer');
	modalFooter.innerHTML = '';

	// Aggiungi bottoni personalizzati se sono stati forniti
	if (buttons.length > 0) {
		buttons.forEach(button => {
			let btn = document.createElement('a');
			btn.innerText = button.text;
			btn.href = button.href;  // Assegna il link al pulsante
			btn.className = button.class || 'btn btn-primary'; // Classe di default se non specificata
			btn.target = button.target || '_self'; // Target opzionale, default è nella stessa finestra
			modalFooter.appendChild(btn);
		});
	}

	// Ottieni il modal
	var modal = new bootstrap.Modal(document.getElementById('Modal'));

	// Mostra il modal
	modal.show();
}

// modal error 
function openModalError(text_title, text_content, buttons = []) {
	document.getElementById('modal_error_title').innerText = text_title;
	// Imposta il testo nel corpo del modal
	document.getElementById('modal_error_body').innerText = text_content;

	// Pulisci eventuali bottoni esistenti nel footer
	var modalFooter = document.getElementById('modal_error_footer');
	modalFooter.innerHTML = '';

	// Aggiungi bottoni personalizzati se sono stati forniti
	if (buttons.length > 0) {
		buttons.forEach(button => {
			let btn = document.createElement('a');
			btn.innerText = button.text;
			btn.href = button.href;  // Assegna il link al pulsante
			btn.className = button.class || 'btn btn-primary'; // Classe di default se non specificata
			btn.target = button.target || '_self'; // Target opzionale, default è nella stessa finestra
			modalFooter.appendChild(btn);
		});
	}

	// Ottieni il modal
	var modal = new bootstrap.Modal(document.getElementById('Modal_error'));

	// Mostra il modal
	modal.show();
}