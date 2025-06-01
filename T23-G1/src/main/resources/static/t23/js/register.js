//Modifica (18/06/2024)
//Bugfix della funzione della registrazione, non coerente con la POST nel controller
//Aggiunto anche il popup di errore nel caso di una compilazione sbagliata

//MODIFICA (05/11/2024) Aggiunto controller reCAPTCHA
let recaptchaToken = null; 

function setRecaptchaToken(token) {
  recaptchaToken = token; // Assegna il token reCAPTCHA alla variabile globale
}

document.addEventListener('DOMContentLoaded', (event) => {
  const form = document.querySelector("form");
  if (form) {
    console.log("Form trovato.");
    console.log(form);
  }
  form.addEventListener("submit", async (event) => {
    event.preventDefault();

    //Costruzione del form per l'invio dei dati tramite la POST request.
    const name = document.getElementById("name").value.trim();
    const surname = document.getElementById("surname").value.trim();
    const email = document.getElementById("email").value.trim();
    const password = document.getElementById("password").value.trim();
    const passwordConfirmation = document.getElementById("check_password").value.trim();
    const studies = document.getElementById("studies").value;

    // Validazione lato client
    if (name === '') {
      alert("Compila il campo Nome!");
      return;
    }

    if (surname === '') {
      alert("Compila il campo Cognome!");
      return;
    }

    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailPattern.test(email)) {
      alert("Inserisci un'email valida!");
      return;
    }

    if (password === '') {
      alert("Compila il campo Password!");
      return;
    }

    if (passwordConfirmation === '') {
      alert("Compila il campo Conferma Password!");
      return;
    }

    if (password !== passwordConfirmation) {
      alert("Le password non corrispondono!");
      return;
    }
      
    for (let pair of formData.entries()) {
      console.log(`${pair[0]}: ${pair[1]}`);
    }

    try {
      // Invia la richiesta al server
      const response = await fetch('/auth/register', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({name, surname, email, password, studies}),
      });

      if (response.ok) {
        window.location.href = "login_success";
      } else {
        const errorBody = await response.json();
        console.error('Errore dalla risposta:', errorBody);
      }
    } catch (error) {
      // Pop-up del messaggio di errore da parte della pagina, gestisce anche gli errori del controller
      console.error('Error:', error.message);
      alert(error.message);
    }
  });
});

//FINE MODIFICA
