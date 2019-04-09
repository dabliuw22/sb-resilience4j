# Resilience4j and Spring Boot

Resilience4j is implemented in this project, which provides solutions for:
* CircuitBreaker
* RateLimiter
* Retry
* Bulkhead
* TimeLimiter
* Cache

1. For `CircuitBreaker` we have the following properties:
	* `failure-rate-threshold`: Percentage above which the CircuitBreaker should trip open and start short-circuiting calls.
	* `wait-duration-in-open-state`: The wait duration which specifies how long the CircuitBreaker should stay open, before it switches to half open.
	* `ring-buffer-size-in-half-open-state`: The size of the ring buffer when the CircuitBreaker is half open.
	* `ring-buffer-size-in-closed-state`: The size of the ring buffer when the CircuitBreaker is closed.
	* `ignore-exceptions`: List of exceptions to ignore.
	* `record-exceptions`: List of exceptions to register.
	
2. For `RateLimiter` whe have the following properties:
	* `limit-for-period`: Process number executed per period.
	* `limit-refresh-period-in-millis`: Time after which the period will be restarted.
	* `timeout-in-millis`: Permission waiting time.
	
3. For `Retry` whe have the following properties:
	* `max-retry-attempts`: Maximum number of retries.
	* `wait-duration`: Waiting time between successive attempts.  
	* `enable-exponential-backoff`: Enable exponential retry strategy.
	* `exponential-backoff-multiplier`: Factor for exponential strategy.
	* `retry-exceptions`: List of exceptions that must trigger a retry.