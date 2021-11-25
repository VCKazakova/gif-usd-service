package com.kazakova.gifusdservice.feignclient;

import com.kazakova.gifusdservice.model.Currency;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "exchangecurrency", url = "https://openexchangerates.org")
public interface ExchangeCurrencyClient {

    @GetMapping("/api/historical/{date}.json?app_id=cfe27e3b63004449900c92e3de48b3eb&symbols=RUB")
    Currency getCurrencyByDate(@PathVariable("date") String date);
}
