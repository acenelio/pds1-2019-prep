package com.educandoweb.workshop.dto;

import java.time.Instant;

import com.educandoweb.workshop.entities.Order;
import com.educandoweb.workshop.entities.Payment;

public class PaymentDTO implements DTO<Payment, Long> {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Instant moment;
	private PaymentOrder order;
	
	public PaymentDTO() {
	}
	
	public PaymentDTO(Payment entity) {
		setId(entity.getId());
		setMoment(entity.getMoment());
		setOrder(new PaymentOrder(entity.getOrder()));
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

	public PaymentOrder getOrder() {
		return order;
	}

	public void setOrder(PaymentOrder order) {
		this.order = order;
	}

	@Override
	public Payment toEntity() {
		return new Payment(id, moment, order.toOrder());
	}
	
	class PaymentOrder {
		
		private Long id;
		
		public PaymentOrder() {
		}
		
		public PaymentOrder(Order order) {
			setId(order.getId());
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Order toOrder() {
			return new Order(id, null, null, null);
		}
	}
}
