package com.cristian.desarrollo;

public class ProgramaDocumento {
    public static void main(String[] args) {
        Documento[] documentos = new Documento[5];

        Libro2 l1 = new Libro2("Programacion Moderna", "Rojo", "Arial12", "Grande", "Omar Trejos", "2019", "Reily");
        Cuaderno c1 = new Cuaderno("Verde", "Cursiva", "Pequeño", "Scribe", "No");
        LibretaNota ln1 = new LibretaNota("Cafe", "Times New Roman", "Mediana", "Si", "Si");

        documentos[0] = l1;
        documentos[1] = c1;
        documentos[2] = ln1;
        documentos[3] = new Documento("How IA changes the world", "Blanco", "Arial 12", "Grande");
        documentos[4] = new Documento("Acute Liver Failure", "Gris", "Times New 12", "Mediano");

        for (Documento doc : documentos) {
            System.out.println(doc.mostrarTamanio());
        }
    }
}
