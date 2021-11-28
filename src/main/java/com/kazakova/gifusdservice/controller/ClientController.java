package com.kazakova.gifusdservice.controller;

import com.kazakova.gifusdservice.service.ExchangeService;
import com.kazakova.gifusdservice.service.GifService;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ExchangeService exchangeService;
    private final GifService gifService;

    @RequestMapping(value = "/redirect")
    public void redirect(HttpServletResponse response) throws ParseException, IOException {
        int coff = exchangeService.compareCurrency();
        String url = gifService.getGif(coff);
        response.sendRedirect(url);
    }
}
