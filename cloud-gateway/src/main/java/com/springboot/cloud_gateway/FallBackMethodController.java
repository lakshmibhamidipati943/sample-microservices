package com.springboot.cloud_gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class FallBackMethodController {

	 @GetMapping("/usersServiceFallBack")
	    @CircuitBreaker(name = "userServiceCircuitBreaker", fallbackMethod = "userServiceFallback")
	    public String userServiceFallBackMethod() {
	        // Simulate a service call that may fail
	        throw new RuntimeException("Simulated failure");
	    }

	    public String userServiceFallback(Exception ex) {
	        return "User Service is taking longer than expected. Please try again later.";
	    }

	    @GetMapping("/departmentServiceFallBack")
	    @CircuitBreaker(name = "departmentServiceCircuitBreaker", fallbackMethod = "departmentServiceFallback")
	    public String departmentServiceFallBackMethod() {
	        // Simulate a service call that may fail
	        throw new RuntimeException("Simulated failure");
	    }

	    public String departmentServiceFallback(Exception ex) {
	        return "Department Service is taking longer than expected. Please try again later.";
	    }
}
