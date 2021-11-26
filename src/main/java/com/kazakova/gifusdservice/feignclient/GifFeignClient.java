package com.kazakova.gifusdservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@FeignClient(name = "gif", url = "https://api.giphy.com/v1/gifs")
//@FeignClient(name = "gif", url = "https://giphy.com/embed")
public interface GifFeignClient extends CommonGifClient {

    @GetMapping("/search?api_key=u8PWXRI3VIgnUhHPeCW99zq1kurE9vLf&q={richQ}&limit=1")
    ResponseEntity<Map> getRichGif(@PathVariable ("richQ") String richQ);

    @GetMapping("//search?api_key=u8PWXRI3VIgnUhHPeCW99zq1kurE9vLf&q={brokeQ}&limit=1")
    ResponseEntity<Map> getBrokeGif(@PathVariable ("brokeQ") String brokeQ);

    @GetMapping("//search?api_key=u8PWXRI3VIgnUhHPeCW99zq1kurE9vLf&q={noChangeQ}&limit=1")
    ResponseEntity<Map> getNoChangeGif(@PathVariable ("noChangeQ") String noChangeQ);

//    @GetMapping("/{richGifId}")
//    ResponseEntity<Map> getRichGif(@PathVariable ("richGifId") String richGifId);
//
//    @GetMapping("/{brokeGifId}")
//    ResponseEntity<Map> getBrokeGif(@PathVariable ("brokeGifId") String brokeGifId);
//
//    @GetMapping("/{noChangeGifId}")
//    ResponseEntity<Map> getNoChangeGif(@PathVariable ("noChangeGifId") String noChangeGifId);

}
