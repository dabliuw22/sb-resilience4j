
package com.leyton.service.imple;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.leyton.service.inter.Resilience4jService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@Service
public class Resilience4jServiceImp implements Resilience4jService {

    private static final Logger LOGGER = LoggerFactory.getLogger(Resilience4jServiceImp.class);

    @Override
    @CircuitBreaker(
            name = "resilience4j-service-circuit-breaker")
    public String circuitBreaker() {
        LOGGER.info("resilience4j-service-circuit-breaker...");
        if (generate() % 2 == 0) {
            return "Send success...";
        } else {
            throw new RuntimeException("Failure...");
        }
    }

    @Override
    // @Retry(
    // name = "resilience4j-service-retry")
    public String retry() {
        LOGGER.info("resilience4j-service-retry...");
        if (generate() % 2 == 0) {
            return "Success...";
        } else {
            throw new RuntimeException("Failure...");
        }
    }

    @Override
    @RateLimiter(
            name = "resilience4j-service-limiter")
    public String limiter() {
        LOGGER.info("resilience4j-service-limiter... {}", LocalDateTime.now());
        return "Success... " + LocalDateTime.now().toString();
    }

    @Override
    // @Bulkhead(
    // name = "resilience4j-service-bulkhead")
    public String bulkhead() {
        return "";
    }
}
