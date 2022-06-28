package POO.ejerciciosParte1.ClasesPrincipales;

import POO.ejerciciosParte1.Clases.ClaseCarro;

public class ClasePrincipalCarro {
    public static void main(String[] args) {
        ClaseCarro Carro1 = new ClaseCarro();
        System.out.println("Marca:\t" + Carro1.Marca);
        System.out.println("Modelo:\t" + Carro1.Modelo);
        System.out.println("Color:\t" + Carro1.Color);
        System.out.println("Transmisión:\t" + Carro1.Transmision);
        System.out.println("Precio:\t" + Carro1.Precio);
    }
}
