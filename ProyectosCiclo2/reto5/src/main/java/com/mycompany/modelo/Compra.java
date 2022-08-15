
package com.mycompany.modelo;

public class Compra {
    private Integer id;
    private String constructora;
    private String banco;

    public Compra(Integer id, String constructora, String banco) {
        this.id = id;
        this.constructora = constructora;
        this.banco = banco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConstructora() {
        return constructora;
    }

    public void setConstructora(String constructora) {
        this.constructora = constructora;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }
    
    
}
