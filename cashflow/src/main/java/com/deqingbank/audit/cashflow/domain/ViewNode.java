package com.deqingbank.audit.cashflow.domain;

import lombok.Data;

@Data
public class ViewNode {

	private Node node;
	private int x;
	private int y;
	private Long id;
	private Long name;
	
	public ViewNode(Node node) {
		this.node=node;
		this.id = node.getID();
		this.name = this.id;
		this.x=(int) (Math.random()*1000);
		this.y=(int) (Math.random()*1000);
	}
}

