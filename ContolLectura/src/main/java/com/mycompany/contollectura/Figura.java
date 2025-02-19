
package com.mycompany.contollectura;


abstract class Figura {
    // Atributos comunes a todas las figuras
    protected String color;

    // Constructor
    public Figura(String color) {
        this.color = color;
    }

    // Métodos abstractos (sin implementación)
    public abstract double calcularArea();
    public abstract double calcularPerimetro();

    // Método concreto (con implementación)
    public String getColor() {
        return color;
    }
}
class Circulo extends Figura {
    private double radio;

    public Circulo(String color, double radio) {
        super(color);
        this.radio = radio;
    }

    // Implementación de los métodos abstractos
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
}
class Rectangulo extends Figura {
    private double base;
    private double altura;

    public Rectangulo(String color, double base, double altura) {
        super(color);
        this.base = base;
        this.altura = altura;
    }

    // Implementación de los métodos abstractos
    @Override
    public double calcularArea() {
        return base * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }
}

