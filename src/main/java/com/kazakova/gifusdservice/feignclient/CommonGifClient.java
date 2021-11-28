package com.kazakova.gifusdservice.feignclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface CommonGifClient {

    @GetMapping(value = "/random?api_key=u8PWXRI3VIgnUhHPeCW99zq1kurE9vLf&q={tag}")
    String getGif(@PathVariable("tag") String tag);

}
