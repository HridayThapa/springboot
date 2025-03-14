package com.example.steamprocessing.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class KsqlDbService {

    @Value("${ksql.url}")
    private String ksqlUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public String executeQuery(String query) {
        String ksqlQuery = "{ \"ksql\": \"" + query + "\", \"streamsProperties\": {} }";
        return restTemplate.postForObject(ksqlUrl + "/query", ksqlQuery, String.class);
    }
}
