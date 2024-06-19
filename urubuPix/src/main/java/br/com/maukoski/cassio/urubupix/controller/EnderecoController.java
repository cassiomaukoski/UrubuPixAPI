package br.com.maukoski.cassio.urubupix.controller;

import br.com.maukoski.cassio.urubupix.model.Compra;
import br.com.maukoski.cassio.urubupix.model.Endereco;
import br.com.maukoski.cassio.urubupix.model.Error;
import br.com.maukoski.cassio.urubupix.model.Sucess;
import br.com.maukoski.cassio.urubupix.service.ClienteService;
import br.com.maukoski.cassio.urubupix.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    EnderecoService enderecoService;
    @Autowired
    ClienteService clienteService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> localizar(@PathVariable int id){
        if(enderecoService.localizar(id) == null){
            return ResponseEntity.badRequest().body(new Error("endereco", "não encontrado"));
        }
        return ResponseEntity.ok(enderecoService.localizar(id));
    }

    @GetMapping()
    public ResponseEntity<Object> pesquisar(){
        if(enderecoService.pesquisar().isEmpty()){
            return ResponseEntity.badRequest().body(new Sucess("sem registros!"));
        }
        return ResponseEntity.ok(enderecoService.pesquisar());
    }

    @GetMapping("/cliente/{idcliente}")
    public ResponseEntity<Object> pesquisar(@PathVariable int idcliente) {
        if (clienteService.localizar(idcliente) == null) {
            return ResponseEntity.badRequest().body(new Sucess("cliente não encontrado!"));
        } else {
            if (enderecoService.pesquisar(idcliente).isEmpty()) {
                return ResponseEntity.badRequest().body(new Sucess("sem registros!"));
            }
            return ResponseEntity.ok(enderecoService.pesquisar(idcliente));
        }
    }

    @PostMapping()
    public ResponseEntity<Object> salvar(@RequestBody Endereco endereco){
        List<Error> errors = new ArrayList<>();
        if(endereco.getIdcliente() == 0 ){
            errors.add(new Error("idcliente", "vazio"));
        }
        if(endereco.getCep().equals("") || endereco.getCep() == null){
            errors.add(new Error("CEP", "vazio"));
        }
        if(endereco.getLogradouro().equals("") || endereco.getLogradouro() == null){
            errors.add(new Error("Logradouro", "vazio"));
        }
        if(endereco.getBairro().equals("") || endereco.getBairro() == null){
            errors.add(new Error("Bairro", "vazio"));
        }
        if(endereco.getNumero().equals("") || endereco.getNumero() == null){
            errors.add(new Error("Numero", "vazio"));
        }
        if(endereco.getCidade().equals("") || endereco.getCidade() == null){
            errors.add(new Error("Cidade", "vazio"));
        }
        if(endereco.getUf().equals("") || endereco.getUf() == null){
            errors.add(new Error("UF", "vazio"));
        }
        if(!errors.isEmpty()){
            return ResponseEntity.badRequest().body(errors);
        }


        return ResponseEntity.ok(enderecoService.salvar(endereco));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable int id){
        if(enderecoService.localizar(id) == null){
            return ResponseEntity.badRequest().body(new Error("endereco", "não encontrado"));
        }
        enderecoService.excluir(id);
        return ResponseEntity.ok(new Sucess("endereco excluído"));

    }
}

