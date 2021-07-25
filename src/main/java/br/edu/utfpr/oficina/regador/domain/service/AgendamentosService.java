package br.edu.utfpr.oficina.regador.domain.service;

import br.edu.utfpr.oficina.regador.domain.model.Agendamento;
import br.edu.utfpr.oficina.regador.domain.ports.AgendamentosPort;
import br.edu.utfpr.oficina.regador.domain.ports.BancoPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendamentosService implements AgendamentosPort {

    @Autowired
    private BancoPort bancoAdapter;

    @Override
    public List<Agendamento> consultarTodosOsAgendamentos() {
        return bancoAdapter.consultarTodosOsAgendamentos();
    }

    @Override
    public Agendamento incluirAgendamento(LocalDateTime horarioInicial, LocalDateTime horarioFinal) {
        //consultar tudo, er se ja tem algo agendado no horario
        return bancoAdapter.incluirAgendamento(horarioInicial, horarioFinal);
    }

    @Override
    public Agendamento atualizarAgendamento(Agendamento agendamento) {
        return agendamento;
    }

    @Override
    public void removerAgendamento(String identificador) {

    }

}