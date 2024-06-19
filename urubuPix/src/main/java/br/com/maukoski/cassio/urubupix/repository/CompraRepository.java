package br.com.maukoski.cassio.urubupix.repository;

import br.com.maukoski.cassio.urubupix.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompraRepository extends JpaRepository<Compra, Integer> {
    List<Compra> findByIdcliente(Integer idcliente);
}

