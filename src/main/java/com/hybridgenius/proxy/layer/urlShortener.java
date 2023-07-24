package com.hybridgenius.proxy.layer;


import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "url-shortener", url = "url-shortener")
public interface urlShortener {
}
