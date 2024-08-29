package com.datacenter.recargas.errorhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Interceptor de errores.
 */
@RestControllerAdvice
public class SaveRechargeErrorAdvice {

	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String saveRechargeErrorHandler(RuntimeException ex) {
		return ex.getMessage();
	}
}
