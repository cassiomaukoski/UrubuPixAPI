package br.com.maukoski.cassio.urubupix.service;

import br.com.maukoski.cassio.urubupix.model.Usuario;
import br.com.maukoski.cassio.urubupix.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService  {
    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario localizar(String login) {
        Optional<Usuario> usuarioBusca = usuarioRepository.findById(login);
        if (usuarioBusca.isPresent()) {
            return usuarioBusca.get();
        } else {
            return null;
        }
    }

    public List<Usuario> pesquisar() {
        return usuarioRepository.findAll();
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void excluir(String login) {
        usuarioRepository.deleteById(login);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
            return usuarioRepository.findByLogin(login);
    }
}

