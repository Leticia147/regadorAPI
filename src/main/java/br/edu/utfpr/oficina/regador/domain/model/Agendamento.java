package br.edu.utfpr.oficina.regador.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agendamento {
    private String identificador;
    private LocalDateTime horarioInicial;
    private LocalDateTime horarioFinal;
}