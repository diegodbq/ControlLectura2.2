package com.mycompany.listado;
import java.util.List;
import java.util.Scanner;
class ControladorInventario {
    private ListadoAlumnos modelo;
    private VistaConsola vista;

    public ControladorInventario(ListadoAlumnos modelo, VistaConsola vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    // Método que inicia el ciclo de interacción con el usuario
    public void iniciar() {
        boolean continuar = true;
        while (continuar) {
            vista.mostrarMenu();
            int opcion = Integer.parseInt(vista.leerString("")); // Se lee la opción
            switch (opcion) {
                case 1:
                    registrarAlumno();
                    break;
                case 2:
                    ingresarActualizarNota();
                    break;
                case 3:
                    consultarListado();
                    break;
                case 4:
                    continuar = false;
                    vista.mostrarMensaje("Saliendo del sistema...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Intente nuevamente.");
            }
        }
    }

    // Registra un nuevo alumno solicitando el nombre y asignándole un ID secuencial
    private void registrarAlumno() {
        String nombre = vista.leerString("Ingrese el nombre del alumno: ");
        int id = modelo.totalAlumnos() + 1; // Asigna un ID secuencial
        Alumno alumno = new Alumno(id, nombre);
        modelo.registrarAlumno(alumno);
        vista.mostrarMensaje("Alumno registrado con ID: " + id);
    }

    // Solicita el ID del alumno y la nota para ingresarla o actualizarla
    private void ingresarActualizarNota() {
        int id = vista.leerEntero("Ingrese el ID del alumno: ");
        double nota = vista.leerDouble("Ingrese la nota del alumno: ");
        boolean exito = modelo.actualizarNota(id, nota);
        if (exito) {
            vista.mostrarMensaje("Nota actualizada correctamente.");
        } else {
            vista.mostrarMensaje("Alumno no encontrado.");
        }
    }

    // Muestra el listado de alumnos y el total de registros
    private void consultarListado() {
        vista.mostrarListado(modelo.consultarListado());
        vista.mostrarMensaje("Total de alumnos: " + modelo.totalAlumnos());
    }
}