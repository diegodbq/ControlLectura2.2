package com.mycompany.contollectura;
abstract class Profesor {
    String nombre;
    int horasTrabajadas;

    public Profesor(String nombre, int horasTrabajadas) {
        this.nombre = nombre;
        this.horasTrabajadas = horasTrabajadas;
    }

    // Método abstracto para calcular el salario
    public abstract double calcularSalario();
}

// Clase ProfesorTiempoCompleto
class ProfesorTiempoCompleto extends Profesor {
    public ProfesorTiempoCompleto(String nombre, int horasTrabajadas) {
        super(nombre, horasTrabajadas);
    }

    @Override
    public double calcularSalario() {
        return horasTrabajadas * 100; // Ejemplo: 100$ por hora
    }
}
// Clase ProfesorMedioTiempo
class ProfesorMedioTiempo extends Profesor {
    public ProfesorMedioTiempo(String nombre, int horasTrabajadas) {
        super(nombre, horasTrabajadas);
    }

    @Override
    public double calcularSalario() {
        return horasTrabajadas * 50; // Ejemplo: 50$ por hora
    }
}

// Clase ProfesorInvitado
class ProfesorInvitado extends Profesor {
    public ProfesorInvitado(String nombre, int horasTrabajadas) {
        super(nombre, horasTrabajadas);
    }

    @Override
    public double calcularSalario() {
        return horasTrabajadas * 25; // Ejemplo: 25$ por hora
    }
}

