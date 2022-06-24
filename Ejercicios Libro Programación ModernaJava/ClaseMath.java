public class ClaseMath {
    public static void main(String args[]){
        int valor = 130;
        //Conversion a grados
        System.out.println("Grados equivalentes --> " + Math.toDegrees(valor));

        //Conversion a radianes
        System.out.println("Radianes equivalentes --> " + Math.toRadians(valor));

        //Calculado de e elevado a la x
        int x = 3;
        System.out.println("e elevado a la " + x + " = " + Math.exp(x));

        //Calculo de logaritmo natural
        System.out.println("Logaritmo natural de " + x + " = " + Math.log(x));

        //Calculo de logaritmo en base 10
        System.out.println("Logaritmo en base 10 de " + x + " = " + Math.log10(x));

        //Muestra un numero aleatorio comprendido entre 0.0 y 1.0
        System.out.println("Numero aleatorio = " + Math.random());

        //Muestra el numero PI
        System.out.println("Numero PI = " + Math.PI);

        //Muestra el numero E
        System.out.println("Numero E = " + Math.E);

        //Elevar base a un exponente
        int base, expon;
        base = 4;
        expon = 3;
        System.out.println(base + " elevado a la " + expon + " = " + Math.pow(base, expon));

        //Calcular raiz cuadrada
        int Num = 30;
        System.out.println("Raiz cuadrada de " + Num + " = " + Math.sqrt(Num));

        //Calcular raiz cubica
        System.out.println("Raiz cubica de " + Num + " = " + Math.cbrt(Num));

        //Redondeo de un numero
        float Dato = 45.765F;
        System.out.println(Dato + " redondeado es = " + Math.round(Dato));

        //Calculo del Seno, Coseno y Tangente de un angulo
        double dato = 35;
        System.out.println("Seno de " + dato + " = " + Math.sin(dato));
        System.out.println("Coseno de " + dato + " = " + Math.cos(dato));
        System.out.println("Tangente de " + dato + " = " + Math.tan(dato));

        //Calculo del valor absoluto
        int ValorN = -45;
        System.out.println("Valor absoluto de " + ValorN + " = " + Math.abs(ValorN));
    }    
}
