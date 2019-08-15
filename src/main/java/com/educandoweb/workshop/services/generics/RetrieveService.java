package com.educandoweb.workshop.services.generics;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.educandoweb.workshop.dto.DTO;
import com.educandoweb.workshop.entities.DomainEntity;

@Service
public interface RetrieveService<E extends DomainEntity<ID, D>, D extends DTO<E>, ID> {

	JpaRepository<E, ID> getRepository();
	
	default List<D> findAll() {
		List<E> list = getRepository().findAll();
		return list.stream().map(e -> e.toDTO()).collect(Collectors.toList());
	}
	
	default D findById(ID id) {
		Optional<E> result = getRepository().findById(id);
		return result.get().toDTO();
	}
}
