package br.com.maukoski.cassio.urubupix.service;

import br.com.maukoski.cassio.urubupix.model.ItemCompra;
import br.com.maukoski.cassio.urubupix.repository.ItemCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemCompraService {
    @Autowired
    ItemCompraRepository itemCompraRepository;

    public ItemCompra localizar(int id) {
        Optional<ItemCompra> itemCompraBusca = itemCompraRepository.findById(id);
        if (itemCompraBusca.isPresent()) {
            return itemCompraBusca.get();
        } else {
            return null;
        }
    }

    public List<ItemCompra> pesquisar(int idcompra) {
        return itemCompraRepository.findByIdcompra(idcompra);
    }

    public ItemCompra salvar(ItemCompra itemCompra) {
        return itemCompraRepository.save(itemCompra);
    }

    public void excluir(int id) {
        itemCompraRepository.deleteById(id);
    }

}

