package com.educandoweb.workshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.educandoweb.workshop.dto.OrderDTO;
import com.educandoweb.workshop.entities.Order;
import com.educandoweb.workshop.repositories.OrderRepository;
import com.educandoweb.workshop.services.generics.CRUDService;

@Service
public class OrderService implements CRUDService<Order, OrderDTO, Long> {

	@Autowired
	private OrderRepository repository;
	
	@Override
	public JpaRepository<Order, Long> getRepository() {
		return repository;
	}
}
