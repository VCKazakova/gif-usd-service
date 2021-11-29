package com.kazakova.gifusdservice.controller;

import com.kazakova.gifusdservice.service.ExchangeService;
import com.kazakova.gifusdservice.service.GifService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ClientController {

    private final ExchangeService exchangeService;
    private final GifService gifService;

    @RequestMapping(value = "/compare_currency/{symbols}")
    public void compareCurrency(HttpServletResponse response, @PathVariable("symbols") String symbols) {
        int coefficient = exchangeService.compareCurrency(symbols);
        try {
            String url = gifService.getGif(coefficient);
            response.sendRedirect(url);
        } catch (ParseException exception) {
            log.info("<< ClientController compareCurrency catch ParseException while parsing JSON");
            exception.printStackTrace();
        } catch (IOException exception) {
            log.info("<< ClientController compareCurrency catch IOException while sending redirect");
            exception.printStackTrace();
        }
    }
}
