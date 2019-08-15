package com.educandoweb.workshop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.workshop.dto.PaymentDTO;
import com.educandoweb.workshop.entities.Payment;
import com.educandoweb.workshop.resources.generics.CRUDResource;
import com.educandoweb.workshop.services.generics.CRUDService;

@RestController
@RequestMapping(value="/payments")
public class PaymentResource implements CRUDResource<Payment, PaymentDTO, Long> {

	@Autowired
	private CRUDService<Payment, PaymentDTO, Long> service;
	
	@Override
	public CRUDService<Payment, PaymentDTO, Long> getService() {
		return service;
	}
}
