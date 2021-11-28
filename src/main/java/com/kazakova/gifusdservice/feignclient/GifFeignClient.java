package com.kazakova.gifusdservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "gif", url = "${gif.client.url}")
public interface GifFeignClient extends CommonGifClient {
}
