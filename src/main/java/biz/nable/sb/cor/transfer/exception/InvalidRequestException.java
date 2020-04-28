/*
 * ******************************************************************************
 *  * Copyright 2020 (C) N*able
 *  * @author Roshan Wijendra
 *  ******************************************************************************
 */

/**
 * 
 */
package biz.nable.sb.cor.transfer.exception;

import biz.nable.sb.cor.common.utility.ErrorCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
@Getter
@Setter
public class InvalidRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String errorCode;

	public InvalidRequestException(String message) {
		super(message);
		this.errorCode = ErrorCode.UNKNOWN_ERROR;
	}

	public InvalidRequestException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public InvalidRequestException(String message, Throwable cause, String errorCode) {
		super(message, cause);
		this.errorCode = errorCode;
	}

}
