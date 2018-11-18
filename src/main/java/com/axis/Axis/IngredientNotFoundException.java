package com.axis.Axis;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * 
 * @author Joaki
 * NotFoundException class to return HTTP 404 instead of 500
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class IngredientNotFoundException extends RuntimeException {

	public IngredientNotFoundException(String exception) {
		super(exception);
	}

}