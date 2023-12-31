package com.hybridgenius.proxy.client;


import com.hybridgenius.proxy.dto.URLShortenerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;

@FeignClient(name = "url-shortener-proxy", url = "urlShortener")
public interface UrlShortener {

    @PostMapping("/encode")
    public String encodeUrl(@RequestBody URLShortenerDto urlShortenerDto);

    @GetMapping("{url}")
    public void redirectUrl(@PathVariable String url, HttpServletResponse response);

    @GetMapping(value = "qrCode/{shortenedUrl}")
    public ResponseEntity<byte[]> generateQRCode(@PathVariable String shortenedUrl);

}
