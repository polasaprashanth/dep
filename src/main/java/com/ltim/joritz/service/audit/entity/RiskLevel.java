package com.ltim.joritz.service.audit.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class RiskLevel {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Risk_Level_Id")
    private Long riskLevelId;
	
	 @Column(name = "Risk_Level_Name")
	private String riskLevelName;

	public Long getRiskLevelId() {
		return riskLevelId;
	}

	public void setRiskLevelId(Long riskLevelId) {
		this.riskLevelId = riskLevelId;
	}

	public String getRiskLevelName() {
		return riskLevelName;
	}

	public void setRiskLevelName(String riskLevelName) {
		this.riskLevelName = riskLevelName;
	}
	 
//	@OneToMany(mappedBy = "riskLevel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Audit> audits;
	
}
