package com.mycompany.gestortareas.igu;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Tareas extends javax.swing.JFrame {
  
       private MongoClient mongoClient;
  
    public Tareas() {
       initComponents();
        setLocationRelativeTo(null);

        // Inicializar conexión y listener para cerrar la conexión al cerrar la ventana
        mongoClient = crearConexion();
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeConnection();
            }
        });
    }


    private MongoClient crearConexion() {
     try {
            return new MongoClient("localhost", 27017);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al conectar a la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            System.exit(1); // Salir de la aplicación si no se puede conectar a la base de datos
            return null; // Esta línea no se ejecutará, pero es necesaria para evitar un error de compilación
        }
    }
    
     private void closeConnection() {
        if (mongoClient != null) {
            try {
                mongoClient.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
 private void registrarTarea() {
    String titulo = t_titulo.getText();
    String descripcion = t_descripcion.getText();

    if (titulo.isEmpty() || descripcion.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
        return;
    }

    try (MongoClient mongoClient = crearConexion()) { // Try-with-resources
        MongoDatabase database = mongoClient.getDatabase("dbmongo");
        MongoCollection<Document> collection = database.getCollection("tareas");

        Document tarea = new Document("titulo", titulo).append("descripcion", descripcion);
        collection.insertOne(tarea);

        JOptionPane.showMessageDialog(this, "Tarea registrada correctamente.");
        t_titulo.setText("");
        t_descripcion.setText("");
        // Elimina dispose() si quieres mantener la ventana abierta
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al registrar la tarea: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace(); // Registra el error para depuración
    
    }
 }

    public String getTituloTarea() {
        return this.t_titulo.getText(); // Asumiendo que jTextField1 es el campo para el título
    }

    public String getDescripcionTarea() {
        return this.t_descripcion.getText(); // Asumiendo que jTextArea1 es el campo para la descripción
    }

    

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        l_taraea = new javax.swing.JLabel();
        t_titulo = new javax.swing.JTextField();
        l_descripcion = new javax.swing.JLabel();
        t_descripcion = new javax.swing.JTextField();
        b_guardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        l_taraea.setText("Titulo de la Tarea");

        t_titulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_tituloActionPerformed(evt);
            }
        });

        l_descripcion.setText("Descripcion");

        b_guardar.setText("Guardar");
        b_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_guardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(l_descripcion)
                            .addComponent(l_taraea)
                            .addComponent(t_descripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(t_titulo)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(b_guardar)))
                .addContainerGap(169, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(l_taraea)
                .addGap(18, 18, 18)
                .addComponent(t_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(l_descripcion)
                .addGap(18, 18, 18)
                .addComponent(t_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(b_guardar)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void t_tituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_tituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_tituloActionPerformed

    private void b_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_guardarActionPerformed
          registrarTarea();
          dispose();
    }//GEN-LAST:event_b_guardarActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_guardar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel l_descripcion;
    private javax.swing.JLabel l_taraea;
    private javax.swing.JTextField t_descripcion;
    private javax.swing.JTextField t_titulo;
    // End of variables declaration//GEN-END:variables
}
