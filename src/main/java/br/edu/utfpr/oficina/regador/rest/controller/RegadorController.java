package br.edu.utfpr.oficina.regador.rest.controller;

import br.edu.utfpr.oficina.regador.domain.exceptions.HorarioInvalidoException;
import br.edu.utfpr.oficina.regador.domain.ports.AgendamentosPort;
import br.edu.utfpr.oficina.regador.rest.mapper.Mapper;
import br.edu.utfpr.oficina.regador.rest.model.AgendamentoRequest;
import br.edu.utfpr.oficina.regador.rest.model.AgendamentoResponse;
import br.edu.utfpr.oficina.regador.rest.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static br.edu.utfpr.oficina.regador.rest.mapper.Mapper.map;

@Controller
@RequestMapping(path = "/regador", produces = MediaType.APPLICATION_JSON_VALUE)
public class RegadorController {

    @Autowired
    private AgendamentosPort agendamentosService;

    @GetMapping("/teste")
    public ResponseEntity<AgendamentoRequest> teste(){
        AgendamentoRequest agendamentoRequest = new AgendamentoRequest();
        return ResponseEntity.ok(agendamentoRequest);
    }

    @GetMapping("/agendamentos")
    public ResponseEntity<List<AgendamentoResponse>> buscarAgendamentos() {
        return ResponseEntity.ok(
                agendamentosService.consultarTodosOsAgendamentos()
                        .stream()
                        .map(Mapper::map)
                        .collect(Collectors.toList())
        );
    }

    @PostMapping(path = "/agendar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AgendamentoResponse> incluirAgendamento(
            @RequestBody AgendamentoRequest input
    ) throws HorarioInvalidoException {
        return ResponseEntity.ok(
                map(agendamentosService.incluirAgendamento(input.getDataInicial(), input.getDataFinal()))
        );
    }

    @PutMapping(path = "/agendar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AgendamentoResponse> alterarAgendamento(
            @PathVariable("id") String identificador, @RequestBody AgendamentoRequest input
    ) throws HorarioInvalidoException {
        return ResponseEntity.ok(
                map(agendamentosService.atualizarAgendamento(map(identificador, input)))
        );
    }

    @DeleteMapping(path = "/agendamentos/{id}")
    public ResponseEntity<Response> deletarAgendamento(
            @PathVariable("id") String identificador
    ){
        agendamentosService.removerAgendamento(identificador);
        return ResponseEntity.ok(new Response ("Removido com sucesso"));
    }

}
