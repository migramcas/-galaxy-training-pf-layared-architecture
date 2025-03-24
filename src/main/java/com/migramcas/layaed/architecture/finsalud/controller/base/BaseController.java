package com.migramcas.layaed.architecture.finsalud.controller.base;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class BaseController {

    private static final String SUCCESS_OPERATION_MESSAGE = "La operación se ha realizado con éxito";

    protected ResponseEntity<CustomResponse<Object>> internalServerError(String message) {
        CustomResponse<Object> response = CustomResponse.builder()
                .message(message)
                .httpCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .timestamp(LocalDateTime.now())
                .payload(new Object())
                .build();

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    protected ResponseEntity<CustomResponse<Object>> notFoundError(String message) {
        CustomResponse<Object> response = CustomResponse.<Object>builder()
                .message(message)
                .httpCode(HttpStatus.NOT_FOUND.value())
                .timestamp(LocalDateTime.now())
                .payload(new Object())
                .build();

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    protected <T> ResponseEntity<CustomResponse<T>> success(T payload) {
        return success(SUCCESS_OPERATION_MESSAGE, payload);
    }

    protected <T> ResponseEntity<CustomResponse<T>> success(String message, T payload) {
        HttpStatus statusCode = Objects.isNull(payload) ? HttpStatus.NO_CONTENT : HttpStatus.OK;

        CustomResponse<T> response = CustomResponse.<T>builder()
                .message(message)
                .httpCode(statusCode.value())
                .timestamp(LocalDateTime.now())
                .payload(payload)
                .build();

        return new ResponseEntity<>(response, statusCode);
    }
}
