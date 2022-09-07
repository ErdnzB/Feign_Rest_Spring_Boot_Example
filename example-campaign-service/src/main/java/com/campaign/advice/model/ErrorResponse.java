package com.campaign.advice.model;

import com.campaign.advice.exception.GeneralException;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.time.Instant;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static com.campaign.advice.constant.ErrorCodes.VALIDATION_ERROR;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    private Long timestamp;
    private int code;
    private String message;
    private Map<String, List<String>> errors;


    public static ErrorResponse of(BindingResult bindingResult) {
        return new ErrorResponse(VALIDATION_ERROR, bindingResult);
    }

    public static ErrorResponse of(GeneralException exception) {
        return new ErrorResponse(exception.getCode(), exception.getMessage());
    }

    public static ErrorResponse of(int code, String message) {
        return new ErrorResponse(code, message);
    }

    private ErrorResponse(int code, String message) {
        this.timestamp = Instant.now().toEpochMilli();
        this.code = code;
        this.message = message;
    }

    private ErrorResponse(int code, BindingResult bindingResult) {
        this.timestamp = Instant.now().toEpochMilli();
        this.code = code;
        this.message = "Validation Error";
        this.errors = bindingResult.getAllErrors().stream().collect(ErrorConsumer::new, ErrorConsumer::accept, ErrorConsumer::combine).getErrors();
    }

    private static class ErrorConsumer implements Consumer<ObjectError> {

        private final Map<String, List<String>> errors = new HashMap<>();

        public Map<String, List<String>> getErrors() {
            return errors;
        }

        @Override
        public void accept(ObjectError objectError) {
            put(getKey(objectError), getValue(objectError));
        }

        public void combine(ErrorConsumer other) {
            other.errors.forEach(this::put);
        }

        private String getKey(ObjectError error) {
            if (error instanceof FieldError) {
                return ((FieldError) error).getField();
            }
            return error.getCode();
        }

        private List<String> getValue(ObjectError error) {
            return Optional.ofNullable(error.getDefaultMessage())
                    .map(this::getValue)
                    .orElseGet(ArrayList::new);
        }

        private List<String> getValue(String message) {
            return Arrays.stream(message.split(","))
                    .collect(Collectors.toList());
        }

        public void put(String key, List<String> value) {
            if (errors.containsKey(key)) {
                errors.get(key).addAll(value);
            } else {
                errors.put(key, value);
            }
        }
    }
}
