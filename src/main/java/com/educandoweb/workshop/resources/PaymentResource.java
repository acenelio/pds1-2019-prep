package com.educandoweb.workshop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.workshop.dto.PaymentDTO;
import com.educandoweb.workshop.entities.Payment;
import com.educandoweb.workshop.resources.generics.CreateResource;
import com.educandoweb.workshop.resources.generics.RetrieveResource;
import com.educandoweb.workshop.resources.generics.UpdateResource;
import com.educandoweb.workshop.services.PaymentService;
import com.educandoweb.workshop.services.generics.CRUDService;

@RestController
@RequestMapping(value="/payments")
public class PaymentResource implements CreateResource<Payment, PaymentDTO, Long>, RetrieveResource<Payment, PaymentDTO, Long>, UpdateResource<Payment, PaymentDTO, Long> {

	@Autowired
	private PaymentService service;
	
	@Override
	public CRUDService<Payment, PaymentDTO, Long> getService() {
		return service;
	}
}
