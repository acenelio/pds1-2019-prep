package com.educandoweb.workshop.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.educandoweb.workshop.entities.Order;
import com.educandoweb.workshop.entities.OrderItem;
import com.educandoweb.workshop.entities.User;
import com.educandoweb.workshop.entities.enums.OrderStatus;

public class OrderDTO implements DTO<Order> {
	private static final long serialVersionUID = 1L;

	private Instant moment;
	private OrderStatus orderStatus;
	private Client client;
	private List<OrderItemDTO> items = new ArrayList<>();
	
	public OrderDTO() {
	}

	public OrderDTO(Order entity) {
		moment = entity.getMoment();
		orderStatus = entity.getOrderStatus();
		client = new Client(entity.getClient());
		for (OrderItem item : entity.getItems()) {
			items.add(new OrderItemDTO(item));
		}
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItemDTO> getItems() {
		return items;
	}

	@Override
	public Order toEntity() {
		Order order = new Order(null, moment, orderStatus, client.toUser());
		for (OrderItemDTO item : this.getItems()) {
			order.getItems().add(item.toOrderItem());
		}
		return order;
	}

	class Client {
		public Long id;
		public String name;
		public String email;
		
		public Client(User user) {
			id = user.getId();
			name = user.getName();
			email = user.getEmail();
		}
		
		public User toUser() {
			return new User(id, name, email, null, null);
		}
	}
	
	class OrderItemDTO {
		public Integer quantity;
		
		public OrderItemDTO(OrderItem item) {
			quantity = item.getQuantity();
		}
		
		public OrderItem toOrderItem() {
			return new OrderItem(null, null, quantity, null);
		}
	}
}
