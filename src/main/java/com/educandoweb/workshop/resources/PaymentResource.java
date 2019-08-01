package com.educandoweb.workshop.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.workshop.entities.Payment;
import com.educandoweb.workshop.services.PaymentService;

@RestController
@RequestMapping(value="/payments")
public class PaymentResource {

	@Autowired
	private PaymentService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Payment>> findAll() {
		var list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Payment> findById(@PathVariable Long id) {
		var obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
