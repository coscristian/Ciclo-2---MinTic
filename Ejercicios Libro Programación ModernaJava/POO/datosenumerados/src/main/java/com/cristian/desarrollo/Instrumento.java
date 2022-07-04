package com.cristian.desarrollo;
public class Instrumento {
    enum AbreviaturaInstrumento{
        Acordeón("aco"), Piano("p"), Saxofón("sax"), Guitarra("g"), Marimba("mrb"),
        Flauta("fl");

        private String instrumento;

        private AbreviaturaInstrumento(String instrumento){
            this.instrumento = instrumento;
        }

        public String mostrarAbreviatura(){
            return instrumento;
        }
    }

    public static void main(String[] args) {
        String ins1 = "Acordeón";
        String ins2 = "Piano";
        String ins3 = "Saxofón";
        String ins4 = "Guitarra";
        String ins5 = "Marimba";
        String ins6 = "Flauta";

        AbreviaturaInstrumento ab1 = Enum.valueOf(AbreviaturaInstrumento.class, ins1);
        AbreviaturaInstrumento ab2 = Enum.valueOf(AbreviaturaInstrumento.class, ins2);
        AbreviaturaInstrumento ab3 = Enum.valueOf(AbreviaturaInstrumento.class, ins3);
        AbreviaturaInstrumento ab4 = Enum.valueOf(AbreviaturaInstrumento.class, ins4);
        AbreviaturaInstrumento ab5 = Enum.valueOf(AbreviaturaInstrumento.class, ins5);
        AbreviaturaInstrumento ab6 = Enum.valueOf(AbreviaturaInstrumento.class, ins6);

        System.out.println("Instrumento: " + ins1 + "\tAbreviatura: " + ab1.mostrarAbreviatura());
        System.out.println("Instrumento: " + ins2 + "\tAbreviatura: " + ab2.mostrarAbreviatura());
        System.out.println("Instrumento: " + ins3 + "\tAbreviatura: " + ab3.mostrarAbreviatura());
        System.out.println("Instrumento: " + ins4 + "\tAbreviatura: " + ab4.mostrarAbreviatura());
        System.out.println("Instrumento: " + ins5 + "\tAbreviatura: " + ab5.mostrarAbreviatura());
        System.out.println("Instrumento: " + ins6 + "\tAbreviatura: " + ab6.mostrarAbreviatura());

    }
}
