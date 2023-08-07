package com.hybridgenius.proxy.util;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class RateLimiterPerUserIP implements HandlerInterceptor {
    private static final double RATE_LIMIT = 2.0; // Adjust the rate limit as needed
    private Map<String, RateLimiter> rateLimiterMap = new ConcurrentHashMap<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userIP = GetUserIP.getUserIP(request);

        rateLimiterMap.putIfAbsent(userIP, RateLimiter.create(RATE_LIMIT));
        RateLimiter rateLimiter = rateLimiterMap.get(userIP);

        if (!rateLimiter.tryAcquire()) {
            response.sendError(429, "Rate limit exceeded.");
            return false;
        }
        return true;
    }
}
