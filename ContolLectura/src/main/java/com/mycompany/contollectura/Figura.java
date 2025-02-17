
package com.mycompany.contollectura;


public abstract class Figura {
    
    protected String color;

    
    protected Figura() {
         this.color = color;

 }
    public abstract double calcularArea();
    public abstract double calcularPerimetro();
public void mostrarColor() {
        System.out.println("Color: " + color);
    }
}