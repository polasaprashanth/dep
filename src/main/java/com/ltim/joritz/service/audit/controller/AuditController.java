package com.ltim.joritz.service.audit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ltim.joritz.service.audit.entity.Audit;
import com.ltim.joritz.service.audit.entity.Transaction;
import com.ltim.joritz.service.audit.repository.AuditRepository;
import com.ltim.joritz.service.audit.repository.AuditTypeRepository;

@RestController
@RequestMapping("/api/v1/audit")
public class AuditController {

	@Autowired
	private AuditRepository auditRepository;
	
	@Autowired
	private AuditTypeRepository auditTypeRepository;
	
	@GetMapping("/")
    public List<Audit> audits() {
		List<Audit> audits = auditRepository.findAll();
		return audits;
	}
	
	@PostMapping("/")
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ResponseEntity<Void> audit(@RequestBody Audit audit) {
        try{
            ResponseEntity<Void> re = null;
            auditRepository.save(audit);
            re = new ResponseEntity<>(HttpStatus.CREATED);
            return re;
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return null;
    }
}
