package com.cristian.desarrollo;

public class Colegio {
    public static void main(String[] args) {
        Estudiante e1 = new Estudiante("Cristian", "Quesada Cossio", "1087489628", "Tinajas", "20");
        System.out.println("Cantidad de estudiantes: " + e1.getCantEstudiantes());

        Estudiante e2 = new Estudiante("Juan", "Quesada Cossio", "107458347", "Tinajas", "19");
        Estudiante e3 = new Estudiante("Cesar", "Quesada Vivas", "10024241", "Tinajas", "48");
        System.out.println("Cantidad de estudiantes: " + e3.getCantEstudiantes());
    }
}
