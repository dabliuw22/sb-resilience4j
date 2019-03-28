
package com.leyton.service.imple;

import java.security.SecureRandom;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leyton.service.inter.ConsumerService;
import com.leyton.service.inter.Resilience4jService;

import io.vavr.control.Try;

@Service
public class ConsumerServiceImp implements ConsumerService {

    @Autowired
    private Resilience4jService resilience4jService;

    @Override
    public String consumer() {
        SecureRandom random = new SecureRandom();
        int i = random.nextInt();
        Supplier<String> fuction = (i % 2) == 0 ? () -> resilience4jService.success()
                : () -> resilience4jService.failure();
        return Try.ofSupplier(fuction).recover(throwable -> consumerFallback(throwable)).get();
    }

    private String consumerFallback(Throwable throwable) {
        return "Fallback: " + throwable.getMessage();
    }
}
