package org.formacio.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason="ID no encontrada en la BBDD")
public class OperacionesDeExcepcion extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
