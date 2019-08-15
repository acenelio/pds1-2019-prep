package com.educandoweb.workshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.educandoweb.workshop.dto.PaymentDTO;
import com.educandoweb.workshop.entities.Order;
import com.educandoweb.workshop.entities.Payment;
import com.educandoweb.workshop.repositories.OrderRepository;
import com.educandoweb.workshop.repositories.PaymentRepository;
import com.educandoweb.workshop.services.generics.CRUDService;

@Service
public class PaymentService implements CRUDService<Payment, PaymentDTO, Long> {

	@Autowired
	private PaymentRepository repository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public JpaRepository<Payment, Long> getRepository() {
		return repository;
	}
	
	@Override
	public PaymentDTO insert(PaymentDTO dto) {
		Payment payment = dto.toEntity();
		Order order = orderRepository.getOne(payment.getOrder().getId());
		order.setPayment(payment);
		payment.setOrder(order);
		order = orderRepository.save(order);
		return order.getPayment().toDTO();
	}
}
