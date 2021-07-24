package br.edu.utfpr.oficina.regador.domain.ports;

import br.edu.utfpr.oficina.regador.domain.model.Agendamento;

import java.time.LocalDateTime;
import java.util.List;

public interface BancoPort {

    List<Agendamento> consultarTodosOsAgendamentos();
    Agendamento incluirAgendamento(LocalDateTime horarioInicial, LocalDateTime horarioFinal);
    void atualizarAgendamento(String identificador, Agendamento agendamento);
    void removerAgendamento(String identificador);

}