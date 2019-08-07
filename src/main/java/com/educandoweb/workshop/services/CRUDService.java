package com.educandoweb.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.educandoweb.workshop.entities.DomainEntity;

@Service
public interface CRUDService<E extends DomainEntity<ID>, ID> {

	JpaRepository<E, ID> getRepository();
	
	default List<E> findAll() {
		return getRepository().findAll();
	}
	
	default E findById(ID id) {
		Optional<E> result = getRepository().findById(id);
		return result.get();
	}
	
	default E insert(E obj) {
		obj.setId(null);
		return getRepository().save(obj);
	}
	
	default E update(ID id, E obj) {
		E newObj = findById(id);
		updateData(newObj, obj);
		return getRepository().save(newObj);
	}
	
	default void delete(ID id) {
		getRepository().deleteById(id);
	}
	
	void updateData(E newObj, E obj);
}
