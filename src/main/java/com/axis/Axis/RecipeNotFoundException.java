package com.axis.Axis;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * 
 * @author Joaki
 * NotFoundException class to return HTTP 404 instead of 500
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecipeNotFoundException extends RuntimeException {

	public RecipeNotFoundException(String exception) {
		super(exception);
	}

}