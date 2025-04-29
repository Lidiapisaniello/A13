import axios from 'axios';
import fs from 'fs';

async function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

function randomString(length) {
    const chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz';
    let result = '';
    for (let i = 0; i < length; i++) {
        result += chars.charAt(Math.floor(Math.random() * chars.length));
    }
    return result;
}

const successfulUsers = [];
const TOTAL_USERS = 80;
//const ENDPOINT = "https://51b5-143-225-28-159.ngrok-free.app";
const ENDPOINT = "http://localhost";
const REGISTER_URL = `${ENDPOINT}/register`;

async function registerUser() {
    const randomSleepTime = Math.floor(Math.random() * 5) + 1;
    await sleep(randomSleepTime * 1000);

    const name = `User${randomString(5)}`;
    const surname = `Test${randomString(5)}`;
    const email = `${randomString(5)}@e.com`;
    const password = `Test@1234`;

    const payload = {
        name: name,
        surname: surname,
        email: email,
        password: password,
        check_password: password,
        studies: 'BSc',
    };

    console.log(payload);

    try {
        const res = await axios.post(REGISTER_URL, payload, {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            },
            validateStatus: () => true,
        });

        if (res.status === 200 || res.status === 201) {
            console.log(`Successfully registered: ${email}`);
            successfulUsers.push({ email, password });
        } else {
            console.log(`Failed to register: ${email} (Status ${res.status})`);
            console.error(res)
        }
    } catch (error) {
        console.error(`Error registering ${email}:`, error.message);
    }
}

async function main() {
    for (let i = 0; i < TOTAL_USERS; i++) {
        await registerUser();
    }

    fs.writeFileSync('users.json', JSON.stringify(successfulUsers, null, 2));
    console.log(`Saved ${successfulUsers.length} users to users.json`);
}

main();
