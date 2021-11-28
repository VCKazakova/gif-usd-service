package com.kazakova.gifusdservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "gif", url = "https://api.giphy.com/v1/gifs")
public interface GifFeignClient extends CommonGifClient {
}
