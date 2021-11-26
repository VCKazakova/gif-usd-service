package com.kazakova.gifusdservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kazakova.gifusdservice.service.ExchangeService;
import com.kazakova.gifusdservice.service.GifService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ExchangeService exchangeService;
    private final GifService gifService;

    @GetMapping("/gif")
    public ResponseEntity<Map> getSuitableGif() throws JsonProcessingException {
        int coff = exchangeService.compareCurrency();
        gifService.getGif(coff);
        return null;
    }

}
