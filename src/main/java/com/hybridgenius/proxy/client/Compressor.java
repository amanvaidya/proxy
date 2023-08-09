package com.hybridgenius.proxy.client;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "compressor-proxy", url = "compressor")
public interface Compressor {

    @PostMapping("/compress")
    public ResponseEntity<byte[]> doCompression(@RequestParam("file") MultipartFile multipartFile);

}
