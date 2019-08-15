package com.educandoweb.workshop.dto;

import java.io.Serializable;

public interface DTO<E, ID> extends Serializable {

	ID getId();
	
	E toEntity();
}
