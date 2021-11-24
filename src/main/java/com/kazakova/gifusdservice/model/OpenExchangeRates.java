package com.kazakova.gifusdservice.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OpenExchangeRates {

    private LocalDate date;

    private String aap_id = "cfe27e3b63004449900c92e3de48b3eb";

    private Currency currency;
}
