package com.zensar;



import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.zensar.repo.XmlFulfilmentOrderRepo;
import com.zensar.services.OrderServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class MacysOrderServiceApplicationTests {
	
	@Mock
	private XmlFulfilmentOrderRepo xmlRepo;
	
	private OrderServiceImpl service;
	
	@BeforeEach
	void setUp() {
		this.service= new OrderServiceImpl(xmlRepo);
	}
	
	@Test
	void testInProcessOrder() {
		service.changeOrderStatus();
		verify(xmlRepo).getInProcessOrder();
	}
	
}
