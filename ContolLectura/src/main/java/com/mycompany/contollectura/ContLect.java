
package com.mycompany.contollectura;


public class ContLect{
       public static void main(String[] args) {
        // No se puede crear un objeto de la clase abstracta Figura
        // Figura figura = new Figura("rojo"); // Error

        // Se pueden crear objetos de las clases concretas
        Circulo circulo = new Circulo("azul", 5);
        Rectangulo rectangulo = new Rectangulo("verde", 4, 6);

        // Se pueden llamar a los métodos de las clases abstractas
        System.out.println("Area del circulo: " + circulo.calcularArea());
        System.out.println("Perimetro del circulo: " + circulo.calcularPerimetro());
        System.out.println("Area del rectangulo: " + rectangulo.calcularArea());
        System.out.println("Perimetro del rectangulo: " + rectangulo.calcularPerimetro());

}
}
