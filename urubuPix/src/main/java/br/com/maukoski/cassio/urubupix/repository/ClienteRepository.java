package br.com.maukoski.cassio.urubupix.repository;

import br.com.maukoski.cassio.urubupix.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}

