package com.educandoweb.workshop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.workshop.entities.Order;
import com.educandoweb.workshop.services.CRUDService;
import com.educandoweb.workshop.services.OrderService;

@RestController
@RequestMapping(value="/orders")
public class OrderResource implements CRUDResource<Order, Long> {

	@Autowired
	private OrderService service;

	@Override
	public CRUDService<Order, Long> getService() {
		return service;
	}
}
