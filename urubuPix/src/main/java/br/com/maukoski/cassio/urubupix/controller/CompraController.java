package br.com.maukoski.cassio.urubupix.controller;

import br.com.maukoski.cassio.urubupix.model.Compra;
import br.com.maukoski.cassio.urubupix.model.Error;
import br.com.maukoski.cassio.urubupix.model.Sucess;
import br.com.maukoski.cassio.urubupix.service.ClienteService;
import br.com.maukoski.cassio.urubupix.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/compra")
public class CompraController {
    @Autowired
    CompraService compraService;
    @Autowired
    ClienteService clienteService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> localizar(@PathVariable int id) {
        if (compraService.localizar(id) == null) {
            return ResponseEntity.badRequest().body(new Error("compra", "não encontrado"));
        }
        return ResponseEntity.ok(compraService.localizar(id));
    }

    @GetMapping()
    public ResponseEntity<Object> pesquisar() {
        if (compraService.pesquisar().isEmpty()) {
            return ResponseEntity.badRequest().body(new Sucess("sem registros!"));
        }
        return ResponseEntity.ok(compraService.pesquisar());
    }

    @GetMapping("/cliente/{idcliente}")
    public ResponseEntity<Object> pesquisar(@PathVariable int idcliente) {
        if (clienteService.localizar(idcliente) == null) {
            return ResponseEntity.badRequest().body(new Sucess("cliente não encontrado!"));
        } else {
            if (compraService.pesquisar(idcliente).isEmpty()) {
                return ResponseEntity.badRequest().body(new Sucess("sem registros!"));
            }
            return ResponseEntity.ok(compraService.pesquisar(idcliente));
        }
    }

    @PostMapping()
    public ResponseEntity<Object> salvar(@RequestBody Compra compra) {
        List<Error> errors = new ArrayList<>();
        if (compra.getIdendereco() == 0) {
            errors.add(new Error("idendereco", "vazio"));
        }
        if (compra.getIdcliente() == 0) {
            errors.add(new Error("idcliente", "vazio"));
        }
        if (compra.getData() == null) {
            errors.add(new Error("data", "vazio"));
        }

        if (!errors.isEmpty()) {
            return ResponseEntity.badRequest().body(errors);
        }


        return ResponseEntity.ok(compraService.salvar(compra));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable int id) {
        if (compraService.localizar(id) == null) {
            return ResponseEntity.badRequest().body(new Error("compra", "não encontrado"));
        }
        compraService.excluir(id);
        return ResponseEntity.ok(new Sucess("compra excluído"));

    }
}

