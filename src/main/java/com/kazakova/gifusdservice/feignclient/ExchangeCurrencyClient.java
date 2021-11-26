package com.kazakova.gifusdservice.feignclient;

import com.kazakova.gifusdservice.model.Currency;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "exchangecurrency", url = "https://openexchangerates.org")
public interface ExchangeCurrencyClient extends CommonExchangeClient {

    @GetMapping("/api/historical/{todayDate}.json?app_id=cfe27e3b63004449900c92e3de48b3eb&symbols={symbols}")
    Currency getCurrencyByTodayDate(@PathVariable("todayDate") String todayDate, @PathVariable("symbols") String symbols);


    @GetMapping("/api/historical/{tomorrowDate}.json?app_id=cfe27e3b63004449900c92e3de48b3eb&symbols={symbols}")
    Currency getCurrencyByTomorrowDate(@PathVariable("tomorrowDate") String tomorrowDate, @PathVariable("symbols") String symbols);
}
