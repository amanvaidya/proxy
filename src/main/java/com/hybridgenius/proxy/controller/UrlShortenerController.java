package com.hybridgenius.proxy.controller;

import com.hybridgenius.proxy.dto.URLShortenerDto;
import com.hybridgenius.proxy.client.UrlShortener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;

public class UrlShortenerController {
    @Autowired
    private UrlShortener urlShortener;
    @PostMapping("/encode")
    public String encodeUrl(@RequestBody URLShortenerDto urlShortenerDto){
        return urlShortener.encodeUrl(urlShortenerDto);
    }

    @GetMapping("{url}")
    public void redirectUrl(@PathVariable String url, HttpServletResponse response){
        urlShortener.redirectUrl(url, response);
    }

    @GetMapping(value = "qrCode/{shortenedUrl}")
    public ResponseEntity<byte[]> generateQRCode(@PathVariable String shortenedUrl){
        return urlShortener.generateQRCode(shortenedUrl);
    }

}
