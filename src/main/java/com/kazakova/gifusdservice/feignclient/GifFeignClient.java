package com.kazakova.gifusdservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "${gif.name}", url = "${gif.url}")
public interface GifFeignClient extends CommonGifClient {
}
