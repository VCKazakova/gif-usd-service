package com.kazakova.gifusdservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Currency {

    private String disclaimer;
    private String license;
    private Date timestamp;
    private String base;
    private Map<String, BigDecimal> rates;

}
