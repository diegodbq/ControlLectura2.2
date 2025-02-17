

package com.mycompany.contollectura;


public class ContolLectura {

    public static void main(String[] args) {
        Figura[] figuras = new Figura[2];
        figuras[0] = new Circulo("rojo", 5); 
        figuras[1] = new Rectangulo("azul", 4, 6); 

        for (Figura figura : figuras) {
            figura.mostrarColor();
            System.out.println("Área: " + figura.calcularArea());
            System.out.println("Perímetro: " + figura.calcularPerimetro());
           
    }
}
}