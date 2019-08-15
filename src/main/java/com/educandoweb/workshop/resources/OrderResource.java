package com.educandoweb.workshop.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.workshop.dto.CartItemDTO;
import com.educandoweb.workshop.dto.OrderDTO;
import com.educandoweb.workshop.dto.OrderItemDTO;
import com.educandoweb.workshop.entities.Order;
import com.educandoweb.workshop.resources.generics.RetrieveResource;
import com.educandoweb.workshop.resources.generics.UpdateResource;
import com.educandoweb.workshop.services.OrderService;
import com.educandoweb.workshop.services.generics.CRUDService;

@RestController
@RequestMapping(value="/orders")
public class OrderResource implements RetrieveResource<Order, OrderDTO, Long>, UpdateResource<Order, OrderDTO, Long> {

	@Autowired
	private OrderService service;
	
	@Override
	public CRUDService<Order, OrderDTO, Long> getService() {
		return service;
	}
	
	@PostMapping
	public ResponseEntity<OrderDTO> placeOrder(@RequestBody List<CartItemDTO> cartDTO) {
		OrderDTO orderDTO = service.placeOrder(cartDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(orderDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(orderDTO);
	}
	
	@GetMapping(value = "/{orderId}/items")
	public ResponseEntity<List<OrderItemDTO>> findItems(@PathVariable Long orderId) {
		List<OrderItemDTO> list = service.findItems(orderId);
		return ResponseEntity.ok().body(list);
	}
}
