package com.mycompany.gestortareas;

import com.mycompany.gestortareas.igu.UsuarioLogin;
import com.mycompany.gestortareas.persistencia.ControladoraPersistencia;


public class GestorTareas {

    public static void main(String[] args) {
        ControladoraPersistencia objetoconexion = new ControladoraPersistencia();
        objetoconexion.crearConexion();
        UsuarioLogin user = new UsuarioLogin();
        user.setVisible(true);
        user.setLocationRelativeTo(null);
    }
}
