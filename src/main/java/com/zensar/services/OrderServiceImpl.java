package com.zensar.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.domain.XmlFulfilmentOrderDomain;
import com.zensar.exceptions.MacysRunTimeException;
import com.zensar.repo.XmlFulfilmentOrderRepo;

@Service
public class OrderServiceImpl implements OrderService {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	StringBuffer cause= new StringBuffer();
	
	@Autowired
	private XmlFulfilmentOrderRepo xmlOrderRepo;

	@Override
	public List<XmlFulfilmentOrderDomain> changeOrderStatus() {
		List<XmlFulfilmentOrderDomain> inProcessOrderList=new ArrayList<>();
		try {
			inProcessOrderList = xmlOrderRepo.getInProcessOrder();
			for(XmlFulfilmentOrderDomain xmlOrder: inProcessOrderList) {
				if(xmlOrder.getOrderStatusDescription().equals("IN_PROCESS")) {
					xmlOrder.setOrderStatusDescription("PROCESSED");
					xmlOrderRepo.saveAndFlush(xmlOrder);
				}
			}
		}catch (MacysRunTimeException e) {

			logger.error("--------------------EXCEPTIONAL EVENT LOG BEGINs-----------------------------------");
			logger.error("ERROR MESSAGE AS--" + e.getMessage() + " ERROR CAUSE :" + e.getCause());
			logger.error("Exception caught in changeOrderStatus Method--");
			logger.error("--------------------EXCEPTIONAL EVENT LOG ENDS-----------------------------------");
			cause.append(", ").append(e.getMessage());

		} catch (Exception e) {

			logger.error("--------------------EXCEPTIONAL EVENT LOG BEGINs-----------------------------------");
			logger.error("ERROR MESSAGE AS--" + e.getMessage() + " ERROR CAUSE :" + e.getCause());
			logger.error("Exception caught in changeOrderStatus Method--");
			logger.error("--------------------EXCEPTIONAL EVENT LOG ENDS-----------------------------------");
			cause.append(", ").append(e.getMessage());
			throw new MacysRunTimeException(e.getMessage());
		}
		
		return inProcessOrderList;
	}

	public OrderServiceImpl(XmlFulfilmentOrderRepo xmlOrderRepo) {
		super();
		this.xmlOrderRepo = xmlOrderRepo;
	}

}
