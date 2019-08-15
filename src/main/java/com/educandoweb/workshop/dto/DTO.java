package com.educandoweb.workshop.dto;

import java.io.Serializable;

public interface DTO<E> extends Serializable {

	E toEntity();
}
