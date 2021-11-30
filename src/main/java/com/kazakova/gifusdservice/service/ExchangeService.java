package com.kazakova.gifusdservice.service;

import com.kazakova.gifusdservice.feignclient.CommonExchangeClient;
import com.kazakova.gifusdservice.model.Currency;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExchangeService {


    private final CommonExchangeClient commonExchangeClient;

    /**
     * todayDate - вычисление сегодняшней даты
     * tomorrowDate - вычисление вчерашней даты
     */

    private final String todayDate = ZonedDateTime.now().toLocalDate().toString();
    private final String tomorrowDate = ZonedDateTime.now().minusDays(1).toLocalDate().toString();

    /**
     * @param symbols - символ валюты, передающийся в endpoint (строка, example: RUB)
     * @return coefficient - результат сравнения значений вчерашнего и сегодняшнего курса валют
     * 1 - сегодняшний > вчерашнего
     * -1 - сегодняшний < вчерашнего
     * 0 - сегодняшний = вчерашнему
     */

    public int compareCurrency(String symbols) {
        log.info(">> ExchangeService compareCurrency todayDate={}, tomorrowDate={}, symbols={}", todayDate, tomorrowDate, symbols);
        Currency today = commonExchangeClient.getCurrencyByDate(todayDate, symbols);
        Currency tomorrow = commonExchangeClient.getCurrencyByDate(tomorrowDate, symbols);
        int coefficient = today.getRates().get(symbols).compareTo(tomorrow.getRates().get(symbols));
        log.info("<< ExchangeService compareCurrency  coefficient={}", coefficient);
        return coefficient;
    }
}
