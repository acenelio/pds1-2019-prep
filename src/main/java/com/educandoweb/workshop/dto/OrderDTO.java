package com.educandoweb.workshop.dto;

import java.time.Instant;

import com.educandoweb.workshop.entities.Order;
import com.educandoweb.workshop.entities.User;
import com.educandoweb.workshop.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderDTO implements DTO<Order, Long> {
	private static final long serialVersionUID = 1L;

	private Long id;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone="GMT")
	private Instant moment;
	private OrderStatus orderStatus;
	private Long clientId;
	private String clientName;
	private String clientEmail;
	
	public OrderDTO() {
	}

	public OrderDTO(Order entity) {
		if (entity.getClient() == null) {
			throw new IllegalStateException("Error instantiating OrderDTO: client was null");
		}
		setId(entity.getId());
		setMoment(entity.getMoment());
		setOrderStatus(entity.getOrderStatus());
		setClientId(entity.getClient().getId());
		setClientName(entity.getClient().getName());
		setClientEmail(entity.getClient().getEmail());
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

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	
	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	@Override
	public Order toEntity() {
		User client = new User(clientId, clientName, clientEmail, null, null);
		return new Order(id, moment, orderStatus, client);
	}
}
