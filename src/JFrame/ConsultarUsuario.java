package JFrame;

import acaddeportsportkids.Comun;
import acaddeportsportkids.Usuario;
import java.awt.Color;
import java.awt.event.KeyEvent;

public class ConsultarUsuario extends javax.swing.JFrame {
    
    private Usuario actual = null;
    

    public ConsultarUsuario(){
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public void consultar() {
        
        actual = Comun.buscarUsuario(setTxtUsuario.getText());
        if (actual != null) {
            this.getTxtUser.setText(String.valueOf(actual.getId()));
            this.getTxtNombre.setText(actual.getNombre());
            this.getTxtEstado.setText(actual.getEstadoPrint());
            btnEstado.setEnabled(true);
            if (actual.getEstado()) {
                btnEstado.setText("Desactivar");
            }else{
                btnEstado.setText("Activar");
            }
            
        } else {
            /*/JOptionPane.showMessageDialog(null, "¡No se encontró el dato buscado!",
                    "Academia Deportiva Sport Kids", JOptionPane.ERROR_MESSAGE);/*/
            
            setTxtUsuario.setForeground(Color.red);
            txtErrorUser.setText("Usuario NO encontrado!");
        }
    }
    
    public void limpiar(){
        getTxtNombre.setText("");
        getTxtUser.setText("");
        getTxtEstado.setText("");
        btnEstado.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        setTxtUsuario = new javax.swing.JTextField();
        txtErrorUser = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        getTxtUser = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        getTxtNombre = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        getTxtEstado = new javax.swing.JLabel();
        btnConsultar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnEstado = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuario por buscar");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 376, -1, 20));

        setTxtUsuario.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        setTxtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        setTxtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        setTxtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setTxtUsuarioActionPerformed(evt);
            }
        });
        setTxtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                setTxtUsuarioKeyReleased(evt);
            }
        });
        jPanel1.add(setTxtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 370, 220, 40));

        txtErrorUser.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtErrorUser.setForeground(new java.awt.Color(255, 255, 255));
        txtErrorUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(txtErrorUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 440, 200, 24));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ID del usuario");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 610, 110, 30));

        getTxtUser.setBackground(new java.awt.Color(255, 255, 255));
        getTxtUser.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        getTxtUser.setForeground(new java.awt.Color(255, 255, 255));
        getTxtUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(getTxtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 610, 270, 30));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 510, -1, 30));

        getTxtNombre.setBackground(new java.awt.Color(255, 255, 255));
        getTxtNombre.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        getTxtNombre.setForeground(new java.awt.Color(255, 255, 255));
        getTxtNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(getTxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 510, 340, 30));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Estado del Usuario");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 690, 123, 40));

        getTxtEstado.setBackground(new java.awt.Color(255, 255, 255));
        getTxtEstado.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        getTxtEstado.setForeground(new java.awt.Color(255, 255, 255));
        getTxtEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(getTxtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 700, 100, 30));

        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesConsultar/Frame 4178.png"))); // NOI18N
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        jPanel1.add(btnConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 540, 290, 60));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesConsultar/Frame 4205.png"))); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 640, 280, 60));

        btnEstado.setBackground(new java.awt.Color(204, 255, 204));
        btnEstado.setForeground(new java.awt.Color(255, 255, 255));
        btnEstado.setEnabled(false);
        btnEstado.setOpaque(true);
        btnEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadoActionPerformed(evt);
            }
        });
        jPanel1.add(btnEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 780, 91, 24));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesConsultar/En este apartado se procederá a ingresar el Usuario por consultar para conseguir la información de dicho usuario.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesConsultar/Consultar Usuario.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, 30));

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesConsultar/create an account Enter here.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 860, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesConsultar/User_01.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 510, -1, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesConsultar/Label.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 690, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesConsultar/User_01.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesConsultar/Vector.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 610, 20, 20));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesConsultar/Rectangle 1573.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 1010, 760));

        jLabel1.setFont(new java.awt.Font("Segoe Script", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesConsultar/Blend Group 1.png"))); // NOI18N
        jLabel1.setToolTipText("");
        jLabel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadoActionPerformed

        actual.setEstado(!actual.getEstado());
        getTxtEstado.setText(actual.getEstadoPrint());
        if (actual.getEstado()) {
            btnEstado.setText("Desactivar");
        }else{
            btnEstado.setText("Activar");
        }

    }//GEN-LAST:event_btnEstadoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        this.actual = null;
        btnEstado.setEnabled(false);
        btnEstado.setText("");
        consultar();
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void setTxtUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_setTxtUsuarioKeyReleased

        setTxtUsuario.setForeground(Color.BLACK);
        txtErrorUser.setText("");
        this.actual = null;
        btnEstado.setEnabled(false);
        limpiar();

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            consultar();
        }

    }//GEN-LAST:event_setTxtUsuarioKeyReleased

    private void setTxtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setTxtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_setTxtUsuarioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AgregarUsuario.arranque();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void arranque() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsultarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEstado;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel getTxtEstado;
    private javax.swing.JLabel getTxtNombre;
    private javax.swing.JLabel getTxtUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField setTxtUsuario;
    private javax.swing.JLabel txtErrorUser;
    // End of variables declaration//GEN-END:variables

}
