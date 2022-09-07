package com.campaign.advice;

import com.campaign.advice.constant.ErrorCodes;
import com.campaign.advice.exception.GeneralException;
import com.campaign.advice.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice("com.campaign")
public class CampaignAdvice {

    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<ErrorResponse> handleException(GeneralException e) {
        return ResponseEntity.status(e.getStatus()).body(ErrorResponse.of(e));
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        log.error("Unknown Error Occurred !");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponse.of(ErrorCodes.UNKNOWN_ERROR, e.getMessage()));
    }
}
