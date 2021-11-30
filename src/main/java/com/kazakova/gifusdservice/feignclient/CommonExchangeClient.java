package com.kazakova.gifusdservice.feignclient;

import com.kazakova.gifusdservice.model.Currency;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface CommonExchangeClient {

    /**
     * @param date    - дата, по которой возвращается курс
     * @param symbols - валюта, относительно которой считается курс USD
     * @return Currency - JSON с необходимыми данными
     */

    @GetMapping("/{date}.json?app_id=cfe27e3b63004449900c92e3de48b3eb&symbols={symbols}")
    Currency getCurrencyByDate(@PathVariable("date") String date, @PathVariable("symbols") String symbols);

}
