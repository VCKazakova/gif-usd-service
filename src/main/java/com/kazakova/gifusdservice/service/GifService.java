package com.kazakova.gifusdservice.service;

import com.kazakova.gifusdservice.feignclient.CommonGifClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GifService {

    @Autowired
    private CommonGifClient commonGifClient;

    private String richQ = "rich";
    private String brokeQ = "broke";
    private String noChangeQ = "travolta";

    public ResponseEntity<Map> getRichGif() {
       return commonGifClient.getRichGif(richQ);
    }

    public ResponseEntity<Map> getBrokeGif() {
        return commonGifClient.getBrokeGif(brokeQ);
    }

    public ResponseEntity<Map> getNoChangeGif() {
        return commonGifClient.getNoChangeGif(noChangeQ);
    }

//    private String richGifId = "LdOyjZ7io5Msw";
//    private String brokeGifId = "3orifdO6eKr9YBdOBq";
//    private String noChangeGifId = "2vs70gBAfQXvOOYsBI";
//
//    public ResponseEntity<Map> getRichGif() {
//        return commonGifClient.getRichGif(richGifId);
//    }
//
//
//    public ResponseEntity<Map> getBrokeGif() {
//        return commonGifClient.getBrokeGif(brokeGifId);
//    }
//
//    public ResponseEntity<Map> getNoChangeGif() {
//        return commonGifClient.getBrokeGif(noChangeGifId);
//    }

}
