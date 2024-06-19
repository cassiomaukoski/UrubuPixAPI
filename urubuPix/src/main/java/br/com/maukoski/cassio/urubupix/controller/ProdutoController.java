package br.com.maukoski.cassio.urubupix.controller;

import br.com.maukoski.cassio.urubupix.model.Error;
import br.com.maukoski.cassio.urubupix.model.ItemCompra;
import br.com.maukoski.cassio.urubupix.model.Produto;
import br.com.maukoski.cassio.urubupix.model.Sucess;
import br.com.maukoski.cassio.urubupix.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> localizar(@PathVariable int id){
        if(produtoService.localizar(id) == null){
            return ResponseEntity.badRequest().body(new Error("produto Service", "não encontrado"));
        }
        return ResponseEntity.ok(produtoService.localizar(id));
    }

    @GetMapping()
    public ResponseEntity<Object> pesquisar(){
        if(produtoService.pesquisar().isEmpty()){
            return ResponseEntity.badRequest().body(new Sucess("sem registros!"));
        }
        return ResponseEntity.ok(produtoService.pesquisar());
    }

    @PostMapping()
    public ResponseEntity<Object> salvar(@RequestBody Produto produto){
        List<Error> errors = new ArrayList<>();
        if(produto.getNome().equals("") || produto.getNome() == null){
            errors.add(new Error("nome", "vazio"));
        }

        if(produto.getDescricao().equals("") || produto.getDescricao() == null){
            errors.add(new Error("descricao", "vazio"));
        }

        if(produto.getImagem().equals("") || produto.getImagem() == null){
            errors.add(new Error("imagem", "vazia"));
        }

        if(produto.getPreco()==0){
            errors.add(new Error("preco", "vazia"));
        }


        if(!errors.isEmpty()){
            return ResponseEntity.badRequest().body(errors);
        }

        return ResponseEntity.ok(produtoService.salvar(produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable int id){
        if(produtoService.localizar(id) == null){
            return ResponseEntity.badRequest().body(new Error("produto", "não encontrado"));
        }
        produtoService.excluir(id);
        return ResponseEntity.ok(new Sucess("produto excluido"));

    }

}

