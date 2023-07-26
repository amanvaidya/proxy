package com.hybridgenius.proxy.layer;



import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@FeignClient(value = "compressor", url = "compressor")
public interface Compressor {

    @PostMapping("/compress")
    public ResponseEntity<byte[]> doCompression(@RequestParam("file") MultipartFile multipartFile);

}
