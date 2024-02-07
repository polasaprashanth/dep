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
public class LogLevel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Log_Level_Id")
    private Long logLevelId;
	
	 @Column(name = "Log_Level_Name")
	private String logLevelName;

	public Long getLogLevelId() {
		return logLevelId;
	}

	public void setLogLevelId(Long logLevelId) {
		this.logLevelId = logLevelId;
	}

	public String getLogLevelName() {
		return logLevelName;
	}

	public void setLogLevelName(String logLevelName) {
		this.logLevelName = logLevelName;
	}
	 
//	@OneToMany(mappedBy = "logLevel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Audit> audits;
	

}
