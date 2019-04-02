
package com.leyton.service.inter;

import java.util.function.Function;
import java.util.function.Supplier;

import io.vavr.control.Try;

public interface ConsumerService {

    String circuitBreaker();

    String retry();

    String limiter();

    String bulkhead();

    default <T> T trySupplier(Supplier<T> function,
            Function<? super Throwable, ? extends T> recovery) {
        return Try.ofSupplier(function).recover(recovery).get();
    }
}
