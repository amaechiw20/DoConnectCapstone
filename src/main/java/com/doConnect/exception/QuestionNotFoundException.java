/**
 * 
 */
package com.doConnect.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author : Edward Lam
 * @date   : 2023-02-21
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class QuestionNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public QuestionNotFoundException(String message) {
		super(message);
	}
}
