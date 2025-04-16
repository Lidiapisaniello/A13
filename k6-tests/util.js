import encoding from "k6/encoding";

/*
 * Extract userId from JWT
 *  - “rawurl”: encoding alphabet doesn’t contain + and / characters, but rather - and _ characters
 *              but without = padding characters.
 *  - "s": return the data as a string, otherwise if unspecified an ArrayBuffer object is returned.
 *
 * https://grafana.com/docs/k6/latest/javascript-api/k6-encoding/b64decode/
 */
export const parseJwt = (token) => {
    try {
        const parts = token.split('.');
        return JSON.parse(encoding.b64decode(parts[1], "rawurl", "s"));
    } catch (e) {
        console.error("Errore parseJwt: ", e);
        return null;
    }
};