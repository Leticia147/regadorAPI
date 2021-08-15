package br.edu.utfpr.oficina.regador.domain.exceptions;

public class HorarioInvalidoException extends RuntimeException {
    public HorarioInvalidoException (String message){
        super(message);
    }
}
