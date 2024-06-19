package br.com.maukoski.cassio.urubupix.model;

import javax.persistence.*;


import java.text.SimpleDateFormat;
import java.util.Calendar;

@Entity
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idcliente;
    private int idendereco;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar data;

    public Compra(int id, int idcliente, int idendereco, Calendar data) {
        this.id = id;
        this.idcliente = idcliente;
        this.idendereco = idendereco;
        this.data = data;
    }

    public Compra() {
        this.id = 0;
        this.idcliente = 0;
        this.idendereco = 0;
        this.data = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdendereco() {
        return idendereco;
    }

    public void setIdendereco(int idendereco) {
        this.idendereco = idendereco;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

}


