package com.hybridgenius.proxy.layer;


import com.hybridgenius.proxy.dto.URLShortenerDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@FeignClient(value = "url-shortener", url = "url-shortener")
public interface urlShortener {

    @PostMapping("/encode")
    public String encodeUrl(@RequestBody URLShortenerDto urlShortenerDto);

    @GetMapping("{url}")
    public void redirectUrl(@PathVariable String url, HttpServletResponse response);

    @GetMapping(value = "qrCode/{shortenedUrl}")
    public ResponseEntity<byte[]> generateQRCode(@PathVariable String shortenedUrl);

}
