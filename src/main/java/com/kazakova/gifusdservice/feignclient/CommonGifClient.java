package com.kazakova.gifusdservice.feignclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface CommonGifClient {

    @GetMapping(value = "/search?api_key=u8PWXRI3VIgnUhHPeCW99zq1kurE9vLf&q={tag}&limit=1")
    String getGif(@PathVariable("tag") String tag);

}
