package br.edu.utfpr.oficina.regador.domain.helper;

import br.edu.utfpr.oficina.regador.domain.model.Agendamento;

import java.time.LocalDateTime;
import java.util.List;

public abstract class Helper {
    public static boolean verificarHorarioExistenteInicial (LocalDateTime horario, List<Agendamento> agendamentos){
        return agendamentos.stream().anyMatch(agendamento -> horario.isEqual(agendamento.getHorarioInicial()) || (horario.isAfter(agendamento.getHorarioInicial()) && horario.isBefore( agendamento.getHorarioFinal())));
    }

    public static boolean verificarHorarioExistenteFinal (LocalDateTime horario, List<Agendamento> agendamentos){
        return agendamentos.stream().anyMatch(agendamento -> horario.isEqual(agendamento.getHorarioFinal()) || (horario.isAfter(agendamento.getHorarioInicial()) && horario.isBefore( agendamento.getHorarioFinal())));
    }

    public static String fraseHorarioInvalido(boolean horarioInicialInvalido, boolean horarioFinalInvalido ){
        if(horarioInicialInvalido && horarioFinalInvalido){
            return "Os horários não estão disponíveis.";
        }
        if(horarioInicialInvalido){
            return "O horário inicial não está disponível.";
        }
        else{
            return "O horário final não está disponível.";
        }
    }
}
