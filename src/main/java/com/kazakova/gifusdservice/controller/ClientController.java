package com.kazakova.gifusdservice.controller;

import com.kazakova.gifusdservice.feignclient.ExchangeCurrencyClient;
import com.kazakova.gifusdservice.model.Currency;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClientController {

    private ExchangeCurrencyClient exchangeCurrencyClient;

    @GetMapping("/{date}")
    public Currency getCurrencyByDate(@PathVariable("date") String date) {
        Currency response = exchangeCurrencyClient.getCurrencyByDate(date);
        return new Currency(response.getDisclaimer(), response.getLicense(), response.getTimestamp(), response.getBase(), response.getRates());
    }
}
