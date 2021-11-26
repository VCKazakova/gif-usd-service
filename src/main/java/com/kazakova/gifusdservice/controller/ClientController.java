package com.kazakova.gifusdservice.controller;

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
    public ResponseEntity<Map> getSuitableGif() {
        int coff = exchangeService.compareCurrency();
        switch (coff) {
            case 1:
                return gifService.getRichGif();
            case -1:
                return gifService.getBrokeGif();
            case 0:
                return gifService.getNoChangeGif();
        }
        return null;
    }

}
