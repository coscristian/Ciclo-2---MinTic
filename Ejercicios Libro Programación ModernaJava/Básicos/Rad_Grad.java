package Básicos;
//Construir un programa que convierta 2 radianes a su equivalente en grados
public class Rad_Grad{
    public static void main(String args[]){
        double rad = 2, grad;
        grad = Math.toDegrees(rad);
        System.out.println(rad + " radianes equivalen a " + grad + " grados.");
    }
}