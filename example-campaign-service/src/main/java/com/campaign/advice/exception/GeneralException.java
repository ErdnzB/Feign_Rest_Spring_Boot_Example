package com.campaign.advice.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GeneralException extends RuntimeException {

    private final int code;
    private final HttpStatus status;

    public GeneralException(int code, String message) {
        this(HttpStatus.BAD_REQUEST, code, message);
    }

    public GeneralException(HttpStatus status, int code, String message) {
        super(message);
        this.code = code;
        this.status = status;
    }
}
