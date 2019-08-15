package com.educandoweb.workshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.educandoweb.workshop.dto.PaymentDTO;
import com.educandoweb.workshop.entities.Payment;
import com.educandoweb.workshop.repositories.PaymentRepository;
import com.educandoweb.workshop.services.generics.CRUDService;

@Service
public class PaymentService implements CRUDService<Payment, PaymentDTO, Long> {

	@Autowired
	private PaymentRepository repository;

	@Override
	public JpaRepository<Payment, Long> getRepository() {
		return repository;
	}
}
