package com.cristian.desarrollo;

public class Pensum {
    enum CodigoPensum{
        HumanidadesI("BA172"), MatematicasI("CB115"), DesarrolloPensamientoLogico("IS142"),
        ProgramaciónI("IS105"), IntroduccionInformatica("IS193");
    
        private String materia;
        private CodigoPensum(String materia){
            this.materia = materia;
        }

        public String mostrarCodigo(){
            return materia;
        }
    }

    public static void main(String[] args) {
        String m1 = "HumanidadesI";
        String m2 = "MatematicasI";
        String m3 = "DesarrolloPensamientoLogico";
        String m4 = "ProgramaciónI";
        String m5 = "IntroduccionInformatica";

        CodigoPensum c1 = Enum.valueOf(CodigoPensum.class, m1);
        CodigoPensum c2 = Enum.valueOf(CodigoPensum.class, m2);
        CodigoPensum c3 = Enum.valueOf(CodigoPensum.class, m3);
        CodigoPensum c4 = Enum.valueOf(CodigoPensum.class, m4);
        CodigoPensum c5 = Enum.valueOf(CodigoPensum.class, m5);

        System.out.println("Código: " + c1.mostrarCodigo() + "\tAsignatura: " + m1);
        System.out.println("Código: " + c2.mostrarCodigo() + "\tAsignatura: " + m2);
        System.out.println("Código: " + c3.mostrarCodigo() + "\tAsignatura: " + m3);
        System.out.println("Código: " + c4.mostrarCodigo() + "\tAsignatura: " + m4);
        System.out.println("Código: " + c5.mostrarCodigo() + "\tAsignatura: " + m5);
    }
}
