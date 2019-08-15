package com.educandoweb.workshop.services.generics;

import org.springframework.stereotype.Service;

import com.educandoweb.workshop.dto.DTO;
import com.educandoweb.workshop.entities.DomainEntity;

@Service
public interface CRUDService<E extends DomainEntity<ID, D>, D extends DTO<E>, ID>
		extends CreateService<E, D, ID>, DeleteService<E, D, ID>, RetrieveService<E, D, ID>, UpdateService<E, D, ID> {
}
