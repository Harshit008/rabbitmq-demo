package com.zensar.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zensar.domain.XmlFulfilmentOrderDomain;
@Repository
public interface XmlFulfilmentOrderRepo extends JpaRepository<XmlFulfilmentOrderDomain, Integer> {
	
	@Query(value = "SELECT * from xml_fulfilment_order_domain where order_status_description='IN_PROCESS'", nativeQuery = true)
	public List<XmlFulfilmentOrderDomain> getInProcessOrder();
	
	
}
