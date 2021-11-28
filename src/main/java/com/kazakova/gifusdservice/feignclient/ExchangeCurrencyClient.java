package com.kazakova.gifusdservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "exchangecurrency", url = "${exchange.client.url}")
public interface ExchangeCurrencyClient extends CommonExchangeClient {

}
