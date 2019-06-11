package com.deqingbank.audit.cashflow.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.deqingbank.audit.cashflow.domain.Node;



public interface NodeRepository extends JpaRepository<Node, Long>{
	

}
