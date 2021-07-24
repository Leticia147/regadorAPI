package br.edu.utfpr.oficina.regador.rest.mapper;

import br.edu.utfpr.oficina.regador.domain.model.Agendamento;
import br.edu.utfpr.oficina.regador.rest.model.AgendamentoRequest;
import br.edu.utfpr.oficina.regador.rest.model.AgendamentoResponse;

public abstract class Mapper {

    public static AgendamentoResponse map (Agendamento agendamento){
        return new AgendamentoResponse(
                agendamento.getIdentificador(),
                agendamento.getHorarioInicial(),
                agendamento.getHorarioFinal()
        );
    }

    public static Agendamento map (String identificador, AgendamentoRequest agendamentoRequest){
        return new Agendamento(
                identificador,
                agendamentoRequest.getDataInicial(),
                agendamentoRequest.getDataFinal()
        );
    }
}
