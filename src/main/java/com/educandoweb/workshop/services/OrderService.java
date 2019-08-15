package com.educandoweb.workshop.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.educandoweb.workshop.dto.CartItemDTO;
import com.educandoweb.workshop.dto.OrderDTO;
import com.educandoweb.workshop.dto.OrderItemDTO;
import com.educandoweb.workshop.entities.Order;
import com.educandoweb.workshop.entities.OrderItem;
import com.educandoweb.workshop.entities.Product;
import com.educandoweb.workshop.entities.User;
import com.educandoweb.workshop.entities.enums.OrderStatus;
import com.educandoweb.workshop.repositories.OrderItemRepository;
import com.educandoweb.workshop.repositories.OrderRepository;
import com.educandoweb.workshop.repositories.ProductRepository;
import com.educandoweb.workshop.repositories.UserRepository;
import com.educandoweb.workshop.services.generics.CRUDService;

@Service
public class OrderService implements CRUDService<Order, OrderDTO, Long> {

	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public JpaRepository<Order, Long> getRepository() {
		return repository;
	}
	
	@Transactional
	public OrderDTO placeOrder(List<CartItemDTO> dto) {

		User client = userRepository.getOne(1L); // This will be replaced by the logged in user
		Order order = new Order(null, Instant.now(), OrderStatus.WAITING_PAYMENT, client);
		repository.save(order);

		for (CartItemDTO itemDTO : dto) {
			Product product = productRepository.getOne(itemDTO.getProductId());
			OrderItem item = new OrderItem(order, product, itemDTO.getQuantity(), itemDTO.getPrice());
			order.getItems().add(item);
		}
		orderItemRepository.saveAll(order.getItems());
		
		return order.toDTO();
	}
	
	public List<OrderItemDTO> findItems(Long orderId) {
		Order order = repository.getOne(orderId);
		return order.getItems().stream().map(e -> new OrderItemDTO(e)).collect(Collectors.toList());
	}
}
