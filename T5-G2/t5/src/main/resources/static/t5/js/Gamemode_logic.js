/*
 *   Copyright (c) 2024 Stefano Marano https://github.com/StefanoMarano80017
 *   All rights reserved.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

// ------------------------------
// FUNZIONI DI UTILITÀ
// ------------------------------
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
        const trimmed = mode.replace(/[^a-zA-Z0-9\s]/g, " ").trim();
        if (trimmed.toLowerCase() === "sfida") {
            return "Sfida";
        }
        return trimmed;
    }
    return "Sfida"; // Default in forma capitalizzata
}

function SetMode(setM) {
    const currentMode = GetMode();
    if (!setM) {
        const elements = document.querySelectorAll(".selectedMode");
        elements.forEach((element) => {
            element.textContent += " " + currentMode;
        });
    }
    const selectRobotElement = document.getElementById("robot_selector");
    const selectDifficultyElement = document.getElementById("difficulty_selector");
    if (currentMode === "Allenamento") {
        selectRobotElement.classList.add("d-none");
        selectDifficultyElement.classList.add("d-none");
    } else {
        selectRobotElement.classList.remove("d-none");
        selectDifficultyElement.classList.remove("d-none");
    }
}

// ------------------------------
// FUNZIONI PER GESTIRE LA SESSIONE CON REDIS
// ------------------------------
// --- Funzione per ottenere il game object dalla sessione (Redis) ---
async function fetchPreviousGameData() {
    const playerId = String(parseJwt(getCookie("jwt")).userId);
    try {
        // Ora il path è /session/{playerId}
        const response = await fetch(`/session/${playerId}`);
        const data = await response.json();
        // Assumiamo che il formato sia: { modalita: { Sfida: { gameobject: { … } } } }
        if (data && data.modalita && data.modalita[GetMode()] && data.modalita[GetMode()].gameobject) {
            console.log("[fetchPreviousGameData] Trovato gameobject per la modalità " + GetMode() + ":", data.modalita[GetMode()].gameobject);
            return data.modalita[GetMode()].gameobject;
        }
        return null;
    } catch (error) {
        console.error("Errore durante il recupero della sessione:", error);
        return null;
    }
}

async function saveModalitaToSession() {
    const playerId = String(parseJwt(getCookie("jwt")).userId);
    const currentMode = GetMode();
    // Recupera la sessione tramite GET /session/{playerId}
    let sessionResponse = await fetch(`/session/${playerId}`);
    let sessionData = await sessionResponse.json();

    let gameObject = sessionData && sessionData.modalita && sessionData.modalita[currentMode]
                      ? sessionData.modalita[currentMode].gameobject
                      : null;
    
    if (!gameObject) {
        console.warn(`Nessun gameobject trovato nella modalità '${currentMode}'. Probabilmente il gioco non è ancora stato creato correttamente.`);
        return;
    }

    // Per aggiornare la gamemode usiamo il path PUT /session/gamemode/{playerId}?mode={currentMode}
    try {
        const response = await fetch(`/session/gamemode/${playerId}?mode=${currentMode}`, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            // Invia direttamente il gameobject (la logica nel controller aggiorna il timestamp)
            body: JSON.stringify(gameObject)
        });
        const result = await response.text();
        console.log("Modalità aggiornata con successo:", result);
    } catch (error) {
        console.error("Errore durante l'aggiornamento della modalità:", error);
    }
}

async function deleteModalita(mode) {
    const playerId = String(parseJwt(getCookie("jwt")).userId);
    try {
        // Ora il path è DELETE /session/gamemode/{playerId}?mode={mode}
        const response = await fetch(`/session/gamemode/${playerId}?mode=${mode}`, {
            method: "DELETE"
        });
        const result = await response.text();
        console.log("Modalità eliminata:", result);
    } catch (error) {
        console.error("Errore durante l'eliminazione della modalità:", error);
    }
}

// ------------------------------
// FUNZIONI PER GESTIRE IL GIOCO
// ------------------------------
async function startGame() {
    const playerId = String(parseJwt(getCookie("jwt")).userId);
    const mode = GetMode();
    const underTestClassName = document.getElementById("select_class").value;
    let typeRobot = "";
    let difficulty = "";
    
    if (mode === "Sfida") {
        typeRobot = document.getElementById("select_robot").value;
        difficulty = document.getElementById("select_diff").value;
        if (!underTestClassName || !typeRobot || !difficulty) {
            console.error("Parametri mancanti per la modalità Sfida.");
            return;
        }
    } else if (mode === "Allenamento") {
        typeRobot = "NONE";
        difficulty = "EASY";
        if (!underTestClassName) {
            console.error("Parametri mancanti per la modalità Allenamento.");
            return;
        }
    }
    
    try {
        const response = await fetch("/StartGame", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ playerId, mode, underTestClassName, typeRobot, difficulty })
        });
        const result = await response.json();
        if (result && result.gameId) {
            console.log("Partita avviata con successo, Game ID:", result.gameId);
            window.location.href = `/editor?ClassUT=${underTestClassName}`;
        } else {
            console.error("Errore nell'avvio della partita:", result);
        }
    } catch (error) {
        console.error("Errore durante l'avvio della partita:", error);
    }
}

// Aggiungere un flush del localStorage se necessario

// ------------------------------
// EVENTI DELL'INTERFACCIA
// ------------------------------
document.addEventListener("DOMContentLoaded", async function () {
    SetMode(false);
    const previousGameObject = await fetchPreviousGameData();
    if (previousGameObject) {
        console.log("Partita già in corso, riprendo la sessione.");
        document.getElementById("scheda_nuovo").classList.add("d-none");
        document.getElementById("scheda_continua").classList.remove("d-none");
        document.getElementById("gamemode_classeUT").innerText = previousGameObject.class_ut || "";
        document.getElementById("gamemode_robot").innerText = previousGameObject.type_robot || "";
        document.getElementById("gamemode_difficulty").innerText = previousGameObject.difficulty || "";
        document.getElementById("gamemode_modalita").innerText = previousGameObject.mode || "";
        const link = document.getElementById("Continua");
        link.href = `/editor?ClassUT=${previousGameObject.class_ut || ""}`;
    } else {
        console.log("Nessuna partita in corso, pronta per avviare una nuova partita.");
        document.getElementById("scheda_nuovo").classList.remove("d-none");
        document.getElementById("scheda_continua").classList.add("d-none");
    }
});

document.getElementById("new_game").addEventListener("click", async function () {
    toggleVisibility("scheda_nuovo");
    toggleVisibility("scheda_continua");
    toggleVisibility("alert_nuova");
    await deleteModalita(GetMode());
});

document.getElementById("link_editor").addEventListener("click", async function () {
    await startGame();
});

// Aggiorna lo stato del pulsante in base ai selettori del form
function updateButtonState() {
    const submitButton = document.getElementById("link_editor");
    const mode = GetMode();
    const allSelected = document.getElementById("select_class").value &&
                        document.getElementById("select_robot").value &&
                        document.getElementById("select_diff").value;
    const classSelected = document.getElementById("select_class").value;
    submitButton.classList.toggle("disabled", mode !== "Allenamento" ? !allSelected : !classSelected);
}

document.getElementById("select_class").addEventListener("change", updateButtonState);
document.getElementById("select_robot").addEventListener("change", updateButtonState);
document.getElementById("select_diff").addEventListener("change", updateButtonState);

function toggleVisibility(elementId) {
    const element = document.getElementById(elementId);
    if (element) {
        element.classList.toggle("d-none");
    } else {
        console.error("Elemento non trovato con ID:", elementId);
    }
}

// Filtro i robot disponibili in base alla classeUT scelta
document.addEventListener("DOMContentLoaded", function () {
	const selectClass = document.getElementById("select_class");
	const selectRobot = document.getElementById("select_robot");
	const selectDifficulty = document.getElementById("select_diff");

	selectClass.addEventListener("change", function () {
		const selectedClass = selectClass.value;

		selectRobot.disabled = true;
		selectDifficulty.disabled = true;

		// Rimuovo i robot disponibili associati alla precedente classeUT scelta
		Array.from(selectRobot.options)
			.slice(1) // Mantengo la prima opzione ("Seleziona un'opzione")
			.forEach(option => option.remove());

		// Rimuovo le difficoltà disponibili associate alla precedente classeUT scelta e al precedente robot scelto
		Array.from(selectDifficulty.options)
			.slice(1) // Mantengo la prima opzione ("Seleziona un'opzione")
			.forEach(option => option.remove());

		selectRobot.innerHTML = document.getElementById("select_robot").children[0].outerHTML;
		selectRobot.disabled = true;

		if (selectedClass) {
			const filteredRobots = availableRobots
				.filter(robot => robot.testClassId === selectedClass)
				.reduce((unique, robot) => {
					if (!unique.includes(robot.robotType)) {
						unique.push(robot.robotType);
					}
					return unique;
				}, []);

			filteredRobots.forEach(robot => {
				const option = document.createElement("option");
				option.value = robot;
				option.textContent = robot;
				selectRobot.appendChild(option);
			});

			selectRobot.disabled = filteredRobots.length === 0;
		}
	});
});

// Filtro le difficoltà disponibili in base alla classeUT e al robot scelti
document.addEventListener("DOMContentLoaded", function () {
	const selectClass = document.getElementById("select_class");
	const selectRobot = document.getElementById("select_robot");
	const selectDifficulty = document.getElementById("select_diff");

	selectRobot.addEventListener("change", function () {
		const selectedClass = selectClass.value;
		const selectedRobot = selectRobot.value;

		selectDifficulty.disabled = true;

		// Rimuovo le difficoltà disponibili associate alla precedente classeUT scelta e al precedente robot scelto
		Array.from(selectDifficulty.options)
			.slice(1) // Mantengo la prima opzione ("Seleziona un'opzione")
			.forEach(option => option.remove());

		selectDifficulty.innerHTML = document.getElementById("select_robot").children[0].outerHTML;
		selectDifficulty.disabled = true;

		if (selectedClass && selectedRobot) {
			const filteredDifficulties = availableRobots
				.filter(robot => robot.testClassId === selectedClass && robot.robotType === selectedRobot)
				.map(robot => robot.difficulty);

			const difficultyOptions = document.getElementById("difficulty_options").children;

			for (let option of difficultyOptions) {
				if (filteredDifficulties.includes(parseInt(option.value))) {
					selectDifficulty.appendChild(option.cloneNode(true));
				}
			}

			selectDifficulty.disabled = filteredDifficulties.length === 0;
		}
	});
});