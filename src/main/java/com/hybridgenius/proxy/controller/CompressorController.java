package com.hybridgenius.proxy.controller;

import com.hybridgenius.proxy.layer.Compressor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class CompressorController {
    @Autowired
    private Compressor compressor;

    @PostMapping("/compress")
    public ResponseEntity<byte[]> doCompression(@RequestParam("file") MultipartFile multipartFile){
        return compressor.doCompression(multipartFile);
    }
}
