package com.kazakova.gifusdservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kazakova.gifusdservice.service.ExchangeService;
import com.kazakova.gifusdservice.service.GifService;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ExchangeService exchangeService;
    private final GifService gifService;

    @GetMapping("/gif")
    public String getSuitableGif() throws JsonProcessingException, ParseException {
        int coff = exchangeService.compareCurrency();
        return gifService.getGif(coff);
    }

    @RequestMapping(value = "/redirect")
    public void redirect(HttpServletResponse response) throws ParseException, IOException {
        int coff = exchangeService.compareCurrency();
        String url = gifService.getGif(coff);
        response.sendRedirect(url);
    }
}
