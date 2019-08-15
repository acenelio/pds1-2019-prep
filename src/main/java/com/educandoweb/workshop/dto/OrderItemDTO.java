package com.educandoweb.workshop.dto;

import java.io.Serializable;

import com.educandoweb.workshop.entities.OrderItem;
import com.educandoweb.workshop.entities.Product;

public class OrderItemDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer quantity;
	private Double price;
	private Long productId;
	private String name;
	private String imgUrl;
	
	public OrderItemDTO() {
	}
	
	public OrderItemDTO(OrderItem entity) {
		if (entity.getProduct() == null) {
			throw new IllegalStateException("Error instantiating OrderItemDTO: product was null");
		}
		setQuantity(entity.getQuantity());
		setPrice(entity.getPrice());
		setProductId(entity.getProduct().getId());
		setName(entity.getProduct().getName());
		setImgUrl(entity.getProduct().getImgUrl());
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

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public OrderItem toOrderItem() {
		Product product = new Product(productId, null, null, null, null);
		return new OrderItem(null, product, quantity, price);
	}
}
