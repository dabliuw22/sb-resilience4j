
package com.leyton.service.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leyton.service.inter.ConsumerService;
import com.leyton.service.inter.Resilience4jService;

@Service
public class ConsumerServiceImp implements ConsumerService {

    @Autowired
    private Resilience4jService resilience4jService;

    @Override
    public String circuitBreaker() {
        return trySupplier(() -> resilience4jService.circuitBreaker(), this::recovery);
    }

    @Override
    public String retry() {
        return trySupplier(() -> resilience4jService.retry(), this::recovery);
    }

    @Override
    public String limiter() {
        return resilience4jService.limiter();
    }

    @Override
    public String bulkhead() {
        return resilience4jService.bulkhead();
    }

    private String recovery(Throwable throwable) {
        return "Recovery: " + throwable.getMessage();
    }
}
