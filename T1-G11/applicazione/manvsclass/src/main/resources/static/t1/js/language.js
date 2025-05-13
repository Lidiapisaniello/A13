const getCookie = (name) => {
    const value = `; ${document.cookie}`;
    const parts = value.split(`; ${name}=`);
    if (parts.length === 2) return parts.pop().split(';').shift();
    return null;
}

// Gestione tasto lingua navbar
function changeLanguage(lang) {
    fetch("/changeLanguage?lang=" + lang, {
        method: "POST",
    })
        .then((response) => {
            if (response.ok) {
                console.log("Lingua cambiata con successo.");
                // Qui puoi aggiornare la UI o ricaricare la pagina se necessario
                location.reload(); // Ricarica la pagina per applicare il cambiamento di lingua
            } else {
                console.error("Errore nel cambio lingua:", response.statusText);
            }
        })
        .catch((error) => {
            console.error("Errore nella richiesta:", error);
        });
}

// Aggiungi evento click per tutti gli elementi della lingua
document.querySelectorAll(".language_select").forEach((item) => {
    item.addEventListener("click", (event) => {
        const lang = event.currentTarget.getAttribute("data-lang"); // Ottieni il valore della lingua
        changeLanguage(lang); // Chiama la funzione per cambiare lingua
        updateLanguageIcon();
    });
});

document.addEventListener("DOMContentLoaded", function () {
    const langCookie = getCookie("lang");
    if (!langCookie) {
        // Se il cookie non esiste, creane uno di default
        setCookie("lang", "it", 7 * 24 * 60 * 60); // Imposta il cookie per 7 giorni
        console.log("Cookie 'lang' impostato su 'it'");
    } else {
        console.log("Cookie 'lang' esistente: " + langCookie);
    }
});