package br.com.maukoski.cassio.urubupix.model;

import javax.persistence.*;

@Entity
@Table(name = "itemcompra")
public class ItemCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idcompra;
    private int idproduto;
    private int quantidade;

    public ItemCompra(int id, int idcompra, int idproduto, int quantidade) {
        this.id = id;
        this.idcompra = idcompra;
        this.idproduto = idproduto;
        this.quantidade = quantidade;
    }

    public ItemCompra() {
        this.id = 0;
        this.idcompra = 0;
        this.idproduto = 0;
        this.quantidade = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}


