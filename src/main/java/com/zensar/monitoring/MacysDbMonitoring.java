package com.zensar.monitoring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import com.zensar.domain.JsonOrderDomain;
import com.zensar.domain.XmlFulfilmentOrderDomain;
import com.zensar.repo.JsonOrderDomainRepo;
import com.zensar.repo.XmlFulfilmentOrderRepo;

@Endpoint(id = "database-monitoring")
@Component
public class MacysDbMonitoring {
	
	@Autowired
	private JsonOrderDomainRepo jsonRepo;
	
	@Autowired
	private XmlFulfilmentOrderRepo xmlRepo;
	
	@ReadOperation
	public Map<String,String> dbMonitoring(){
		Map<String,String> orderMap=new HashMap<String, String>();
		List<JsonOrderDomain> jsonOrderlist = jsonRepo.findAll();
		Integer jsonSize = jsonOrderlist.size();
		List<XmlFulfilmentOrderDomain> xmlOrderlist = xmlRepo.findAll();
		List<XmlFulfilmentOrderDomain> inProcessOrder = xmlRepo.getInProcessOrder();
		Integer xmlSize = xmlOrderlist.size();
		Integer inProcessSize = inProcessOrder.size();
		orderMap.put("Total Json orders consumed to database", jsonSize.toString());
		orderMap.put("Total Xml orders consumed to database", xmlSize.toString());
		orderMap.put("In-process xml orders in database", inProcessSize.toString());
		return orderMap;
		
	}
}
