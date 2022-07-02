package com.cristian.desarrollo;

public class Suma {
    private Integer n1;
    private Integer n2;
    private Integer n3;
    private Integer n4;
    private Integer suma;

    public Suma(Integer n1, Integer n2, Integer n3, Integer n4) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4 = n4;
        this.suma = this.n1 + this.n2 + this.n3 + this.n4;
    }

    public Suma(Integer n1, Integer n2){
        this(n1, n2,0,0);
    }

    public Suma(Integer n1, Integer n2, Integer n3){
        this(n1, n2, n3, 0);
    }

    public String mostrarResultado(){
        return "El resultado de la suma es: " + suma;
    }

}
