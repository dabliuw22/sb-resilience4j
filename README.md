# Resilience4j and Spring Boot

Resilience4j is implemented in this project, which provides solutions for:
	* CircuitBreaker
	* Bulkhead
	* RateLimiter
	* Retry
	* TimeLimiter
	* Cache

1. For `CircuitBreaker` we have the following properties:
	* `failure-rate-threshold`: Percentage above which the CircuitBreaker should trip open and start short-circuiting calls.
	* `wait-duration-in-open-state`: the wait duration which specifies how long the CircuitBreaker should stay open, before it switches to half open.
	* `ring-buffer-size-in-half-open-state`: the size of the ring buffer when the CircuitBreaker is half open.
	* `ring-buffer-size-in-closed-state`: the size of the ring buffer when the CircuitBreaker is closed.
	* `ignore-exceptions`: list of exceptions to ignore.
	* `record-exceptions`: list of exceptions to register.