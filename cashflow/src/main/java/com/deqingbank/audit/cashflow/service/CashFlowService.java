package com.deqingbank.audit.cashflow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deqingbank.audit.cashflow.domain.Node;
import com.deqingbank.audit.cashflow.repository.NodeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CashFlowService {

	@Autowired
	private NodeRepository repository;
	
	
	/**
	 * list task
	 * @return
	 */
	public List<Node> list(){
		log.debug("load all nodes");
		return repository.findAll();
	}
	
}
