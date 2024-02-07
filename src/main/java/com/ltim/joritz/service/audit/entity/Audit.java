package com.ltim.joritz.service.audit.entity;

import static jakarta.persistence.TemporalType.TIMESTAMP;

import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;

@Entity
public class Audit {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Audit_Id")
    private Long auditId;
	
	@ManyToOne
    @JoinColumn(name = "Audit_Type_Id")
    private AuditType auditType;
	
	@Column(name = "Source")
    private String source;
	
	@CreatedDate
    @Temporal(TIMESTAMP)
    protected Date createdDate;
    
	@CreatedBy
    protected String createdBy;
	
	@ManyToOne
    @JoinColumn(name = "Transaction_Id")
	private Transaction transaction;
	
	@ManyToOne
    @JoinColumn(name = "Risk_Level_Id")
	private RiskLevel riskLevel;
	
	@ManyToOne
    @JoinColumn(name = "Log_Level_Id")
	private LogLevel logLevel;

	private Audit() {}
	
	public Audit(Long auditId, AuditType auditType, String source, Date createdDate, String createdBy,
			Transaction transaction, RiskLevel riskLevel, LogLevel logLevel) {
		super();
		this.auditId = auditId;
		this.auditType = auditType;
		this.source = source;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.transaction = transaction;
		this.riskLevel = riskLevel;
		this.logLevel = logLevel;
	}

	public Long getAuditId() {
		return auditId;
	}

	public void setAuditId(Long auditId) {
		this.auditId = auditId;
	}

	public AuditType getAuditType() {
		return auditType;
	}

	public void setAuditType(AuditType auditType) {
		this.auditType = auditType;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public RiskLevel getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(RiskLevel riskLevel) {
		this.riskLevel = riskLevel;
	}

	public LogLevel getLogLevel() {
		return logLevel;
	}

	public void setLogLevel(LogLevel logLevel) {
		this.logLevel = logLevel;
	}
	
	
	
}
