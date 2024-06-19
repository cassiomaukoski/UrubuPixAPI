package br.com.maukoski.cassio.urubupix.service;

import br.com.maukoski.cassio.urubupix.model.Cliente;
import br.com.maukoski.cassio.urubupix.model.Cliente;
import br.com.maukoski.cassio.urubupix.repository.ClienteRepository;
import br.com.maukoski.cassio.urubupix.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public Cliente localizar(int id) {
        Optional<Cliente> clienteBusca = clienteRepository.findById(id);
        if (clienteBusca.isPresent()) {
            return clienteBusca.get();
        } else {
            return null;
        }
    }

    public List<Cliente> pesquisar() {
        return clienteRepository.findAll();
    }

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void excluir(int id) {
        clienteRepository.deleteById(id);
    }

}

