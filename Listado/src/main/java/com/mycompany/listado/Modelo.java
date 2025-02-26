package com.mycompany.listado;
import java.util.ArrayList;
import java.util.List;
class Alumno {
    private int id;
    private String nombre;
    private double nota; // Se usa -1 para indicar que aún no se ha ingresado la nota

    public Alumno(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.nota = -1; // Nota no asignada
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Nota: " + (nota >= 0 ? nota : "N/A");
    }
}

class ListadoAlumnos {
    private List<Alumno> alumnos;

    public ListadoAlumnos() {
        alumnos = new ArrayList<>();
    }

    // Método para registrar un alumno
    public void registrarAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    // Método para ingresar o actualizar la nota de un alumno
    public boolean ingresarNota(int id, double nota) {
        for (Alumno a : alumnos) {
            if (a.getId() == id) {
                a.setNota(nota);
                return true;
            }
        }
        return false;
    }

    // Método para consultar el listado de alumnos
    public List<Alumno> consultarListado() {
        return alumnos;
    }

    // Método para actualizar la nota (se utiliza el mismo proceso que ingresarNota)
    public boolean actualizarNota(int id, double nota) {
        return ingresarNota(id, nota);
    }

    // Retorna el total de alumnos registrados
    public int totalAlumnos() {
        return alumnos.size();
    }
}