package com.educandoweb.workshop.entities;

import java.io.Serializable;

public interface DomainEntity<ID, D> extends Serializable {

	ID getId();
	
	void setId(ID id);
	
	D toDTO();
}
