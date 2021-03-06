
package com.leyton.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leyton.service.inter.ConsumerService;

@RestController
@RequestMapping(
        value = {
            "/resilience"
        })
public class Resilience4jController {

    @Autowired
    private ConsumerService consumerService;

    @GetMapping(
            value = "/circuit-breaker")
    public String circuitBreaker() {
        return consumerService.circuitBreaker();
    }

    @GetMapping(
            value = "/retry")
    public String retry() {
        return consumerService.retry();
    }

    @GetMapping(
            value = "/limiter")
    public String limiter() {
        return consumerService.limiter();
    }
}
