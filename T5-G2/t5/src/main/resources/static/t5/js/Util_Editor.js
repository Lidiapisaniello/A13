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

function getConsoleTextCoverage(userCoverageDetails, robotCoverageDetails) {
	let lineCoveragePercentage = roundToTwoDecimals(userCoverageDetails.jacoco_line.covered / (userCoverageDetails.jacoco_line.covered + userCoverageDetails.jacoco_line.missed) * 100);
	let BranchCoveragePercentage = roundToTwoDecimals(userCoverageDetails.jacoco_branch.covered / (userCoverageDetails.jacoco_branch.covered + userCoverageDetails.jacoco_branch.missed) * 100);
	let instructionCoveragePercentage = roundToTwoDecimals(userCoverageDetails.jacoco_instruction.covered / (userCoverageDetails.jacoco_instruction.covered + userCoverageDetails.jacoco_instruction.missed) * 100);


	let robotLineCoveragePercentage = roundToTwoDecimals(robotCoverageDetails.jacoco_line.covered / (robotCoverageDetails.jacoco_line.covered + robotCoverageDetails.jacoco_line.missed) * 100);
	let robotBranchCoveragePercentage = roundToTwoDecimals(robotCoverageDetails.jacoco_branch.covered / (robotCoverageDetails.jacoco_branch.covered + robotCoverageDetails.jacoco_branch.missed) * 100);
	let robotInstructionCoveragePercentage = roundToTwoDecimals(robotCoverageDetails.jacoco_instruction.covered / (robotCoverageDetails.jacoco_instruction.covered + robotCoverageDetails.jacoco_instruction.missed) * 100);
	consoleText =
`============================== JaCoCo ===============================
Your Line Coverage COV%:  ${lineCoveragePercentage}% LOC
covered: ${userCoverageDetails.jacoco_line.covered}  
missed: ${userCoverageDetails.jacoco_line.missed}
Robot Line Coverage COV%:  ${robotLineCoveragePercentage}% LOC
robot covered: ${robotCoverageDetails.jacoco_line.covered}
robot missed: ${robotCoverageDetails.jacoco_line.missed}
----------------------------------------------------------------------
Your Branch Coverage COV%:  ${BranchCoveragePercentage}% LOC
covered: ${userCoverageDetails.jacoco_branch.covered} 
missed: ${userCoverageDetails.jacoco_branch.missed}
Robot Branch Coverage COV%:  ${robotBranchCoveragePercentage}% LOC
robot covered: ${robotCoverageDetails.jacoco_branch.covered}
robot missed: ${robotCoverageDetails.jacoco_branch.missed}
----------------------------------------------------------------------
Your Instruction Coverage COV%:  ${instructionCoveragePercentage}% LOC
covered: ${userCoverageDetails.jacoco_instruction.covered} 
missed: ${userCoverageDetails.jacoco_instruction.missed}
Robot Instruction Coverage COV%:  ${robotInstructionCoveragePercentage}% LOC
robot covered: ${robotCoverageDetails.jacoco_instruction.covered}
robot missed: ${robotCoverageDetails.jacoco_instruction.missed}
============================== EvoSuite ===============================
Il tuo punteggio EvoSuite:  ${roundToTwoDecimals(userCoverageDetails.evosuite_line)}% Line
Il punteggio EvoSuite del robot:  ${roundToTwoDecimals(robotCoverageDetails.evosuite_line)}% Line
----------------------------------------------------------------------
Il tuo punteggio EvoSuite: ${roundToTwoDecimals(userCoverageDetails.evosuite_branch)}% Branch
Il punteggio EvoSuite del robot: ${roundToTwoDecimals(robotCoverageDetails.evosuite_branch)}% Branch
----------------------------------------------------------------------
Il tuo punteggio EvoSuite: ${roundToTwoDecimals(userCoverageDetails.evosuite_exception)}% Exception
Il punteggio EvoSuite del robot: ${roundToTwoDecimals(robotCoverageDetails.evosuite_exception)}% Exception
----------------------------------------------------------------------
Il tuo punteggio EvoSuite: ${roundToTwoDecimals(userCoverageDetails.evosuite_weak_mutation)}% WeakMutation
Il punteggio EvoSuite del robot: ${roundToTwoDecimals(robotCoverageDetails.evosuite_weak_mutation)}% WeakMutation
----------------------------------------------------------------------
Il tuo punteggio EvoSuite: ${roundToTwoDecimals(userCoverageDetails.evosuite_cbranch)}% CBranch
Il punteggio EvoSuite del robot: ${roundToTwoDecimals(robotCoverageDetails.evosuite_cbranch)}% CBranch
======================================================================`;

	// Restituisce il testo generato
	return consoleText;
}

function roundToTwoDecimals(numStr) {
	return (Math.round(parseFloat(numStr * 100)) / 100).toFixed(2);
}

function getConsoleTextRun(userCoverageDetails, robotCoverageDetails, canWin, gameScore, robotScore) {
	function roundToTwoDecimals(value) {
		return Math.round(value * 100) / 100;
	}

	function getCoverageStats(label, user, robot, isLast) {
		let userPercentage = roundToTwoDecimals(user.covered / (user.covered + user.missed) * 100);
		let robotPercentage = roundToTwoDecimals(robot.covered / (robot.covered + robot.missed) * 100);
		return (
			`${label} Coverage COV%:  ${userPercentage}% LOC\n` +
			`covered: ${user.covered}  missed: ${user.missed}\n` +
			`Robot ${label} Coverage COV%:  ${robotPercentage}% LOC\n` +
			`robot covered: ${robot.covered} robot missed: ${robot.missed}\n` +
			(isLast ? "" : `----------------------------------------------------------------------\n`)
		);
	}

	function getEvoSuiteStats(label, user, robot, isLast) {
		return (
			`Il tuo punteggio EvoSuite: ${roundToTwoDecimals(user)}% ${label}\n` +
			`Il punteggio EvoSuite del robot: ${roundToTwoDecimals(robot)}% ${label}\n` +
			(isLast ? "" : `----------------------------------------------------------------------\n`)
		);
	}

	let consoleText2 = canWin ? `===================================================================== \n` +
		"Puoi vincere la partita" + "\n" : "";

	let consoleText =
		consoleText2 +
		`============================== Results ===============================\n` +
		`Il tuo punteggio:${gameScore}pt\n` +
		"----------------------------------------------------------------------\n" +
		`Il punteggio del robot:${robotScore}pt\n` +
		"============================== JaCoCo ================================\n" +
		getCoverageStats("Your Line", userCoverageDetails.jacoco_line, robotCoverageDetails.jacoco_line, false) +
		getCoverageStats("Your Branch", userCoverageDetails.jacoco_branch, robotCoverageDetails.jacoco_branch, false) +
		getCoverageStats("Your Instruction", userCoverageDetails.jacoco_instruction, robotCoverageDetails.jacoco_instruction, true) +
		"============================== EvoSuite ===============================\n" +
		getEvoSuiteStats("Line", userCoverageDetails.evosuite_line, robotCoverageDetails.evosuite_line, false) +
		getEvoSuiteStats("Branch", userCoverageDetails.evosuite_branch, robotCoverageDetails.evosuite_branch, false) +
		getEvoSuiteStats("Exception", userCoverageDetails.evosuite_exception, robotCoverageDetails.evosuite_exception, false) +
		getEvoSuiteStats("WeakMutation", userCoverageDetails.evosuite_weak_mutation, robotCoverageDetails.evosuite_weak_mutation, false) +
		getEvoSuiteStats("CBranch", userCoverageDetails.evosuite_cbranch, robotCoverageDetails.evosuite_cbranch, true) +
		"======================================================================";

	return consoleText;
}


function getConsoleTextError(){
	return  `===================================================================== \n` 
			+ error +  "\n" +
			`============================== Results =============================== \n
			Ci sono stati errori di compilazione, controlla la console !`;
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
		editor.removeLineClass(lineNumber - 3, "background", "bg-coverage-danger");
		editor.removeLineClass(lineNumber - 3, "background", "bg-coverage-warning");
		editor.addLineClass	(lineNumber - 3, "background", " bg-coverage-success");
	});

	uncoveredLines.forEach(function (lineNumber) {
		editor.removeLineClass(lineNumber - 3, "background", "bg-coverage-warning");
		editor.removeLineClass(lineNumber - 3, "background", "bg-coverage-success");
		editor.addLineClass	(lineNumber - 3, "background", "bg-coverage-danger");
	});

	partiallyCoveredLines.forEach(function (lineNumber) {
		editor.removeLineClass(lineNumber - 3, "background", "bg-coverage-danger");
		editor.removeLineClass(lineNumber - 3, "background", "bg-coverage-success");
		editor.addLineClass	(lineNumber - 3, "background", "bg-coverage-warning");
	});

	// Forzo il refresh dell'editor, altrimenti il background viene caricato solo dopo aver scollato
	editor.refresh();
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
			contentType: "application/json",
			data: JSON.stringify(data), // Passa i dati direttamente senza modificarli
		};

		const response = await $.ajax(options);
		return response;
	} catch (error) {
		console.error("Si è verificato un errore:", error);
		throw error;
	}
}

/*
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

 */


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
// === FUNZIONI PER LA GESTIONE DEL TIMER DELLA PARTITA SINGOLA ===

window.addEventListener("load", function () {
	const mode = GetMode();
	if (mode === "PartitaSingola")
		startTimer();
});

function getRemainingTime(){
	return getParameterByName("remainingTime");
}

function startTimer() {
	timer_remainingTime = getRemainingTime();
	timer = setInterval(function () {
		document.getElementById('timerDisplay').innerHTML = formatTime(timer_remainingTime);
		timer_remainingTime--;

		if (timer_remainingTime < 0) {
			clearInterval(timer);
			onTimerEnd();
		}
	}, 1000);
}

function stopTimer() {
	if (timer !== null) {
		clearInterval(timer);
		timer = null;
	}
}

function formatTime(seconds) {
	let hrs = Math.floor(seconds / 3600);
	let mins = Math.floor((seconds % 3600) / 60);
	let secs = seconds % 60;
	return (
		String(hrs).padStart(2, '0') + ":" +
		String(mins).padStart(2, '0') + ":" +
		String(secs).padStart(2, '0')
	);
}

function onTimerEnd() {
	console.log("OnTimerEnd");
	openModalWithText(
		"Oh no! Il tempo è scaduto!",
		"Vuoi consegnare il codice corrente o mantenere l'ultimo compilato?",
		[
			{ tagName: "button", text: "Consegna", class: 'btn btn-primary', data_bs_dismiss: "modal", onclick: () => handleGameAction(true, true) },
			{ tagName: "button", text: "Mantieni", class: 'btn btn-primary', data_bs_dismiss: "modal", onclick: () => handleGameAction(true, false) }
		]
	);
}


// === FUNZIONI DI UTILITÀ PER L'EDITOR E LA SESSIONE ===

// Inizializzo il contenuto dell'editor con il codice salvato nella sessione
document.addEventListener('DOMContentLoaded', () => {
	console.log("sessione: ", previousGameObject);
	if (previousGameObject && previousGameObject.testingClassCode) {
		editor_utente.setValue(previousGameObject.testingClassCode);
	}
	if (previousGameObject && GetMode() === "PartitaSingola" && previousGameObject.remainingTime) {
		timer_remainingTime = previousGameObject.remainingTime;
	}
});

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

function GetMode() {
    const mode = getParameterByName("mode");
    if (mode) {
        const cleanedMode = mode.replace(/[^\w]/g, "").trim(); // Rimuove caratteri non alfanumerici
        return cleanedMode;
    }
    return null;
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
			let btn = document.createElement(button.tagName);
			btn.innerText = button.text;

			btn.className = button.class || 'btn btn-primary'; // Classe di default se non specificata
			btn.target = button.target || '_self'; // Target opzionale, default è nella stessa finestra

			if (button.data_bs_dismiss)
				btn.setAttribute('data-bs-dismiss', button.data_bs_dismiss); // Aggiungo il pulsante di chiusura del modale oltre alla "X"

			if (button.href)
				btn.href = button.href;  // Assegna il link al pulsante

			if (button.onclick) {
				btn.addEventListener("click", button.onclick); // Assegna la funzione all'evento
			}

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

function objectToFormData(obj, formData = new FormData(), parentKey = '') {
	for (let key in obj) {
		if (obj.hasOwnProperty(key)) {
			let fullKey = parentKey ? `${parentKey}[${key}]` : key;

			if (typeof obj[key] === 'object' && obj[key] !== null && !(obj[key] instanceof File)) {
				objectToFormData(obj[key], formData, fullKey);
			} else {
				formData.append(fullKey, obj[key]);
			}
		}
	}
	return formData;
}