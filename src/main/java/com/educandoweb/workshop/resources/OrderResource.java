package com.educandoweb.workshop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.workshop.dto.OrderDTO;
import com.educandoweb.workshop.entities.Order;
import com.educandoweb.workshop.resources.generics.CreateResource;
import com.educandoweb.workshop.resources.generics.RetrieveResource;
import com.educandoweb.workshop.services.generics.CRUDService;

@RestController
@RequestMapping(value="/orders")
public class OrderResource implements CreateResource<Order, OrderDTO, Long>, RetrieveResource<Order, OrderDTO, Long> {

	@Autowired
	private CRUDService<Order, OrderDTO, Long> service;
	
	@Override
	public CRUDService<Order, OrderDTO, Long> getService() {
		return service;
	}
}
