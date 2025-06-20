package com.migramcas.layaed.architecture.finsalud.config.handlers;

import com.migramcas.layaed.architecture.finsalud.service.exception.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class ParserServiceExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<?> invalidLoginExceptionHandler(ServiceException ex) {
        return getExceptionResponse(HttpStatus.valueOf(ex.getStatus()), ex);
    }

    private ResponseEntity<?> getExceptionResponse(HttpStatus status, Throwable ex) {
        return ResponseEntity.status(status)
                .body(Map.of(
                        "timestamp", LocalDateTime.now(),
                        "message", ex.getMessage()
                ));
    }

}