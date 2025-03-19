package com.g2.Interfaces;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class T8Service extends BaseService {

    //private static final String BASE_URL = "http://127.0.0.1:8088";
    private static final String BASE_URL = "http://t8-controller:8088";

    protected T8Service(RestTemplate restTemplate) {
        super(restTemplate, BASE_URL);

        registerAction("evosuiteUserCoverage", new ServiceActionDefinition(
                params -> evosuiteUserCoverage((String) params[0], (String) params[1], (String) params[2],
                        (String) params[3], (String) params[4], (String) params[5], (Integer) params[6]),
                String.class, String.class, String.class, String.class, String.class, String.class, Integer.class
        ));

    }

    private String evosuiteUserCoverage(String testCode, String classUTName, String classUTPath,
                                      String classUTPackage, String userDir,
                                      String coverageSavePath, int playerId) {
        final String endpoint = "/api/VolumeT0";

        JSONObject requestBody = new JSONObject();
        requestBody.put("testCode", testCode);
        requestBody.put("classUTName", classUTName);
        requestBody.put("classUTPath", classUTPath);
        requestBody.put("classUTPackage", classUTPackage);
        requestBody.put("userDir", userDir);
        requestBody.put("coverageSavePath", coverageSavePath);
        requestBody.put("playerId", playerId);

        return callRestPost(endpoint, requestBody, null, null, String.class);
    }
}
