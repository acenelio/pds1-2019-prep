package com.educandoweb.workshop.entities;

import java.io.Serializable;

public interface DomainEntity<ID> extends Serializable {

	ID getId();
	
	void setId(ID id);
}
