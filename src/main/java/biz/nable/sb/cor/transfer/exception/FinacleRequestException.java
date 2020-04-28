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

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
@Getter
@Setter
public class FinacleRequestException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private final String errorCode;
    private final int status;

    public FinacleRequestException(String errorCode, int status, String message) {
        super(message);
        this.errorCode = errorCode;
        this.status = status;
    }

    public FinacleRequestException(String errorCode, int status) {
        this.errorCode = errorCode;
        this.status = status;
    }

    public FinacleRequestException(String message, Throwable cause, String errorCode, int status) {
        super(message, cause);
        this.errorCode = errorCode;
        this.status = status;
    }

}
