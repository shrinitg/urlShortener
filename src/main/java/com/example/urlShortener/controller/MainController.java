package com.example.urlShortener.controller;

import com.example.urlShortener.service.ShortenUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    private ShortenUrlService shortenUrlService;

    @GetMapping("shorten")
    public ResponseEntity<String> getShortenUrl(@RequestParam String longUrl) throws URISyntaxException {
        return new ResponseEntity<>(shortenUrlService.getShortenUrl(longUrl), HttpStatus.OK);
    }

}
