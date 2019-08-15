package com.educandoweb.workshop.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.educandoweb.workshop.entities.Order;
import com.educandoweb.workshop.entities.OrderItem;
import com.educandoweb.workshop.entities.Product;
import com.educandoweb.workshop.entities.User;
import com.educandoweb.workshop.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderDTO implements DTO<Order, Long> {
	private static final long serialVersionUID = 1L;

	private Long id;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone="GMT")
	private Instant moment;
	private OrderStatus orderStatus;
	private Client client;
	private List<OrderItemDTO> items = new ArrayList<>();
	
	public OrderDTO() {
	}

	public OrderDTO(Order entity) {
		setId(entity.getId());
		setMoment(entity.getMoment());
		setOrderStatus(entity.getOrderStatus());
		setClient(new Client(entity.getClient()));
		for (OrderItem item : entity.getItems()) {
			items.add(new OrderItemDTO(item));
		}
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
		Order order = new Order(id, moment, orderStatus, client.toUser());
		for (OrderItemDTO item : this.getItems()) {
			order.getItems().add(item.toOrderItem());
		}
		return order;
	}

	class Client {
		private Long id;
		private String name;
		private String email;
		
		public Client() {
		}
		
		public Client(User user) {
			if (user == null) {
				throw new IllegalStateException("Error instantiating OrderDTO: client was null");
			}
			setId(user.getId());
			setName(user.getName());
			setEmail(user.getEmail());
		}
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public User toUser() {
			return new User(id, name, email, null, null);
		}
	}
	
	class OrderItemDTO {
		private Integer quantity;
		private Double price;
		private OrderItemProduct product;
		
		public OrderItemDTO() {
		}
		
		public OrderItemDTO(OrderItem item) {
			if (item == null) {
				throw new IllegalStateException("Error instantiating OrderDTO: orderItem was null");
			}
			if (item.getProduct() == null) {
				throw new IllegalStateException("Error instantiating OrderDTO: product was null");
			}
			setQuantity(item.getQuantity());
			setPrice(item.getPrice());
			setProduct(new OrderItemProduct(item.getProduct()));
		}
		
		public Integer getQuantity() {
			return quantity;
		}

		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public OrderItemProduct getProduct() {
			return product;
		}

		public void setProduct(OrderItemProduct product) {
			this.product = product;
		}

		public OrderItem toOrderItem() {
			return new OrderItem(null, product.toProduct(), quantity, null);
		}
		
		class OrderItemProduct {
			private Long id;
			private String name;
			
			public OrderItemProduct() {
			}
			
			public OrderItemProduct(Product product) {
				setId(product.getId());
				setName(product.getName());
			}

			public Long getId() {
				return id;
			}

			public void setId(Long id) {
				this.id = id;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public Product toProduct() {
				return new Product(id, name, null, null, null);
			}
		}
	}
}
