package com.kazakova.gifusdservice.feignclient;

import com.kazakova.gifusdservice.model.Currency;
import org.springframework.web.bind.annotation.PathVariable;

public interface CommonExchangeClient {

    Currency getCurrencyByTodayDate(String todayDate, String symbols);

    Currency getCurrencyByTomorrowDate(String tomorrowDate, String symbols);

}
