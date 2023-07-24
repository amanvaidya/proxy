package com.hybridgenius.proxy.layer;


import com.hybridgenius.proxy.dto.URLShortenerDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;


@FeignClient(value = "compressor", url = "compressor")
public interface compressor {

    @PostMapping("/compress")
    public ResponseEntity<byte[]> doCompression(@RequestParam("file") MultipartFile multipartFile);

}
