package com.springboot.resilience4j_dashboard;

import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class MyService {

	 @CircuitBreaker(name = "myService")
	    public String callExternalService() {
	        // Simulate a call to an external service that may fail
	        if (Math.random() > 0.5) {
	            throw new RuntimeException("Service failure");
	        }
	        return "Success";
	    }
}
