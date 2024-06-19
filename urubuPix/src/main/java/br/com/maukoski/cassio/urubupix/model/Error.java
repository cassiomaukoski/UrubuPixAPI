package br.com.maukoski.cassio.urubupix.model;

import com.google.gson.Gson;

public class Error {
    private String field;
    private String URI;
    private String method;
    private String error;


    public Error(String field, String error) {
        this.field = field;
        this.URI = null;
        this.method = null;
        this.error = error;
    }

    public Error(String error){
        this.field = null;
        this.URI = null;
        this.method = null;
        this.error = error;
    }

    public Error(String URI,String method, int error){
        this.field = null;
        this.URI = URI;
        this.method = method;
        this.error = "rota não existe!";
    }

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }


}
