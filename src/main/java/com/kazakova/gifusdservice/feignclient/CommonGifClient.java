package com.kazakova.gifusdservice.feignclient;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

public interface CommonGifClient {

    ResponseEntity<Map> getRichGif(String q);

    ResponseEntity<Map> getBrokeGif(String q);

    ResponseEntity<Map> getNoChangeGif(String q);

    @GetMapping(value = "/search?api_key=u8PWXRI3VIgnUhHPeCW99zq1kurE9vLf&q={tag}&limit=1")
    String getGif(@PathVariable("tag") String tag);

//    ResponseEntity<Map> getRichGif(String richGifId);
//
//    ResponseEntity<Map> getBrokeGif(String brokeGifId);
//
//    ResponseEntity<Map> getNoChangeGif(String noChangeGifId);
}
