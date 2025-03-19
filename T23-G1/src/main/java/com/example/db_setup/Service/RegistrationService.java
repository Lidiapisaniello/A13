package com.example.db_setup.Service;

import com.example.db_setup.util.ServiceURL;
import org.json.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RegistrationService {

    private ServiceURL serviceURL;
    private static final Logger logger = LoggerFactory.getLogger(RegistrationService.class);


    public RegistrationService(ServiceURL serviceURL) {
        this.serviceURL = serviceURL;
    }

    /*
    *   Contatta T4 per inizializzare i punti esperienza dell'utente
     */
    public boolean initializeExperiencePoints(Integer playerId) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPostT8 = new HttpPost("http://" + serviceURL.getT4ServiceURL() + "/experience");
            logger.info("[initializeExperiencePoints] Invio richiesta a T4 su endpoint {}", httpPostT8.getURI());

            JSONObject reqBody = new JSONObject();
            reqBody.put("player_id", playerId);
            reqBody.put("experience_points", 0);

            // Imposta il body della richiesta
            StringEntity entity = new StringEntity(reqBody.toString(), ContentType.APPLICATION_JSON);
            httpPostT8.setEntity(entity);

            // Esegue la richiesta HTTP
            try (CloseableHttpResponse response = httpClient.execute(httpPostT8)) {
                JSONObject responseBody = new JSONObject(EntityUtils.toString(response.getEntity()));
                logger.info("[initializeExperiencePoints] Risposta ricevuta {}", responseBody);
                return !responseBody.isEmpty();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
