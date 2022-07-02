public class Triangulo {
    private Double base;
    private Double altura;
    public Double area;

    public Double getBase(){
        return base;
    }

    public Double getAltura(){
        return altura;
    }

    public Double getArea(){
        return (base * altura) / 2;
    }

    public void setBase(Double b){
        base = b;
    }

    public void setAltura(Double a){
        altura = a;
    }

}
