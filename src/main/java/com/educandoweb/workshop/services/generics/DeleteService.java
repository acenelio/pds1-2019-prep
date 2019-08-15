package com.educandoweb.workshop.services.generics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.educandoweb.workshop.dto.DTO;
import com.educandoweb.workshop.entities.DomainEntity;

@Service
public interface DeleteService<E extends DomainEntity<ID, D>, D extends DTO<E>, ID> {

	JpaRepository<E, ID> getRepository();
	
	default void delete(ID id) {
		getRepository().deleteById(id);
	}
}
