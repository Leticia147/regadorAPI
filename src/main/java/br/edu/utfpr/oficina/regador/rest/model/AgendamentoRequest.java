package br.edu.utfpr.oficina.regador.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AgendamentoRequest {
    @JsonProperty(value="data", required = true)
    private LocalDate data;
    @JsonProperty(value="duracao", required = true)
    private Integer duracao;
}
