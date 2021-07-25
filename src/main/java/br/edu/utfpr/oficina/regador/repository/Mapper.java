package br.edu.utfpr.oficina.regador.repository;

import br.edu.utfpr.oficina.regador.domain.model.Agendamento;
import br.edu.utfpr.oficina.regador.repository.entity.AgendamentoEntity;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public abstract class Mapper {

    public static LocalDateTime convert(Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static Date convert(LocalDateTime date){
        return Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Agendamento map (AgendamentoEntity agendamentoEntity){
        return new Agendamento(
                agendamentoEntity.getIdentificador().toString(),
                convert(agendamentoEntity.getHorarioInicial()),
                convert(agendamentoEntity.getHorarioFinal())
        );
    }

}