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

    private final ExchangeCurrencyClient exchangeCurrencyClient;

    @GetMapping("/{date}/{symbols}")
    public Currency getCurrencyByDate(@PathVariable("date") String date, @PathVariable("symbols") String symbols) {
        Currency response = exchangeCurrencyClient.getCurrencyByDate(date, symbols);
        return new Currency(response.getDisclaimer(), response.getLicense(), response.getTimestamp(), response.getBase(), response.getRates());
    }
}
