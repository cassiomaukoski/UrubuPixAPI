package br.com.maukoski.cassio.urubupix.controller;

import br.com.maukoski.cassio.urubupix.model.Error;
import br.com.maukoski.cassio.urubupix.model.ItemCompra;
import br.com.maukoski.cassio.urubupix.model.Sucess;
import br.com.maukoski.cassio.urubupix.service.CompraService;
import br.com.maukoski.cassio.urubupix.service.ItemCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/itemcompra")
public class ItemCompraController {
    @Autowired
    ItemCompraService itemCompraService;

    @Autowired
    CompraService compraService;

    @GetMapping("/{idcompra}")
    public ResponseEntity<Object> pesquisar(@PathVariable int idcompra){
        if(compraService.localizar(idcompra)==null){
            return ResponseEntity.badRequest().body(new Sucess("compra não encontrada!"));
        }else {
            if (itemCompraService.pesquisar(idcompra).isEmpty()) {
                return ResponseEntity.badRequest().body(new Sucess("sem registros!"));
            }
            return ResponseEntity.ok(itemCompraService.pesquisar(idcompra));
        }
    }

    @PostMapping()
    public ResponseEntity<Object> salvar(@RequestBody ItemCompra itemCompra){
        List<Error> errors = new ArrayList<>();
        if(itemCompra.getIdproduto() == 0){
            errors.add(new Error("idproduto", "vazio"));
        }
        if(itemCompra.getIdcompra() == 0){
            errors.add(new Error("idcompra", "vazio"));
        }

        if(!errors.isEmpty()){
            return ResponseEntity.badRequest().body(errors);
        }

        return ResponseEntity.ok(itemCompraService.salvar(itemCompra));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable int id){
        if(itemCompraService.localizar(id) == null){
            return ResponseEntity.badRequest().body(new Error("itemCompra", "não encontrado"));
        }
        itemCompraService.excluir(id);
        return ResponseEntity.ok(new Sucess("itemCompra excluido"));

    }

}

