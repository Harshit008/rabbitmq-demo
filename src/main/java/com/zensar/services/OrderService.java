package com.zensar.services;

import java.util.List;

import com.zensar.domain.XmlFulfilmentOrderDomain;

public interface OrderService {

	public List<XmlFulfilmentOrderDomain> changeOrderStatus();

}
