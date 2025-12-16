document.addEventListener("DOMContentLoaded", function () {
    const profilePictures = document.querySelectorAll(".profile-picture");
    const bioInput = document.getElementById("bio-input");
    const saveButton = document.getElementById("save-button");
    const userData = document.getElementById("user-data"); // Nel tuo HTML è user-data
    
    // CORREZIONE 1: L'ID nell'HTML è user-email, non player-email
    const userEmailElement = document.getElementById("user-email"); 
    const userEmail = userEmailElement ? userEmailElement.textContent.trim() : "";

    // Dati attuali
    const currentBio = userData ? userData.dataset.currentBio : "";
    const currentImage = userData ? userData.dataset.currentImage : "default.png";

    let selectedImage = null;

    profilePictures.forEach((img) => {
        img.addEventListener("click", function () {
            profilePictures.forEach((i) => i.classList.remove("selected"));
            this.classList.add("selected");
            selectedImage = this.getAttribute("src").split("/").pop().split("?")[0]; 
        });
    });

    if (saveButton) {
        saveButton.addEventListener("click", async function () {
            const newBio = bioInput.value.trim();
            const bioToSend = newBio !== "" ? newBio : currentBio;
            const imageToSend = selectedImage || currentImage;

            // Controllo email
            if (!userEmail) {
                alert("Errore: Email utente non trovata. Ricarica la pagina.");
                return;
            }

            const formData = new URLSearchParams();
            formData.append("bio", bioToSend);
            formData.append("profilePicturePath", imageToSend);
            formData.append("email", userEmail);

            // Gestione CSRF
            const csrfTokenMeta = document.querySelector('meta[name="_csrf"]');
            const csrfHeaderMeta = document.querySelector('meta[name="_csrf_header"]');
            const headers = { "Content-Type": "application/x-www-form-urlencoded" };
            if (csrfTokenMeta && csrfHeaderMeta) {
                headers[csrfHeaderMeta.getAttribute('content')] = csrfTokenMeta.getAttribute('content');
            }

          // ...
            try {
                // MODIFICA QUI: Puntiamo a "/edit_profile" (lo stesso della pagina)
                const response = await fetch("/api/gameEngine/update_profile", {
                    method: "POST", // Il metodo POST lo distingue dalla visualizzazione pagina
                    headers: {
                        "Content-Type": "application/x-www-form-urlencoded",
                    },
                    body: formData.toString(),
                });
            // ...

                if (response.ok) {
                    alert("Profilo aggiornato!");
                    window.location.href = "/profile";
                } else {
                    const errorText = await response.text();
                    alert("Errore salvataggio: " + errorText);
                }
            } catch (error) {
                console.error("Errore di rete:", error);
                alert("Errore di comunicazione con il server.");
            }
        });
    }
});