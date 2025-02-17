
package com.mycompany.contollectura;


    
   class Cuadrado extends Figura {
    private double base;
    private double altura;

    public Cuadrado(String color, double base, double altura) {
        super(color);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 4* (base);
    }
}