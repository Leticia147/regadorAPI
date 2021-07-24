package br.edu.utfpr.oficina.regador.repository.dao;

import br.edu.utfpr.oficina.regador.domain.model.Agendamento;
import br.edu.utfpr.oficina.regador.domain.ports.BancoPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BancoAdapter implements BancoPort {

    @Override
    public List<Agendamento> consultarTodosOsAgendamentos() {
        return null;
    }

    @Override
    public Agendamento incluirAgendamento(LocalDateTime horarioInicial, LocalDateTime horarioFinal) {
        return null;
    }

    @Override
    public void atualizarAgendamento(String identificador, Agendamento agendamento) {

    }

    @Override
    public void removerAgendamento(String identificador) {

    }

}
