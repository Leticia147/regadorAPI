package br.edu.utfpr.oficina.regador.domain.exceptions;

public class ItemNaoExistenteException extends RuntimeException{
    public ItemNaoExistenteException (String message){
        super(message);
    }
}
