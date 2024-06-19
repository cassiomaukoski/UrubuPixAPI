package br.com.maukoski.cassio.urubupix.repository;

import br.com.maukoski.cassio.urubupix.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
    List<Endereco> findByIdcliente(Integer idcliente);
}

