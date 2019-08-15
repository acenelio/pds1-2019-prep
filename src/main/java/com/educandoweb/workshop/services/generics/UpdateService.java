package com.educandoweb.workshop.services.generics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.educandoweb.workshop.dto.DTO;
import com.educandoweb.workshop.entities.DomainEntity;

@Service
public interface UpdateService<E extends DomainEntity<ID, D>, D extends DTO<E>, ID> {

	JpaRepository<E, ID> getRepository();
	
	void updateData(E entity, D dto);
	
	default D update(ID id, D dto) {
		E entity = getRepository().findById(id).get();
		updateData(entity, dto);
		entity = getRepository().save(entity);
		return entity.toDTO();
	}
}
