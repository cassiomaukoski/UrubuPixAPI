package br.com.maukoski.cassio.urubupix.service;

import br.com.maukoski.cassio.urubupix.model.Produto;
import br.com.maukoski.cassio.urubupix.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;

    public Produto localizar(int id) {
        Optional<Produto> produtoBusca = produtoRepository.findById(id);
        if (produtoBusca.isPresent()) {
            return produtoBusca.get();
        } else {
            return null;
        }
    }

    public List<Produto> pesquisar() {
        return produtoRepository.findAll();
    }

    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void excluir(int id) {
        produtoRepository.deleteById(id);
    }

}

