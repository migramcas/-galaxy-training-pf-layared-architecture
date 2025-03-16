package com.migramcas.layaed.architecture.finsalud.controller.base;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class RestController {

    private static String SUCCESS_OPERATION = "La operación se ha realizado con éxito";

    protected ResponseEntity<CustomResponse> internalServerError(String message) {
        CustomResponse response = CustomResponse.builder()
                .message(message)
                .httpCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    protected ResponseEntity<CustomResponse> notFoundError(String message) {
        CustomResponse response = CustomResponse.builder()
                .message(message)
                .httpCode(HttpStatus.NOT_FOUND.value())
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


    protected ResponseEntity<CustomResponse> success(String message) {
        return success(message, null);
    }

    protected ResponseEntity<CustomResponse> success(Object payload) {
        return success(SUCCESS_OPERATION, payload);
    }

    private ResponseEntity<CustomResponse> success(String message, Object payload) {
        HttpStatus statusCode = Objects.isNull(payload) ? HttpStatus.NO_CONTENT : HttpStatus.OK;

        CustomResponse response = CustomResponse.builder()
                .message(message)
                .httpCode(statusCode.value())
                .timestamp(LocalDateTime.now())
                .payload(payload)
                .build();

        return new ResponseEntity<>(response, statusCode);
    }

}
