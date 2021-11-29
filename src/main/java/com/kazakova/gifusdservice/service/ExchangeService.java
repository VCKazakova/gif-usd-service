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

    private Currency tomorrow;
    private Currency today;

    private String todayDate = ZonedDateTime.now().toLocalDate().toString();
    private String tomorrowDate = ZonedDateTime.now().minusDays(1).toLocalDate().toString();


    public int compareCurrency(String symbols) {
        today = commonExchangeClient.getCurrencyByDate(todayDate, symbols);
        tomorrow = commonExchangeClient.getCurrencyByDate(tomorrowDate, symbols);
        return today.getRates().get(symbols).compareTo(tomorrow.getRates().get(symbols));
    }
}
