

package com.mycompany.contollectura;

public class ContLect {

    public static void main(String[] args) {
           // Crear animales
        Animal perro = new Perro("Firulais");
        Animal gato = new Gato("Michifus");
        Animal pato = new Pato("Donald");

        // Mostrar información de los animales
        System.out.println("Nombre del perro: " + perro.getNombre());
        System.out.println("Sonido del perro: " + perro.hacerSonido());

        System.out.println("Nombre del gato: " + gato.getNombre());
        System.out.println("Sonido del gato: " + gato.hacerSonido());

        System.out.println("Nombre del pato: " + pato.getNombre());
        System.out.println("Sonido del pato: " + pato.hacerSonido());
    }
}