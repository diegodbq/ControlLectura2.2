package com.mycompany.gestortareas.igu;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;

import javax.swing.*;


import javax.swing.JOptionPane;

    public class UsuarioLogin extends javax.swing.JFrame {
       private int intentos = 0;
       private MongoClient mongoClient;
    
    public UsuarioLogin() {
        initComponents();
        setLocationRelativeTo(null);
         mongoClient = crearConexion();
    }  
        private MongoClient crearConexion() {
       
            return new MongoClient("localhost", 27017); 
       
     
    }
private void LoginUsuario(){
        String usuario = t_username.getText();
        String pass = new String(t_pass.getPassword());
        int control=0;
        
      {
        if(t_username.getText().isEmpty()|| pass.length()==0 ){
            JOptionPane.showMessageDialog(null,"Debes llenar todos los campos");
            return;}
              MongoDatabase database = mongoClient.getDatabase("dbmongo"); 
            MongoCollection<Document> collection = database.getCollection("usuarios");
        
            Document filtro = new Document("nombre", usuario);
            FindIterable<Document> resultados = collection.find(filtro).limit(1);

        Document usuarioEncontrado = null;
            if (resultados.iterator().hasNext()) {
                usuarioEncontrado = resultados.iterator().next();
            }
                if (usuarioEncontrado != null) {
                // ¡PELIGRO! - Esto es inseguro. No almacenes contraseñas en texto plano.
                String passwordAlmacenada = usuarioEncontrado.getString("password");

                if (passwordAlmacenada.equals(pass)) { //  ¡RECUERDA USAR HASHING Y SALTING!
                    JOptionPane.showMessageDialog(null, "Acceso correcto, Bienvenido",
                            "Login", JOptionPane.INFORMATION_MESSAGE);
                     Principal pantalla = new Principal();
                    pantalla.setVisible(true);
                    pantalla.setLocationRelativeTo(null);

                    
                    this.dispose(); // Cerrar la ventana de login
                } else {
                    JOptionPane.showMessageDialog(null, "Error\n Usuario/ Contraseña, Incorrectos\n"
                            + "Intente de nuevo..", "Alerta", JOptionPane.ERROR_MESSAGE);
                    intentos++;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error\n Usuario/ Contraseña, Incorrectos\n"
                        + "Intente de nuevo..", "Alerta", JOptionPane.ERROR_MESSAGE);
                intentos++;
            }

            if (intentos >= 3) {
                JOptionPane.showMessageDialog(null, "Cantidad de intentos agotada\n"
                        + "Su cuenta ha sido bloqueada, favor contactar a soporte", "Aviso",
                        JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            }

        } 
    }

         
      



        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        l_nombre = new javax.swing.JLabel();
        l_imagen = new javax.swing.JLabel();
        l_username = new javax.swing.JLabel();
        t_username = new javax.swing.JTextField();
        l_pass = new javax.swing.JLabel();
        t_pass = new javax.swing.JPasswordField();
        b_iniciar = new javax.swing.JButton();
        b_salir = new javax.swing.JButton();
        b_registrarse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login de Usuario");

        l_nombre.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        l_nombre.setText("Gestor de Tareas");

        l_imagen.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Desktop\\userimagen.jpeg")); // NOI18N

        l_username.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        l_username.setText("Usuario");

        t_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_usernameActionPerformed(evt);
            }
        });

        l_pass.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        l_pass.setText("Contraseña");

        b_iniciar.setText("Iniciar");
        b_iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_iniciarActionPerformed(evt);
            }
        });

        b_salir.setText("Salir");
        b_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_salirActionPerformed(evt);
            }
        });

        b_registrarse.setText("Registrarse");
        b_registrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_registrarseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(l_pass)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(l_username)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(b_iniciar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(b_salir))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(t_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(t_username, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(l_imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(l_nombre))))
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(b_registrarse)
                        .addGap(97, 97, 97))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(l_nombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(l_imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(l_username)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(l_pass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_iniciar)
                    .addComponent(b_salir))
                .addGap(18, 18, 18)
                .addComponent(b_registrarse)
                .addContainerGap(24, Short.MAX_VALUE))
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

    private void t_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_usernameActionPerformed

    private void b_iniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_iniciarActionPerformed
        
        LoginUsuario();
        
    }//GEN-LAST:event_b_iniciarActionPerformed

    private void b_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_salirActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null,
                "Confirma salir de la aplicacion?",
                "confirma salida",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (respuesta == JOptionPane.YES_OPTION){
            System.exit(0);
        }
                
    }//GEN-LAST:event_b_salirActionPerformed

    private void b_registrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_registrarseActionPerformed
        RegistroUsuario pantalla = new RegistroUsuario();
        pantalla.setVisible(true);
        pantalla.setLocationRelativeTo(null);
    }//GEN-LAST:event_b_registrarseActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsuarioLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_iniciar;
    private javax.swing.JButton b_registrarse;
    private javax.swing.JButton b_salir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel l_imagen;
    private javax.swing.JLabel l_nombre;
    private javax.swing.JLabel l_pass;
    private javax.swing.JLabel l_username;
    private javax.swing.JPasswordField t_pass;
    private javax.swing.JTextField t_username;
    // End of variables declaration//GEN-END:variables
}
