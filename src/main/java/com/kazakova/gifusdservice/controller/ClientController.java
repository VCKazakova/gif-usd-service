package com.kazakova.gifusdservice.controller;

import com.kazakova.gifusdservice.service.ExchangeService;
import com.kazakova.gifusdservice.service.GifService;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ExchangeService exchangeService;
    private final GifService gifService;

    @RequestMapping(value = "/compare_currency/{symbols}")
    public void compareCurrency(HttpServletResponse response, @PathVariable("symbols") String symbols) throws ParseException, IOException {
        int coff = exchangeService.compareCurrency(symbols);
        String url = gifService.getGif(coff);
        response.sendRedirect(url);
    }
}
