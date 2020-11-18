package com.rest.api.interview.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "constraints violada ...")
public class InsufficientLimitException extends Exception {


	/**
	 *
	 */
	private static final long serialVersionUID = -6894031935291630360L;

	public InsufficientLimitException(String message) {
		super(message);
	}

}