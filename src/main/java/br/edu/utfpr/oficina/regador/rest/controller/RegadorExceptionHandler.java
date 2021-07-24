package br.edu.utfpr.oficina.regador.rest.controller;

import br.edu.utfpr.oficina.regador.rest.model.ApiError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.SERVICE_UNAVAILABLE;

@ControllerAdvice
public class RegadorExceptionHandler {

    @ExceptionHandler({Exception.class})
    public final ResponseEntity<ApiError> handleException(Exception ex) {
        return ResponseEntity.status(SERVICE_UNAVAILABLE).body(new ApiError(ex.getMessage()));
    }

}