package com.deqingbank.audit.cashflow.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Node {
	private String DATA_DT;
	private String TRACE_CODE;
	@Id
	private Long ID;
	private Long P_ID;
	private String STEP;
	private String ETL_DATE;
	private String ETL_FLAG;
}
