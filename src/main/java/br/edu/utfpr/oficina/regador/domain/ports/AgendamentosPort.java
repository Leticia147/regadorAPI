package br.edu.utfpr.oficina.regador.domain.ports;

import br.edu.utfpr.oficina.regador.domain.model.Agendamento;

import java.time.LocalDateTime;
import java.util.List;

public interface AgendamentosPort {

    List<Agendamento> consultarTodosOsAgendamentos();
    Agendamento incluirAgendamento(LocalDateTime horarioInicial, LocalDateTime horarioFinal);
    Agendamento atualizarAgendamento(Agendamento agendamento);
    void removerAgendamento(String identificador);

}