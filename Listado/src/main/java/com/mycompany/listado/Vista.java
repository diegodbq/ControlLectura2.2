package com.mycompany.listado;
import java.util.List;
import java.util.Scanner;

class VistaConsola {
    private Scanner scanner;

    public VistaConsola() {
        scanner = new Scanner(System.in);
    }

    // Muestra el menú principal
    public void mostrarMenu() {
        System.out.println("\n---- Sistema de Gestión de Notas ----");
        System.out.println("1. Registrar Alumno");
        System.out.println("2. Ingresar/Actualizar Nota");
        System.out.println("3. Consultar Listado de Alumnos");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // Métodos para leer datos con mensaje
    public int leerEntero(String mensaje) {
        System.out.print(mensaje);
        return Integer.parseInt(scanner.nextLine());
    }

    public double leerDouble(String mensaje) {
        System.out.print(mensaje);
        return Double.parseDouble(scanner.nextLine());
    }

    public String leerString(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    // Muestra un mensaje en consola
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    // Muestra el listado de alumnos
    public void mostrarListado(List<Alumno> alumnos) {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
        } else {
            for (Alumno a : alumnos) {
                System.out.println(a);
            }
        }
    }
}