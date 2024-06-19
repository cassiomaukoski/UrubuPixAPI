package br.com.maukoski.cassio.urubupix.service;

import br.com.maukoski.cassio.urubupix.model.Compra;
import br.com.maukoski.cassio.urubupix.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService {
    @Autowired
    CompraRepository compraRepository;

    public Compra localizar(int id) {
        Optional<Compra> compraBusca = compraRepository.findById(id);
        if (compraBusca.isPresent()) {
            return compraBusca.get();
        } else {
            return null;
        }
    }

    public List<Compra> pesquisar() {
        return compraRepository.findAll();
    }

    public List<Compra> pesquisar(int idcliente) {
        return compraRepository.findByIdcliente(idcliente);
    }

    public Compra salvar(Compra compra) {
        return compraRepository.save(compra);
    }

    public void excluir(int id) {
        compraRepository.deleteById(id);
    }

}

