package com.educandoweb.workshop.dto;

import java.time.Instant;

import com.educandoweb.workshop.entities.Order;
import com.educandoweb.workshop.entities.Payment;

public class PaymentDTO implements DTO<Payment, Long> {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Instant moment;
	private Long orderId;
	
	public PaymentDTO() {
	}
	
	public PaymentDTO(Payment entity) {
		if (entity.getOrder() == null) {
			throw new IllegalStateException("Error instantiating PaymentDTO: order was null");
		}
		setId(entity.getId());
		setMoment(entity.getMoment());
		setOrderId(entity.getOrder().getId());
	}
	
	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	@Override
	public Payment toEntity() {
		Order order = new Order(orderId, null, null, null);
		return new Payment(id, moment, order);
	}
}
