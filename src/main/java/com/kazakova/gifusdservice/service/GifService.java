package com.kazakova.gifusdservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kazakova.gifusdservice.feignclient.CommonGifClient;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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

    public String getGif(int coff) throws JsonProcessingException, ParseException {
        String responseEntity = commonGifClient.getGif(mapOfCoff.get(coff));
        JSONParser jsonParser = new JSONParser();
        JSONObject jB = (JSONObject) jsonParser.parse(responseEntity);
        JSONArray jsonArray = (JSONArray) jB.get("data");
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        return jsonObject.get("embed_url").toString();
    }

}
