package br.com.maukoski.cassio.urubupix.service;

import br.com.maukoski.cassio.urubupix.model.Compra;
import br.com.maukoski.cassio.urubupix.model.Endereco;
import br.com.maukoski.cassio.urubupix.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    EnderecoRepository enderecoRepository;

    public Endereco localizar(int id) {
        Optional<Endereco> enderecoBusca = enderecoRepository.findById(id);
        if (enderecoBusca.isPresent()) {
            return enderecoBusca.get();
        } else {
            return null;
        }
    }

    public List<Endereco> pesquisar() {
        return enderecoRepository.findAll();
    }

    public List<Endereco> pesquisar(int idcliente) {
        return enderecoRepository.findByIdcliente(idcliente);
    }

    public Endereco salvar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public void excluir(int id) {
        enderecoRepository.deleteById(id);
    }

}

