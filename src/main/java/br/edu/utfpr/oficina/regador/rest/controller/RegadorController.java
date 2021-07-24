package br.edu.utfpr.oficina.regador.rest.controller;

import br.edu.utfpr.oficina.regador.rest.model.AgendamentoRequest;
import br.edu.utfpr.oficina.regador.rest.model.AgendamentoResponse;
import br.edu.utfpr.oficina.regador.rest.model.Response;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(path = "/regador", produces = MediaType.APPLICATION_JSON_VALUE)
public class RegadorController {

    @GetMapping("/teste")
    public ResponseEntity<AgendamentoRequest> teste(){
        AgendamentoRequest agendamentoRequest = new AgendamentoRequest();
        return ResponseEntity.ok(agendamentoRequest);
    }

    @GetMapping("/agendamentos")
    public ResponseEntity<List<AgendamentoResponse>> buscarAgendamentos(){
        List<AgendamentoResponse> agendamentos = new ArrayList<>();
        AgendamentoResponse agendamentoResponse = new AgendamentoResponse(
                UUID.randomUUID().toString(), LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS));
        AgendamentoResponse agendamentoResponse2 = new AgendamentoResponse(
                UUID.randomUUID().toString(), LocalDateTime.now(), LocalDateTime.now().plus(10, ChronoUnit.HOURS));
        AgendamentoResponse agendamentoResponse3 = new AgendamentoResponse(
                UUID.randomUUID().toString(), LocalDateTime.now(), LocalDateTime.now().plus(20, ChronoUnit.HOURS));
        AgendamentoResponse agendamentoResponse4 = new AgendamentoResponse(
                UUID.randomUUID().toString(), LocalDateTime.now(), LocalDateTime.now().plus(30, ChronoUnit.HOURS));
        agendamentos.add(agendamentoResponse);
        agendamentos.add(agendamentoResponse2);
        agendamentos.add(agendamentoResponse3);
        agendamentos.add(agendamentoResponse4);
        return ResponseEntity.ok(agendamentos);
    }

    @PostMapping(path = "/agendar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> incluirAgendamento(
            @RequestBody AgendamentoRequest input
    ){
        Response response = new Response();
        response.setMessage("Teste de integracao da api");
        return ResponseEntity.ok(response);
    }

    @PutMapping(path = "/agendar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> alterarAgendamento(
            @PathVariable("id") String identificador, @RequestBody AgendamentoRequest input
    ){
        Response response = new Response();
        response.setMessage("Teste de integracao da api");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "/agendamentos/{id}")
    public ResponseEntity<Response> deletarAgendamento(
            @PathVariable("id") String identificador
    ){
        Response response = new Response();
        response.setMessage("Teste de integracao da api");
        return ResponseEntity.ok(response);
    }


}
