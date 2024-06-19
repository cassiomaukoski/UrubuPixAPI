package br.com.maukoski.cassio.urubupix.controller;

import br.com.maukoski.cassio.urubupix.model.Cliente;
import br.com.maukoski.cassio.urubupix.model.Error;
import br.com.maukoski.cassio.urubupix.model.Sucess;
import br.com.maukoski.cassio.urubupix.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class  ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> localizar(@PathVariable int id){
        if(clienteService.localizar(id) == null){
            return ResponseEntity.badRequest().body(new Error("cliente", "não encontrado"));
        }
        return ResponseEntity.ok(clienteService.localizar(id));
    }

    @GetMapping()
    public ResponseEntity<Object> pesquisar(){
        if(clienteService.pesquisar().isEmpty()){
            return ResponseEntity.badRequest().body(new Sucess("sem registros!"));
        }
        return ResponseEntity.ok(clienteService.pesquisar());
    }

    @PostMapping()
    public ResponseEntity<Object> salvar(@RequestBody Cliente cliente){
        List<Error> errors = new ArrayList<>();

        if(cliente.getNome().equals("") || cliente.getNome() == null){
            errors.add(new Error("nome", "vazio"));
        }
        if(cliente.getCpf().equals("") || cliente.getCpf() == null){
            errors.add(new Error("cpf", "vazio"));
        }else if(cliente.getCpf().length()!=11||cliente.getCpf().matches("(\\d)\\1{10}")){
            errors.add(new Error("cpf", "inválido"));
        }

        if(!errors.isEmpty()){
            return ResponseEntity.badRequest().body(errors);
        }


        return ResponseEntity.ok(clienteService.salvar(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable int id){
        if(clienteService.localizar(id) == null){
            return ResponseEntity.badRequest().body(new Error("cliente", "não encontrado"));
        }
        clienteService.excluir(id);
        return ResponseEntity.ok(new Sucess("cliente excluído"));

    }
}

