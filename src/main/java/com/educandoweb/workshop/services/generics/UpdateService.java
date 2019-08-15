package com.educandoweb.workshop.services.generics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.educandoweb.workshop.dto.DTO;
import com.educandoweb.workshop.entities.DomainEntity;

@Service
public interface UpdateService<E extends DomainEntity<ID, D>, D extends DTO<E>, ID> {

	JpaRepository<E, ID> getRepository();
	
	default D update(ID id, D dto) {
		E entity = getRepository().findById(id).get();
		entity.updateDataFromDTO(dto);
		entity = getRepository().save(entity);
		return entity.toDTO();
	}
}
