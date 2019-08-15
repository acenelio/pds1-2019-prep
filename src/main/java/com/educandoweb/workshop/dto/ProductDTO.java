package com.educandoweb.workshop.dto;

import com.educandoweb.workshop.entities.Product;

public class ProductDTO implements DTO<Product> {
	private static final long serialVersionUID = 1L;

	private String name;
	private String description;
	private Double price;
	private String imgUrl;

	public ProductDTO() {
	}

	public ProductDTO(Product entity) {
		name = entity.getName();
		description = entity.getDescription();
		price = entity.getPrice();
		imgUrl = entity.getImgUrl();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Override
	public Product toEntity() {
		return new Product(null, name, description, price, imgUrl);
	}
}
