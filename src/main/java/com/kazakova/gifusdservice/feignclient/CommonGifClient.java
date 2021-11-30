package com.kazakova.gifusdservice.feignclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface CommonGifClient {

    /**
     * @param tag - тэг, по которому возвращается рандомный gif-файл
     * @return String - url подходящего gif-файла
     */


    @GetMapping(value = "/random?api_key=u8PWXRI3VIgnUhHPeCW99zq1kurE9vLf&q={tag}")
    String getGif(@PathVariable("tag") String tag);

}
