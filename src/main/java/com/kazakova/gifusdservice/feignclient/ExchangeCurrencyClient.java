package com.kazakova.gifusdservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "${exchange.name}", url = "${exchange.url}")
public interface ExchangeCurrencyClient extends CommonExchangeClient {

}
