
package com.mycompany.gestortareas.persistencia;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import java.util.List;
import javax.swing.JOptionPane;


public class ControladoraPersistencia {
     public MongoClient crearConexion() {
       
    MongoClient mongo = null;
        String servidor = "localhost";
        Integer puerto = 27017;
        try {
            mongo = new MongoClient(servidor,puerto);
            
            List<String> NombresBasesDeDatos = mongo.getDatabaseNames();
            JOptionPane.showMessageDialog(null, "Se conecto a Mongodb, la lista:"+ NombresBasesDeDatos.toString());
        }catch (MongoException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexion Mongodb:"+e.toString());
                   
        }
        
        
      return mongo;
    }
}
