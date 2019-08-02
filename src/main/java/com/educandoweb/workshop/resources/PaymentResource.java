package com.educandoweb.workshop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.workshop.entities.Payment;
import com.educandoweb.workshop.services.CRUDService;
import com.educandoweb.workshop.services.PaymentService;

@RestController
@RequestMapping(value="/payments")
public class PaymentResource implements CRUDResource<Payment, Long> {

	@Autowired
	private PaymentService service;

	@Override
	public CRUDService<Payment, Long> getService() {
		return service;
	}
}
