package com.kazakova.gifusdservice.controller;

import com.kazakova.gifusdservice.service.ExchangeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Client controller должен")
public class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ExchangeService exchangeService;

    @Test
    @DisplayName("Сравнивать сегодняшний и вчерашний курс USD")
    public void testCompareCurrency() throws Exception {
        String symbols = "RUB";

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/compare_currency/{symbols}", symbols);

        mockMvc.perform(request)
                .andDo(result -> exchangeService.compareCurrency(symbols));
    }

    @Test
    @DisplayName("Делать редирект на страницу с подходящей gif")
    public void testRedirect() throws Exception {

        String symbols = "RUB";

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/compare_currency/{symbols}", symbols);

        mockMvc.perform(request)
                .andExpect(status().is3xxRedirection());
    }


}
