package com.hybridgenius.proxy.configuration;

import com.hybridgenius.proxy.util.RateLimiterPerUserIP;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final RateLimiterPerUserIP rateLimiterPerUserIP;

    public WebMvcConfig(RateLimiterPerUserIP rateLimiterPerUserIP) {
        this.rateLimiterPerUserIP = rateLimiterPerUserIP;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(rateLimiterPerUserIP);
    }

}
