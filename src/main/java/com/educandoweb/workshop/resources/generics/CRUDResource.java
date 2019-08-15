package com.educandoweb.workshop.resources.generics;

import com.educandoweb.workshop.dto.DTO;
import com.educandoweb.workshop.entities.DomainEntity;

public interface CRUDResource<E extends DomainEntity<ID, D>, D extends DTO<E, ID>, ID>
	extends CreateResource<E, D, ID>, RetrieveResource<E, D, ID>, UpdateResource<E, D, ID>, DeleteResource<E, D, ID> {
}
