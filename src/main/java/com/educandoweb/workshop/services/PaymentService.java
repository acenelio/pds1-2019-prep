package com.educandoweb.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.workshop.entities.Payment;
import com.educandoweb.workshop.repositories.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository repository;
	
	public List<Payment> findAll() {
		return repository.findAll();
	}
	
	public Payment findById(Long id) {
		Optional<Payment> result = repository.findById(id);
		return result.get();
	}
}
