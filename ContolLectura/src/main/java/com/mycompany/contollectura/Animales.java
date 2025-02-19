package com.mycompany.contollectura;
// Interfaz abstracta Animales
interface Animal {
    String getNombre();
    String hacerSonido();
}

// Clase abstracta Mamifero (implementa la interfaz Animal)
abstract class Mamifero implements Animal {
    private String nombre;

    public Mamifero(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}

// Clase Perro (extiende la clase abstracta Mamifero)
class Perro extends Mamifero {
    public Perro(String nombre) {
        super(nombre);
    }
@Override
    public String hacerSonido() {
        return "Guau guau";
    }
}

// Clase Gato (extiende la clase abstracta Mamifero)
class Gato extends Mamifero {
    public Gato(String nombre) {
        super(nombre);
    }

    @Override
    public String hacerSonido() {
        return "Miau miau";
    }
}

// Clase Pato (implementa la interfaz Animal)
class Pato implements Animal {
    private String nombre;

    public Pato(String nombre) {
        this.nombre = nombre;
    }
@Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String hacerSonido() {
        return "Cuac cuac";
    }
}