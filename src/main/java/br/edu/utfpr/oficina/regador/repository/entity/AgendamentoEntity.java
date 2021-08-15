package br.edu.utfpr.oficina.regador.repository.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity(name = "Agendamentos")
public class AgendamentoEntity {

    @Id
    private Long identificador;
    private Date horarioInicial;
    private Date horarioFinal;
    public AgendamentoEntity (Date horarioInicial, Date horarioFinal){
        this.identificador = horarioInicial.getTime();
        this.horarioInicial = horarioInicial;
        this.horarioFinal = horarioFinal;
    }

    public AgendamentoEntity (Long identificador, Date horarioInicial, Date horarioFinal){
        this.identificador = identificador;
        this.horarioInicial = horarioInicial;
        this.horarioFinal = horarioFinal;
    }

}
