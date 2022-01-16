package com.zensar.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.services.OrderService;

@RequestMapping("/order-service")
@RestController
public class MacysOrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(MacysOrderController.class);
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/testApi")
	public String testApi() {
		return "Welcome to MacysOrder app!";
	}
	
	@GetMapping("/changeOrderStatus")
	public ResponseEntity<String> updateOrderStatus(){
		orderService.changeOrderStatus();
		return null;
		
	}
}
