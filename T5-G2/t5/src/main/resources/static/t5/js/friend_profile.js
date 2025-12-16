/*
 * Copyright (c) 2025 Stefano Marano https://github.com/StefanoMarano80017
 * All rights reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// funzione per ottenere l'ID utente dal JWT
function getAuthUserId(jwt) {
    try {
        const base64Url = jwt.split('.')[1];
        const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
        const jsonPayload = decodeURIComponent(
            atob(base64)
                .split('')
                .map(c => '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2))
                .join('')
        );
        const payload = JSON.parse(jsonPayload);
        return parseInt(payload.userId, 10);
    } catch (error) {
        console.error('Errore durante la decodifica del JWT:', error);
        return null;
    }
}

document.addEventListener("DOMContentLoaded", function () {
    // Gestione dei tab dei trofei (Log)
    const trophyTabs = document.querySelectorAll('#trophyTabs button[data-bs-toggle="tab"]');
    trophyTabs.forEach(tab => {
        tab.addEventListener('shown.bs.tab', function (event) {
            console.log(`Tab attivo: ${event.target.id}`);
        });
    });
});

document.addEventListener('DOMContentLoaded', function() {
    
    //gestione bottone follow/unfollow
    const followButton = document.getElementById('followButton');
    
    if (followButton) {
        followButton.addEventListener('click', async function() {
            // Disabilita il bottone per evitare doppi click
            this.disabled = true;
            const originalText = this.textContent;
            this.textContent = "...";

            // Recupera gli ID necessari
            const friendUserId = this.getAttribute('data-friend-id');

            const myIdSpan = document.getElementById('userProfileID');
            const myId = myIdSpan ? myIdSpan.textContent : "0";

            console.log('Toggle Follow -> MyID:', myId, ' FriendID:', friendUserId);

            // creazione del form data
            const formData = new URLSearchParams();
            formData.append("followerId", myId);
            formData.append("followingId", friendUserId);

            try {
                // Chiamata all'endpoint del Controller T5
                const response = await fetch("/profile/toggle_follow", {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded'
                    },
                    body: formData.toString()
                });

                if (!response.ok) throw new Error(`HTTP error! Status: ${response.status}`);
                
                // true se ora si segue, false altrimenti
                const isFollowing = await response.json();

                // Riabilita bottone
                this.disabled = false;

                // Aggiorna lo stile in base al nuovo stato
                if (isFollowing === true) {
                    this.textContent = $("#unfollowText").text();
                    this.classList.remove('btn-primary');
                    this.classList.add('btn-danger');
                } else {
                    this.textContent = $("#followText").text();
                    this.classList.remove('btn-danger');
                    this.classList.add('btn-primary');
                }

            } catch (error) {
                console.error('Errore nella richiesta:', error);
                this.textContent = originalText;
                this.disabled = false;
                alert("Si è verificato un errore durante l'operazione.");
            }
        });
    }

    // Funzione per gestire la ricerca nei tab degli amici
    function setupTabSearch() {
        const searchInputs = document.querySelectorAll('.tab-search');
        searchInputs.forEach(searchInput => {
            searchInput.addEventListener('input', function() {
                const searchTerm = this.value.toLowerCase();
                const targetTab = this.getAttribute('data-search-target');
                const container = document.querySelector(`#${targetTab}-content .friends-list`);
                if (!container) return; // Evita errori se non siamo nella pagina giusta
                
                const friendItems = container.querySelectorAll('.friend-item');
                friendItems.forEach(item => {
                    const nameEl = item.querySelector('h5');
                    const emailEl = item.querySelector('p');
                    
                    if(nameEl && emailEl) {
                        const name = nameEl.textContent.toLowerCase();
                        const email = emailEl.textContent.toLowerCase();
                        if (name.includes(searchTerm) || email.includes(searchTerm)) {
                            item.classList.remove('hidden');
                            highlightText(item, searchTerm);
                        } else {
                            item.classList.add('hidden');
                        }
                    }
                });
            });
        });
    }

    // Funzione per evidenziare il testo cercato
    function highlightText(item, searchTerm) {
        const nameElement = item.querySelector('h5');
        const emailElement = item.querySelector('p');
        
        if (!nameElement || !emailElement) return;

        if (searchTerm === '') {
            nameElement.innerHTML = nameElement.textContent;
            emailElement.innerHTML = emailElement.textContent;
            return;
        }
        
        const highlightMatch = (text, term) => {
            const regex = new RegExp(`(${term})`, 'gi');
            return text.replace(regex, '<span class="highlight">$1</span>');
        };
        nameElement.innerHTML = highlightMatch(nameElement.textContent, searchTerm);
        emailElement.innerHTML = highlightMatch(emailElement.textContent, searchTerm);
    }

    const style = document.createElement('style');
    style.textContent = `
        .highlight {
            background-color: rgba(0, 123, 255, 0.2);
            padding: 0 2px;
            border-radius: 3px;
        }
        .hidden {
            display: none;
        }
    `;
    document.head.appendChild(style);
    
    // Avvia listener ricerca
    setupTabSearch();
});