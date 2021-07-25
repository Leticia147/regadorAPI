package br.edu.utfpr.oficina.regador.repository.dao;

import br.edu.utfpr.oficina.regador.domain.model.Agendamento;
import br.edu.utfpr.oficina.regador.domain.ports.BancoPort;
import br.edu.utfpr.oficina.regador.repository.RegadorRepository;
import br.edu.utfpr.oficina.regador.repository.entity.AgendamentoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static br.edu.utfpr.oficina.regador.repository.Mapper.convert;
import static br.edu.utfpr.oficina.regador.repository.Mapper.map;

@Service
public class BancoAdapter implements BancoPort {

    @Autowired
    private RegadorRepository repository;

    @Override
    public List<Agendamento> consultarTodosOsAgendamentos() {
        List<Agendamento> agendamentos = new ArrayList<>();
        repository.findAll().forEach(agendamentoEntity -> agendamentos.add(map(agendamentoEntity)));
        return agendamentos;
    }

    @Override
    public Agendamento incluirAgendamento(LocalDateTime horarioInicial, LocalDateTime horarioFinal) {
        AgendamentoEntity agendar = new AgendamentoEntity(
                convert(horarioInicial),
                convert(horarioFinal)
        );
        return map(repository.save(agendar));
    }

    @Override
    public Agendamento atualizarAgendamento(Agendamento agendamento) {
        AgendamentoEntity agendar = new AgendamentoEntity(
                Long.valueOf(agendamento.getIdentificador()),
                convert(agendamento.getHorarioInicial()),
                convert(agendamento.getHorarioFinal())
        );
        return map(repository.save(agendar));
    }

    @Override
    public void removerAgendamento(String identificador) {
        repository.deleteById(Long.valueOf(identificador));
    }
}
