package br.edu.utfpr.oficina.regador.scheduler;

import br.edu.utfpr.oficina.regador.domain.model.Agendamento;
import br.edu.utfpr.oficina.regador.domain.ports.AcionarPort;
import br.edu.utfpr.oficina.regador.domain.ports.AgendamentosPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class ScheduledTasks {
    
    @Autowired
    private AgendamentosPort agendamentosService;

    @Autowired
    private AcionarPort acionarPort;

    @Scheduled(cron = "0 * * ? * *")
    public void reportCurrentTime() {
        String horarioAtual = formatarData(LocalDateTime.now());

        List<Agendamento> agendamentos = agendamentosService.consultarTodosOsAgendamentos();
    
        for(Agendamento agendamento : agendamentos){
            if(horarioAtual.equals(formatarData(agendamento.getHorarioFinal()))){
                acionarPort.desligarRegador();
                agendamentosService.removerAgendamento(agendamento.getIdentificador());
            }
            if(horarioAtual.equals(formatarData(agendamento.getHorarioInicial()))){
                acionarPort.ligarRegador();
            }
        }
    }

    private static String formatarData(LocalDateTime date){
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
    }

}
