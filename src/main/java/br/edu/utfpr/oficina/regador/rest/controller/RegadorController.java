package br.edu.utfpr.oficina.regador.rest.controller;


import br.edu.utfpr.oficina.regador.rest.model.AgendamentoRequest;
import br.edu.utfpr.oficina.regador.rest.model.AgendamentoResponse;
import br.edu.utfpr.oficina.regador.rest.model.TesteAgendamentos;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/regador", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class RegadorController {

    @GetMapping("/agendamentos")
    public ResponseEntity<TesteAgendamentos> buscarAgendamentos(){
        return ResponseEntity.ok(new TesteAgendamentos());
    }

    @PostMapping(path = "/agendar")
    public ResponseEntity<AgendamentoResponse> buscarAgendamentos(@RequestBody AgendamentoRequest input){
        AgendamentoResponse agendamentoResponse = new AgendamentoResponse();
        agendamentoResponse.setMessage("Teste de integracao da api");
        return ResponseEntity.ok(agendamentoResponse);
    }

}
