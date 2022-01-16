package com.zensar.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.domain.XmlFulfilmentOrderDomain;
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
	public ResponseEntity<List<XmlFulfilmentOrderDomain>> updateOrderStatus(){
		List<XmlFulfilmentOrderDomain> list = orderService.changeOrderStatus();
		logger.info("Affected records are : "+list);
		return new ResponseEntity<List<XmlFulfilmentOrderDomain>>(list, HttpStatus.OK);
		
	}
}
