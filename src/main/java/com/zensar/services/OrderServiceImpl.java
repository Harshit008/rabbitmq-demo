package com.zensar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.domain.XmlFulfilmentOrderDomain;
import com.zensar.repo.XmlFulfilmentOrderRepo;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private XmlFulfilmentOrderRepo xmlOrderRepo;

	@Override
	public List<XmlFulfilmentOrderDomain> changeOrderStatus() {
		List<XmlFulfilmentOrderDomain> inProcessOrderList = xmlOrderRepo.getInProcessOrder();
		for(XmlFulfilmentOrderDomain xmlOrder: inProcessOrderList) {
			if(xmlOrder.getOrderStatusDescription().equals("IN_PROCESS")) {
				xmlOrder.setOrderStatusDescription("PROCESSED");
				xmlOrderRepo.saveAndFlush(xmlOrder);
			}
		}
		return inProcessOrderList;
	}

	public OrderServiceImpl(XmlFulfilmentOrderRepo xmlOrderRepo) {
		super();
		this.xmlOrderRepo = xmlOrderRepo;
	}

}
