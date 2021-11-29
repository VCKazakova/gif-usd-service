package com.kazakova.gifusdservice.feignclient;


import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { WireMockConfig.class })
public class ExchangeCurrencyClientTest {


    @Autowired
    private WireMockServer mockExchangeService;

    @Autowired
    private CommonExchangeClient commonExchangeClient;

    @BeforeEach
    void setUp() throws IOException {
        CurrencyMocks.setupMockExchangeResponse(mockExchangeService);
    }

    @Test
    public void whenCompareCurrency_thenCurrencyShouldBeReturned() {
        Assertions.assertFalse(commonExchangeClient.getCurrencyByDate("2021-11-23", "RUB").getRates().isEmpty());
    }

    @Test
    public void whenCompareCurrency_thenTheCorrectContainsKeyShouldBeReturned() {
        assertTrue(commonExchangeClient.getCurrencyByDate("2021-11-29", "RUB").getRates()
                .containsKey("RUB"));
    }


}
