
package com.mycompany.gestortareas.igu;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


import org.bson.Document;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;




public class Principal extends javax.swing.JFrame {
 private MongoClient mongoClient;
 private DefaultTableModel modelo;
 private MongoCollection<Document>collection;
 private String n_bd = "mongodb";
    private String n_colecccion = "tareas";

    public Principal() {
        initComponents();
        inicializarTabla();
        conectarMongoDB();
        cargarTareasMongoDb();
         this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                cerrarConexionMongoDB();
            }
        });
    }

   

     private void conectarMongoDB() {
        String uri = "mongodb://localhost:27017"; // Reemplaza con tu URI si es necesario
        try {
            mongoClient = MongoClients.create(uri);
            MongoDatabase database = mongoClient.getDatabase(n_bd);
            collection = database.getCollection(n_colecccion);
            System.out.println("Conexión a MongoDB exitosa.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al conectar a MongoDB: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            System.exit(1); // Importante: Salir si no se puede conectar
        }
    }



 
    private void cerrarConexionMongoDB() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("Conexión a MongoDB cerrada.");
        }
    }

 
    

private void cargarTareasMongoDb() {
        try {
            if (collection != null) { // Verifica si la colección se inicializó
                for (Document tarea : collection.find()) {
                    modelo.addRow(new Object[]{tarea.getString("titulo"), tarea.getString("descripcion")});
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar tareas desde MongoDB: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

private void guardarTareaEnMongoDB(String titulo, String descripcion) {
        try {
            Document document = new Document("titulo", titulo).append("descripcion", descripcion);
            if (collection != null) { // Verifica si la colección se inicializó
                collection.insertOne(document);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar tarea en MongoDB: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }



 private void actualizarTareaEnMongoDB(int fila, String titulo, String descripcion) {
        try {
            String tituloActual = (String) modelo.getValueAt(fila, 0); // Obtener el título original para la consulta
            Document filtro = new Document("titulo", tituloActual); // Filtro para encontrar el documento a actualizar
            Document actualizacion = new Document("$set", new Document("titulo", titulo).append("descripcion", descripcion)); // Actualización
            collection.updateOne(filtro, actualizacion);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar tarea en MongoDB: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

 
private void eliminarTareaDeMongoDB(int fila) {
        try {
            String titulo = (String) modelo.getValueAt(fila, 0);
            Document filtro = new Document("titulo", titulo);
            if (collection != null) { // Verifica si la colección se inicializó
                collection.deleteOne(filtro);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar tarea de MongoDB: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }


     private void inicializarTabla() {
        modelo = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Titulo", "Descripcion"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla1.setModel(modelo);
    }

      

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        b_añadir = new javax.swing.JButton();
        b_editar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        b_eliminar = new javax.swing.JButton();
        b_salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        b_añadir.setText("Añadir");
        b_añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_añadirActionPerformed(evt);
            }
        });

        b_editar.setText("Editar");
        b_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_editarActionPerformed(evt);
            }
        });

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Tareas"
            }
        ));
        jScrollPane1.setViewportView(tabla1);

        b_eliminar.setText("Eliminar");
        b_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_eliminarActionPerformed(evt);
            }
        });

        b_salir.setText("Salir");
        b_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(b_añadir)
                .addGap(36, 36, 36)
                .addComponent(b_editar)
                .addGap(28, 28, 28)
                .addComponent(b_eliminar)
                .addGap(46, 46, 46)
                .addComponent(b_salir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_editar)
                    .addComponent(b_añadir)
                    .addComponent(b_eliminar)
                    .addComponent(b_salir))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_salirActionPerformed
        UsuarioLogin user = new UsuarioLogin();
        user.setVisible(true);
        user.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_b_salirActionPerformed

    private void b_añadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_añadirActionPerformed
      Tareas pantalla = new Tareas();
        pantalla.setVisible(true);
        pantalla.setLocationRelativeTo(null);
        
         pantalla.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                String titulo = pantalla.getTituloTarea();
                String descripcion = pantalla.getDescripcionTarea();

                if (titulo != null && !titulo.isEmpty() && descripcion != null && !descripcion.isEmpty()) {
                    modelo.addRow(new Object[]{titulo, descripcion});
                    guardarTareaEnMongoDB(titulo, descripcion);
                }
            }
        });
   
  
        
        
    }//GEN-LAST:event_b_añadirActionPerformed

    private void b_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_editarActionPerformed
     
        int filaSeleccionada = tabla1.getSelectedRow();
        if (filaSeleccionada >= 0) {
            String tituloActual = (String) modelo.getValueAt(filaSeleccionada, 0);
            String descripcionActual = (String) modelo.getValueAt(filaSeleccionada, 1);

            String nuevoTitulo = JOptionPane.showInputDialog(this, "Editar título:", tituloActual);
            String nuevaDescripcion = JOptionPane.showInputDialog(this, "Editar descripcion:", descripcionActual);

            if (nuevoTitulo != null && nuevaDescripcion != null && !nuevoTitulo.isEmpty() && !nuevaDescripcion.isEmpty()) {
                modelo.setValueAt(nuevoTitulo, filaSeleccionada, 0);
                modelo.setValueAt(nuevaDescripcion, filaSeleccionada, 1);
                actualizarTareaEnMongoDB(filaSeleccionada, nuevoTitulo, nuevaDescripcion);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una tarea para editar.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_b_editarActionPerformed


    
    
    
    
    private void b_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_eliminarActionPerformed
        
        int filaSeleccionada = tabla1.getSelectedRow();
        if (filaSeleccionada >= 0) {
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar esta tarea?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                eliminarTareaDeMongoDB(filaSeleccionada);
                modelo.removeRow(filaSeleccionada);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una tarea para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
     
    }//GEN-LAST:event_b_eliminarActionPerformed


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_añadir;
    private javax.swing.JButton b_editar;
    private javax.swing.JButton b_eliminar;
    private javax.swing.JButton b_salir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla1;
    // End of variables declaration//GEN-END:variables

} 
