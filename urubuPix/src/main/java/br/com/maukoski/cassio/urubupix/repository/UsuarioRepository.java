package br.com.maukoski.cassio.urubupix.repository;

import br.com.maukoski.cassio.urubupix.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Usuario findByLogin(String login);
}

