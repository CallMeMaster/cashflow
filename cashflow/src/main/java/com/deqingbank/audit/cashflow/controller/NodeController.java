package com.deqingbank.audit.cashflow.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deqingbank.audit.cashflow.domain.Node;
import com.deqingbank.audit.cashflow.service.CashFlowService;

import io.swagger.annotations.Api;

@Api
@RestController
@RequestMapping("/node")
public class NodeController {
	
	@Autowired
	private CashFlowService cashflowService;
	
	/**
	 * 所有pID为null的节点 
	 * @return
	 */
	@RequestMapping("/list")
	public List<Node> getStartNode(){
		return cashflowService.list().stream().filter(n->n.getP_ID() == null).collect(Collectors.toList());
	}
	
	/**
	 * 获取id为{id}的节点
	 * @param id
	 * @return
	 */
	@RequestMapping("/list/{id}")
	public List<Node> getNodesGroup(@PathVariable("id") long id){
		return cashflowService.list().stream().filter(n->n.getID() == id).collect(Collectors.toList());
	}
	
	/**
	 * 获取id为{id}的tracecode
	 * @param id
	 * @return
	 */
	@RequestMapping("/list/{id}/tracecode")
	public String getTracecode(@PathVariable("id") long id){
		return cashflowService.list().stream().filter(n->n.getID() == id).collect(Collectors.toList()).get(0).getTRACE_CODE();
	}

}
