package br.edu.utfpr.oficina.regador.domain.service;

import br.edu.utfpr.oficina.regador.domain.exceptions.HorarioInvalidoException;
import br.edu.utfpr.oficina.regador.domain.model.Agendamento;
import br.edu.utfpr.oficina.regador.domain.ports.AgendamentosPort;
import br.edu.utfpr.oficina.regador.domain.ports.BancoPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static br.edu.utfpr.oficina.regador.domain.helper.Helper.*;

@Service
public class AgendamentosService implements AgendamentosPort {

    @Autowired
    private BancoPort bancoAdapter;

    @Override
    public List<Agendamento> consultarTodosOsAgendamentos() {
        return bancoAdapter.consultarTodosOsAgendamentos();
    }

    @Override
    public Agendamento incluirAgendamento(LocalDateTime horarioInicial, LocalDateTime horarioFinal){
        validarHorarios(horarioInicial, horarioFinal);
        return bancoAdapter.incluirAgendamento(horarioInicial, horarioFinal);
    }

    @Override
    public Agendamento atualizarAgendamento(Agendamento agendamento){
        validarHorarios(agendamento.getHorarioInicial(), agendamento.getHorarioFinal());
        return bancoAdapter.atualizarAgendamento(agendamento);
    }

    @Override
    public void removerAgendamento(String identificador) {
        bancoAdapter.removerAgendamento(identificador);
    }

    @Override
    public Agendamento consultarAgendamentoId(String id){
        return bancoAdapter.consultarAgendamentoId(id);
    }

    private void validarHorarios(LocalDateTime horarioInicial, LocalDateTime horarioFinal){
        if (horarioFinal.isBefore(horarioInicial)){
            throw new HorarioInvalidoException("Horario final antes do horario inicial");
        }
        List<Agendamento> agendamentos = bancoAdapter.consultarTodosOsAgendamentos();
        boolean horarioInicialInvalido = verificarHorarioExistenteInicial(horarioInicial,agendamentos);
        boolean horarioFinalInvalido = verificarHorarioExistenteFinal(horarioFinal,agendamentos);
        if(horarioInicialInvalido || horarioFinalInvalido) {
            throw new HorarioInvalidoException(fraseHorarioInvalido(horarioInicialInvalido, horarioFinalInvalido));
        }
    }
}