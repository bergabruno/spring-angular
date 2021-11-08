package br.com.ibm.udemy.model.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.ibm.udemy.model.entity.Servico;

public interface ServicoRepository extends CrudRepository<Servico, Integer>{

}
