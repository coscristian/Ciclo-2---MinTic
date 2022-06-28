package POO;

public class ClaseEjem {
    public static void main(String[] args) {
        //Crea objeto con caracteristicas de Clase Base-Comenzará en sus atributos con los valores que se almacenan en su metodo constructor
        ClaseBase Objeto1 = new ClaseBase();
        System.out.println("Dato entero:\t" + Objeto1.Dato1);
        System.out.println("Dato real:\t" + Objeto1.Dato2);
        System.out.println("Cadena :\t" + Objeto1.Nombre);
    }
}
