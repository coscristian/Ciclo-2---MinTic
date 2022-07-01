public class Triangulo {
    private Integer base;
    private Integer altura;
    public Double area;

    public Integer getBase(){
        return base;
    }

    public Integer getAltura(){
        return altura;
    }

    public Double getArea(){
        return (base * altura) / 2;
    }

    public void setBase(Integer b){
        base = b;
    }

    public void setAltura(Integer a){
        altura = a;
    }

}
