package com.deqingbank.audit.cashflow.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deqingbank.audit.cashflow.domain.Node;
import com.deqingbank.audit.cashflow.domain.ViewNode;
import com.deqingbank.audit.cashflow.service.CashFlowService;

import antlr.StringUtils;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Api
@RestController
@Slf4j
@RequestMapping("/group")
public class GroupController {
	
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
	 * 20180801132423-1136
	 */
	@RequestMapping("/list/{tracecode}")
	public List<ViewNode> getNodesGroup(@PathVariable("tracecode") String tracecode){
		log.debug(tracecode);
		List<Node> nodes = cashflowService.list().stream().filter(n->n.getTRACE_CODE().equals(tracecode)).collect(Collectors.toList());
		List<ViewNode> vNodes = new ArrayList<ViewNode>();
		for(Node n:nodes) {
			vNodes.add(new ViewNode(n));
		}
		return vNodes;
	}

}
