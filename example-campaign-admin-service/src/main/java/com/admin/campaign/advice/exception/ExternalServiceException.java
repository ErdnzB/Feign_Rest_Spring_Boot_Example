package com.admin.campaign.advice.exception;

import org.springframework.http.HttpStatus;

public class ExternalServiceException extends GeneralException {

    public ExternalServiceException(String message, int code) {
        super(HttpStatus.FAILED_DEPENDENCY, code, message);
    }
}
