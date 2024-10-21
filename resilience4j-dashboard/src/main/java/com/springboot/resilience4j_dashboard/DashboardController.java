package com.springboot.resilience4j_dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;

@RestController
public class DashboardController {

	 @Autowired
	 private MyService myService;
	 

	 @Autowired
	 private CircuitBreakerRegistry circuitBreakerRegistry;
	    
	 @GetMapping("/call-service")
	 public String callService(Model model) {
		 String result = myService.callExternalService();
	     model.addAttribute("result", result);
	     return "dashboard"; // Return the name of the Thymeleaf template
	 }
	 
	 @GetMapping("/dashboard")
	 public String dashboard(Model model) {
	     CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker("myService");
	     model.addAttribute("circuitBreakerState", circuitBreaker.getState());
	     return "dashboard"; // Return the name of the Thymeleaf template for the dashboard view
	 }
}
