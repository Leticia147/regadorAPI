package br.edu.utfpr.oficina.regador.rest.controller;

import br.edu.utfpr.oficina.regador.domain.exceptions.HorarioInvalidoException;
import br.edu.utfpr.oficina.regador.domain.exceptions.ItemNaoExistenteException;
import br.edu.utfpr.oficina.regador.rest.model.ApiError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class RegadorExceptionHandler {

    @ExceptionHandler({Exception.class})
    public final ResponseEntity<ApiError> handleException(Exception ex) {
        return ResponseEntity.status(SERVICE_UNAVAILABLE).body(new ApiError(ex.getMessage()));
    }

    @ExceptionHandler({HorarioInvalidoException.class})
    public final ResponseEntity<ApiError> handleException(HorarioInvalidoException ex) {
        return ResponseEntity.status(UNPROCESSABLE_ENTITY).body(new ApiError(ex.getMessage()));
    }

    @ExceptionHandler({ItemNaoExistenteException.class})
    public final ResponseEntity<ApiError> handleException(ItemNaoExistenteException ex) {
        return ResponseEntity.status(NOT_FOUND).body(new ApiError(ex.getMessage()));
    }

}