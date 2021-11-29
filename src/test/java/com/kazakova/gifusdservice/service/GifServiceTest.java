package com.kazakova.gifusdservice.service;


import com.github.tomakehurst.wiremock.WireMockServer;
import com.kazakova.gifusdservice.feignclient.CommonGifClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
@DisplayName("GifService должен")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {WireMockConfig.class})
public class GifServiceTest {


    @Autowired
    private WireMockServer mockExchangeService;

    @Autowired
    private CommonGifClient commonGifClient;

    @BeforeEach
    void setUp() throws IOException {
        CurrencyMocks.setupMockExchangeResponse(mockExchangeService);
    }

    @Test
    @DisplayName("Возвращать json, относительно выбранного тэга")
    public void whenGetGif_thenGifShouldBeReturned() {
        Assertions.assertFalse(commonGifClient.getGif("rich").isEmpty());
    }

    @Test
    @DisplayName("Возвращать элементы, содержащиеся в json объекте")
    public void whenGetGif_thenTheCorrectContainsKeyShouldBeReturned() {
        assertTrue(commonGifClient.getGif("rich")
                .contains("data"));
        assertTrue(commonGifClient.getGif("rich")
                .contains("embed_url"));
    }


}
