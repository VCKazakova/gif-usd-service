package com.kazakova.gifusdservice.feignclient;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface CommonGifClient {

    ResponseEntity<Map> getRichGif(String q);

    ResponseEntity<Map> getBrokeGif(String q);

    ResponseEntity<Map> getNoChangeGif(String q);

//    ResponseEntity<Map> getRichGif(String richGifId);
//
//    ResponseEntity<Map> getBrokeGif(String brokeGifId);
//
//    ResponseEntity<Map> getNoChangeGif(String noChangeGifId);
}
