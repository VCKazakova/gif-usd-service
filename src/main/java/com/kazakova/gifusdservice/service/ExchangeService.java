package com.kazakova.gifusdservice.service;

import com.kazakova.gifusdservice.feignclient.CommonExchangeClient;
import com.kazakova.gifusdservice.model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class ExchangeService {

    @Autowired
    private CommonExchangeClient commonExchangeClient;

    private Currency prevDay;
    private Currency thisDay;

    private String todayDate = ZonedDateTime.now().toLocalDate().toString();
    private String tomorrowDate = ZonedDateTime.now().minusDays(1).toLocalDate().toString();


    public int compareCurrency() {
        thisDay = commonExchangeClient.getCurrencyByTodayDate(todayDate, "RUB");
        prevDay = commonExchangeClient.getCurrencyByTomorrowDate(tomorrowDate, "RUB");

        return thisDay.getRates().get("RUB").compareTo(prevDay.getRates().get("RUB"));

    }
}
