package com.educandoweb.workshop.dto;

import java.time.Instant;

import com.educandoweb.workshop.entities.Order;
import com.educandoweb.workshop.entities.Payment;

public class PaymentDTO implements DTO<Payment> {
	private static final long serialVersionUID = 1L;

	private Instant moment;
	private PaymentOrder order;
	
	public PaymentDTO() {
	}
	
	public PaymentDTO(Payment entity) {
		moment = entity.getMoment();
	}
	
	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public PaymentOrder getOrder() {
		return order;
	}

	public void setOrder(PaymentOrder order) {
		this.order = order;
	}

	@Override
	public Payment toEntity() {
		return new Payment(null, moment, order.toOrder());
	}
	
	class PaymentOrder {
		public Long id;
		
		public PaymentOrder(Order order) {
			id = order.getId();
		}
		
		public Order toOrder() {
			return new Order(id, null, null, null);
		}
	}
}
