package br.edu.utfpr.oficina.regador.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgendamentoResponse {
    @JsonProperty(value="message")
    private String message;

}