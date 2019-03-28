
package com.leyton.service.imple;

import org.springframework.stereotype.Service;

import com.leyton.service.inter.Resilience4jService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
@CircuitBreaker(
        name = "resilience4j-service")
public class Resilience4jServiceImp implements Resilience4jService {

    @Override
    public String success() {
        return "Success...";
    }

    @Override
    public String failure() {
        throw new RuntimeException("Failure...");
    }
}
