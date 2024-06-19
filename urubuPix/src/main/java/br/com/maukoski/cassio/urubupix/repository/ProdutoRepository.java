package br.com.maukoski.cassio.urubupix.repository;

import br.com.maukoski.cassio.urubupix.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}

