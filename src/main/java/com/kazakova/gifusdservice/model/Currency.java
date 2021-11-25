package com.kazakova.gifusdservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Currency {

    private String disclaimer;
    private String license;
    private LocalDateTime timestamp;
    private String base;
    private Map<String, BigDecimal> rates;
}
