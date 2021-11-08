package br.com.ibm.udemy.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.ibm.udemy.model.entity.Cliente;
import br.com.ibm.udemy.model.repository.ClienteRepository;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

  @Autowired
  private ClienteRepository repository;
  private String nome = "Bruno";

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Cliente salvar(@RequestBody @Valid Cliente cliente) {
    return repository.save(cliente);
  }

  @GetMapping("/{id}")
  public Cliente procurarPorId(@PathVariable Integer id) {
    return repository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao encontrado"));
  }

  @DeleteMapping("/{id}")
  public void deletar(@PathVariable Integer id) {
    repository.findById(id).map( cliente -> {
      repository.delete(cliente);
      return Void.TYPE;
    }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao encontrado"));
  }

  @PutMapping("{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void atualizar(@PathVariable Integer id,@Valid @RequestBody Cliente clienteNovo) {
    repository.findById(id).map(cliente -> {
      cliente.setNome(clienteNovo.getNome());
      cliente.setCpf(clienteNovo.getCpf());
      return repository.save(cliente);
    }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente nao encontrado" ));

  }

}
