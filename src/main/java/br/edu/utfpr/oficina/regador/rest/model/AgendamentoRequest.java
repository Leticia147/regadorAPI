package br.edu.utfpr.oficina.regador.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AgendamentoRequest {
    @JsonProperty(value="dataInicial", required = true)
    private LocalDateTime dataInicial;
    @JsonProperty(value="dataFinal", required = true)
    private LocalDateTime dataFinal;
}