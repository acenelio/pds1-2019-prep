package com.educandoweb.workshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.educandoweb.workshop.entities.Payment;
import com.educandoweb.workshop.repositories.PaymentRepository;

@Service
public class PaymentService implements CRUDService<Payment, Long> {

	@Autowired
	private PaymentRepository repository;

	@Override
	public JpaRepository<Payment, Long> getRepository() {
		return repository;
	}

	@Override
	public void updateData(Payment newObj, Payment obj) {
	}
}
