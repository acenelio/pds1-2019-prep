package com.educandoweb.workshop.services.generics;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.educandoweb.workshop.dto.DTO;
import com.educandoweb.workshop.entities.DomainEntity;

@Service
public interface CRUDService<E extends DomainEntity<ID, D>, D extends DTO<E, ID>, ID> {
	
	JpaRepository<E, ID> getRepository();
	
	default D insert(D dto) {
		E entity = dto.toEntity();
		entity = getRepository().save(entity);
		return entity.toDTO();
	}
	
	default List<D> findAll() {
		List<E> list = getRepository().findAll();
		return list.stream().map(e -> e.toDTO()).collect(Collectors.toList());
	}
	
	default D findById(ID id) {
		Optional<E> result = getRepository().findById(id);
		E entity = result.orElseThrow(() -> new EntityNotFoundException("Entity not found. Id " + id));
		return entity.toDTO();
	}
	
	default D update(ID id, D dto) {
		E entity = getRepository().getOne(id);
		entity.updateDataFromDTO(dto);
		entity = getRepository().save(entity);
		return entity.toDTO();
	}
	
	default void delete(ID id) {
		getRepository().deleteById(id);
	}
}
