package br.edu.utfpr.oficina.regador.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class AgendamentoResponse {
    @JsonProperty(value="id", required = true)
    private String identificador;
    @JsonProperty(value="dataInicial", required = true)
    private LocalDateTime dataInicial;
    @JsonProperty(value="dataFinal", required = true)
    private LocalDateTime dataFinal;
}