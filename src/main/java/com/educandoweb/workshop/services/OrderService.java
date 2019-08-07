package com.educandoweb.workshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.educandoweb.workshop.entities.Order;
import com.educandoweb.workshop.repositories.OrderRepository;

@Service
public class OrderService implements CRUDService<Order, Long> {

	@Autowired
	private OrderRepository repository;

	@Override
	public JpaRepository<Order, Long> getRepository() {
		return repository;
	}

	@Override
	public void updateData(Order newObj, Order obj) {
		newObj.setOrderStatus(obj.getOrderStatus());
	}
}
