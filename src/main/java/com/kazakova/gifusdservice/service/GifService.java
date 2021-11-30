package com.kazakova.gifusdservice.service;

import com.kazakova.gifusdservice.feignclient.CommonGifClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class GifService {

    private final CommonGifClient commonGifClient;

    /**
     * mapOfCoefficient - коллекция коэффицентов и тэгов для возвращения рандомных gif-файлов
     */

    private static final Map<Integer, String> mapOfCoefficient = new HashMap<>();

    {
        mapOfCoefficient.put(1, "${gif.rich}");
        mapOfCoefficient.put(-1, "${gif.broke}");
        mapOfCoefficient.put(0, "${gif.zero}");
    }

    /**
     * @param coefficient - результат сравнения значений вчерашнего и сегодняшнего курса валют
     * @return url - url подходящего gif-файла
     */

    public String getGif(int coefficient) throws ParseException {
        log.info(">> GifService getGif coefficient={}", coefficient);
        String responseEntity = commonGifClient.getGif(mapOfCoefficient.get(coefficient));
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(responseEntity);
        JSONObject data = (JSONObject) jsonObject.get("data");
        String url = data.get("embed_url").toString();
        log.info("<< GifService getGif  url={}", url);
        return url;
    }

}
