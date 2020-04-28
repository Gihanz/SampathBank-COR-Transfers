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

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
@Getter
@Setter
public class SystemException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private final String errorCode;
    private final int status;

    public SystemException(String errorCode, int status, String message) {
        super(message);
        this.errorCode = errorCode;
        this.status = status;
    }

    public SystemException(String errorCode, int status) {
        this.errorCode = errorCode;
        this.status = status;
    }

    public SystemException(String message, Throwable cause, String errorCode, int status) {
        super(message, cause);
        this.errorCode = errorCode;
        this.status = status;
    }

}
