package br.edu.utfpr.oficina.regador.repository;

import br.edu.utfpr.oficina.regador.repository.entity.AgendamentoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegadorRepository extends CrudRepository<AgendamentoEntity, Long> {

}