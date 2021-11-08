package br.com.ibm.udemy.model.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.ibm.udemy.model.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer>{

}
