
package com.leyton.service.inter;

import java.security.SecureRandom;

public interface Resilience4jService {

    String circuitBreaker();

    String retry();

    String limiter();

    String bulkhead();

    default int generate() {
        SecureRandom random = new SecureRandom();
        return random.nextInt();
    }
}
