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

import com.ltim.joritz.service.audit.entity.Module;
import com.ltim.joritz.service.audit.entity.Transaction;
import com.ltim.joritz.service.audit.repository.ModuleRepository;
import com.ltim.joritz.service.audit.repository.TransactionRepository;
import com.ltim.joritz.service.audit.service.TransactionService;


@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {
	
	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private ModuleRepository moduleRepository;
	
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/test")
    public String test() {
		return "working";
	}
	
	@GetMapping("/")
    public List<Transaction> transactions() {
		try {
			return transactionRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@PostMapping("/")
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ResponseEntity<Void> transaction(@RequestBody Transaction transaction) {
        try{
            ResponseEntity<Void> re = null;
            transactionRepository.save(transaction);
            re = new ResponseEntity<>(HttpStatus.CREATED);
            return re;
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return null;
    }
}
