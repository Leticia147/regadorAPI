package br.edu.utfpr.oficina.regador.domain.service;

import br.edu.utfpr.oficina.regador.domain.ports.AcionarPort;
import org.springframework.stereotype.Service;

import static br.edu.utfpr.oficina.regador.domain.mqtt.MqttPublishSample.MqttPublishSample;

@Service

public class AcionarService implements AcionarPort {
    @Override
    public void ligarRegador() {
        MqttPublishSample("H");
    }
    @Override
    public void desligarRegador() {
        MqttPublishSample("L");
    }
}
