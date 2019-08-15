package com.educandoweb.workshop.services.generics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.educandoweb.workshop.dto.DTO;
import com.educandoweb.workshop.entities.DomainEntity;

@Service
public interface CreateService<E extends DomainEntity<ID, D>, D extends DTO<E>, ID> {

	JpaRepository<E, ID> getRepository();
	
	default ID insert(D dto) {
		E entity = dto.toEntity();
		entity = getRepository().save(entity);
		return entity.getId();
	}
}
