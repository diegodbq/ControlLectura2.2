

package com.mycompany.contollectura;


public class ContolLectura {

    public static void main(String[] args) {
          // Lista de profesores
        Profesor[] profesores = new Profesor[3];
        profesores[0] = new ProfesorTiempoCompleto("Juan", 40);
        profesores[1] = new ProfesorMedioTiempo("María", 20);
        profesores[2] = new ProfesorInvitado("Carlos", 20);

        // Calcular y mostrar el salario de cada profesor
        for (Profesor profesor : profesores) {
            double salario = profesor.calcularSalario();
            System.out.println("El salario de " + profesor.nombre + " es de " + salario + "$");
        }
    }
}
    
       