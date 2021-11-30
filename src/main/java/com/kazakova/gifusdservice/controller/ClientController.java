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

    /**
     * @param response - отпределяет ответ клиенту
     * @param symbols  - символ валюты, передающийся в endpoint (строка, example: RUB)
     *                 метод compareCurrency - запускает сравнение сегодняшнего и вчерашнего курса валют;
     *                 реализует перенаправление на подходящий gif-файл
     * @throws ParseException (org.json.simple.parser) - может быть выбрашено во время парсинга JSON
     * @throws IOException    - может быть выбрашено во время перенаправления на страницу с gif-файлом
     */
    @RequestMapping(value = "/compare_currency/{symbols}")
    public void compareCurrency(HttpServletResponse response, @PathVariable("symbols") String symbols) {
        log.info(">> ClientController compareCurrency  symbols={}", symbols);
        try {
            int coefficient = exchangeService.compareCurrency(symbols);
            String url = gifService.getGif(coefficient);
            response.sendRedirect(url);
        } catch (Exception exception) {
            log.error("<< ClientController compareCurrency catch exception {} while parsing JSON or redirecting", exception.getClass().getName());
        }
    }
}
