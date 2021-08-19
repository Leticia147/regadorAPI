package br.edu.utfpr.oficina.regador.rest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dataInicial;
    @JsonProperty(value="dataFinal", required = true)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dataFinal;

}