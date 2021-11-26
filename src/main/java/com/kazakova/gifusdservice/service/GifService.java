package com.kazakova.gifusdservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kazakova.gifusdservice.feignclient.CommonGifClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GifService {

    @Autowired
    private CommonGifClient commonGifClient;

    private static final Map<Integer, String> mapOfCoff = new HashMap<>();

    {
        mapOfCoff.put(1, "rich");
        mapOfCoff.put(-1, "broke");
        mapOfCoff.put(0, "travolta");

    }

    public String getGif(int coff) throws JsonProcessingException {
        ResponseEntity<Map> responseEntity = commonGifClient.getGif(mapOfCoff.get(coff));
        Map<String, String> responseEntityBody = responseEntity.getBody();
        String jsonResponseEntity = responseEntityBody.get("data");
//        ObjectMapper objectMapper = new ObjectMapper();
//        List<Gif> listGif = objectMapper.readValue(jsonResponseEntity, new TypeReference<>() {
//        });
//        return listGif.get(1).getData().get("embed_url");
        return null;
    }

}
