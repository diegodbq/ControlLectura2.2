

package com.mycompany.listado;

public class Listado {

    public static void main(String[] args) {
        // Crear instancias del modelo y la vista
        ListadoAlumnos modelo = new ListadoAlumnos();
        VistaConsola vista = new VistaConsola();
        
        // Crear el controlador y arrancar la aplicación
        ControladorInventario controlador = new ControladorInventario(modelo, vista);
        controlador.iniciar();
    }
}