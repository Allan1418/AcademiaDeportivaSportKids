
package JFrame;

import acaddeportsportkids.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;




public class CrearCliente extends javax.swing.JFrame {

    private Usuario actualUsuario;
    private Deportista actualModificar;
    private int tipoCliente = 0;
    DefaultListModel<String> modelo = new DefaultListModel<>();
    
    public CrearCliente() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        btnCancelar.setVisible(false);
        
    }

    public void agregarCliente(){
        
        String cid = setTextCiudad.getText();
        String direc = SetTextDirec.getText();
        String tel = SetTextTel.getText();
        String mail = SetTextmail.getText();
        
        
        if (cid.isEmpty() || direc.isEmpty() || tel.isEmpty() || mail.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Por Favor rellene todos los datos!","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (tipoCliente == 0) {
            JOptionPane.showMessageDialog(null,"Por Favor seleccione un tipo de Cliente!","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (tipoCliente == 1) {
            Deportista depor = new Deportista(actualUsuario, cid, direc, tel, mail);
            Comun.reempObjctArch(depor, AcadDeportSportKids.ARCH_USUARIOS);
            Comun.reempUsuarioArray(depor);
            JOptionPane.showMessageDialog(null,"Nuevo Deportista creado con exito!","Nuevo Cliente!", JOptionPane.INFORMATION_MESSAGE);
            limpiar();
            return;
        }
        
        if (tipoCliente == 2) {
            if (modelo.isEmpty()) {
                JOptionPane.showMessageDialog(null,"Por Favor seleccione al menos un Hijo a cargo!","Error!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            PadreFamilia padre = new PadreFamilia(actualUsuario, cid, direc, tel, direc, modelo);
            Comun.reempObjctArch(padre, AcadDeportSportKids.ARCH_USUARIOS);
            Comun.reempUsuarioArray(padre);
            
            
            for (int i = 0; i < modelo.size(); i++) {
                Deportista reempl = (Deportista) Comun.consultarArch(modelo.get(i), AcadDeportSportKids.ARCH_USUARIOS);
                reempl.setPadreACargo(actualUsuario.getNombre());
                Comun.reempObjctArch(reempl, AcadDeportSportKids.ARCH_USUARIOS);
                
            }
            
            JOptionPane.showMessageDialog(null,"Nuevo Padre de Familia creado con exito!","Nuevo Cliente!", JOptionPane.INFORMATION_MESSAGE);
            limpiar();
            return;
            
        }
        
    }
    
    public void prepararUsuario(){
        
        btnUser.setEnabled(false);
        Object preUsuario = Comun.consultarArch(setTextUser.getText(), AcadDeportSportKids.ARCH_USUARIOS); 
        
        if (preUsuario == null) {
            txterrUser.setText("No existe el usuario!");
            return;
        }
        actualUsuario = (Usuario) preUsuario;
        getTxtId.setText(actualUsuario.getId());
        getTxtNombre.setText(actualUsuario.getNombre());
        
        
        if (!actualUsuario.getEstado()) {
            txterrUser.setText("El usuario esta inactivo");
            return;
        }
        
        
        if (actualUsuario instanceof Deportista) {
            actualModificar = (Deportista) actualUsuario;
            if (actualUsuario instanceof PadreFamilia) {
                txterrUser.setText("El usuario es un Padre de Familia!");
            } else{
                txterrUser.setText("El usuario es un Deportista!");
            }
            prepararModificar();
            
            return;
        }
        
        setTextCiudad.setEnabled(true);
        SetTextDirec.setEnabled(true);
        SetTextTel.setEnabled(true);
        SetTextmail.setEnabled(true);
        btnDeportista.setEnabled(true);
        btnPadreFamilia.setEnabled(true);
        btnPadreFamilia.setSelected(false);
        btnDeportista.setSelected(false);
        
        setTextCiudad.setEditable(true);
        SetTextDirec.setEditable(true);
        SetTextTel.setEditable(true);
        SetTextmail.setEditable(true);
        
        btnFinal.setEnabled(true);
        btnFinal.setText("Crear");
    }
    
    public void prepararModificar() {
        btnFinal.setText("Modificar");
        btnFinal.setEnabled(true);
        
        setTextCiudad.setEnabled(true);
        SetTextDirec.setEnabled(true);
        SetTextTel.setEnabled(true);
        SetTextmail.setEnabled(true);
        
        setTextCiudad.setEditable(false);
        SetTextDirec.setEditable(false);
        SetTextTel.setEditable(false);
        SetTextmail.setEditable(false);
        
        setTextCiudad.setText(actualModificar.getCiudad());
        SetTextDirec.setText(actualModificar.getDireccion());
        SetTextTel.setText(actualModificar.getTelefono());
        SetTextmail.setText(actualModificar.getCorreo());
        
        if (actualModificar instanceof PadreFamilia) {
            listaHijosDisplay.setEnabled(true);
            modelo = ((PadreFamilia) actualModificar).getHijos();
            listaHijosDisplay.setModel(modelo);
        } else{
            getTxtPadreCargo.setText("Padre a cargo: " + actualModificar.getPadreACargo());
        }
        
        
    }
    
    public void modificando(){
        btnFinal.setText("Guardar");
        btnCancelar.setVisible(true);
        btnCancelar.requestFocus();
        
        setTextCiudad.setEditable(true);
        SetTextDirec.setEditable(true);
        SetTextTel.setEditable(true);
        SetTextmail.setEditable(true);
        
        if (actualModificar instanceof PadreFamilia) {
            setTxtHijoCargo.setEnabled(true);
            btnAgregarHijo.setEnabled(true);
            btnQuitarHijo.setEnabled(true);
            tipoCliente = 2;
        } else{
            tipoCliente = 1;
        }
        
    }
    
    public void agregarHijo(){
        
        String preHijo = setTxtHijoCargo.getText();
        if (actualUsuario.getUser().equals(preHijo)) {
            txterrHijo.setText("Es el mismo Usuario!");
            return;
        }
        
        for (int i = 0; i < modelo.size(); i++) {
            if (modelo.get(i).equals(preHijo)) {
                txterrHijo.setText("El Deportista ya se agrego!");
                return;
            }
        }
        
        Object preUsuario = Comun.consultarArch(preHijo, AcadDeportSportKids.ARCH_USUARIOS); 
        
        if (preUsuario == null) {
            txterrHijo.setText("No existe el Deportista!");
            return;
        }
        

        if (preUsuario instanceof Deportista preDepor) {
            if (preDepor instanceof PadreFamilia) {
                txterrHijo.setText("El Usuario es un Padre de Familia!");
                return;
            }
            if (!preDepor.getPadreACargo().isEmpty()) {
                txterrHijo.setText("Ya tiene un Padre de Familia!");
                return;
            }
            modelo.addElement(preHijo);
            setTxtHijoCargo.setText("");
            
        } else{
            txterrHijo.setText("El Usuario No es un Deportista!");
        }
        
        
        
        
    }
    
    public void limpiar(){
        
        btnUser.setEnabled(true);
        txterrUser.setText("");
        getTxtId.setText("");
        getTxtNombre.setText("");
        
        setTextCiudad.setText("");
        setTextCiudad.setEnabled(false);
        SetTextDirec.setText("");
        SetTextDirec.setEnabled(false);
        SetTextTel.setText("");
        SetTextTel.setEnabled(false);
        SetTextmail.setText("");
        SetTextmail.setEnabled(false);
        
        btnDeportista.setEnabled(false);
        btnPadreFamilia.setEnabled(false);
        getTxtPadreCargo.setText("");
        
        tipoCliente = 0;
        btnFinal.setEnabled(false);
        btnFinal.setText("");
        
        btnCancelar.setVisible(false);
        
        
        limpiarHijos();
    }
    
    public void limpiarHijos(){
        setTxtHijoCargo.setText("");
        setTxtHijoCargo.setEnabled(false);
        btnAgregarHijo.setEnabled(false);
        btnQuitarHijo.setEnabled(false);
        
        listaHijosDisplay.setEnabled(false);
        modelo = new DefaultListModel<>();
        listaHijosDisplay.setModel(modelo);
        
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnUser = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnDeportista = new javax.swing.JToggleButton();
        btnPadreFamilia = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        getTxtNombre = new javax.swing.JLabel();
        getTxtId = new javax.swing.JLabel();
        SetTextDirec = new javax.swing.JTextField();
        SetTextTel = new javax.swing.JTextField();
        SetTextmail = new javax.swing.JTextField();
        setTxtHijoCargo = new javax.swing.JTextField();
        setTextCiudad = new javax.swing.JTextField();
        setTextUser = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaHijosDisplay = new javax.swing.JList<>();
        btnAgregarHijo = new javax.swing.JButton();
        btnQuitarHijo = new javax.swing.JButton();
        txterrHijo = new javax.swing.JLabel();
        txterrUser = new javax.swing.JLabel();
        btnFinal = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        getTxtPadreCargo = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnUser.setBackground(new java.awt.Color(255, 255, 255));
        btnUser.setText("Buscar");
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });
        jPanel1.add(btnUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 120, 30));

        jLabel3.setBackground(new java.awt.Color(204, 255, 204));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesEdit/logo.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, -1, -1));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, 20));

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("User:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel1.setForeground(new java.awt.Color(153, 102, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesEdit/Edición de Catálogos  Ingrese los cambios que deseas realizar al catalogo.png"))); // NOI18N
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 380, 100));

        btnDeportista.setText("Deportista");
        btnDeportista.setEnabled(false);
        btnDeportista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeportistaActionPerformed(evt);
            }
        });
        jPanel1.add(btnDeportista, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 110, -1));

        btnPadreFamilia.setText("Padre de Familia");
        btnPadreFamilia.setEnabled(false);
        btnPadreFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPadreFamiliaActionPerformed(evt);
            }
        });
        jPanel1.add(btnPadreFamilia, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, -1, -1));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("ID:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, 20));

        getTxtNombre.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(getTxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 170, 20));

        getTxtId.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(getTxtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 170, 20));

        SetTextDirec.setEnabled(false);
        jPanel1.add(SetTextDirec, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 170, -1));

        SetTextTel.setEnabled(false);
        SetTextTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SetTextTelActionPerformed(evt);
            }
        });
        jPanel1.add(SetTextTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 170, -1));

        SetTextmail.setEnabled(false);
        jPanel1.add(SetTextmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 170, -1));

        setTxtHijoCargo.setEnabled(false);
        setTxtHijoCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setTxtHijoCargoActionPerformed(evt);
            }
        });
        setTxtHijoCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                setTxtHijoCargoKeyReleased(evt);
            }
        });
        jPanel1.add(setTxtHijoCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 160, -1));

        setTextCiudad.setEnabled(false);
        setTextCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setTextCiudadActionPerformed(evt);
            }
        });
        jPanel1.add(setTextCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 170, -1));

        setTextUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                setTextUserKeyReleased(evt);
            }
        });
        jPanel1.add(setTextUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 180, -1));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Direccion:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Ciudad:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Telefono:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Correo:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        listaHijosDisplay.setEnabled(false);
        jScrollPane2.setViewportView(listaHijosDisplay);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 400, 160, 150));

        btnAgregarHijo.setText("Agregar");
        btnAgregarHijo.setEnabled(false);
        btnAgregarHijo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarHijoActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarHijo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 340, 80, -1));

        btnQuitarHijo.setText("Quitar");
        btnQuitarHijo.setEnabled(false);
        btnQuitarHijo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarHijoActionPerformed(evt);
            }
        });
        jPanel1.add(btnQuitarHijo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 400, 80, -1));

        txterrHijo.setForeground(new java.awt.Color(153, 0, 0));
        jPanel1.add(txterrHijo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, 200, 20));

        txterrUser.setForeground(new java.awt.Color(153, 0, 0));
        jPanel1.add(txterrUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 210, 20));

        btnFinal.setEnabled(false);
        btnFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalActionPerformed(evt);
            }
        });
        jPanel1.add(btnFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 530, 80, 30));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, 80, 30));

        getTxtPadreCargo.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(getTxtPadreCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 130, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 871, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SetTextTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SetTextTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SetTextTelActionPerformed

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed

        prepararUsuario();
    }//GEN-LAST:event_btnUserActionPerformed

    private void setTextCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setTextCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_setTextCiudadActionPerformed

    private void setTxtHijoCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setTxtHijoCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_setTxtHijoCargoActionPerformed

    private void btnQuitarHijoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarHijoActionPerformed
        
        int index = listaHijosDisplay.getSelectedIndex();
        if (index != -1) {
            modelo.remove(index);
        }
    }//GEN-LAST:event_btnQuitarHijoActionPerformed
    
    private void btnAgregarHijoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarHijoActionPerformed

        agregarHijo();
        
    }//GEN-LAST:event_btnAgregarHijoActionPerformed

    private void setTextUserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_setTextUserKeyReleased
        
        limpiar();
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            prepararUsuario();
        }

        
        
    }//GEN-LAST:event_setTextUserKeyReleased

    private void btnPadreFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPadreFamiliaActionPerformed
        btnDeportista.setSelected(false);
        tipoCliente = 2;
        
        setTxtHijoCargo.setEnabled(true);
        btnAgregarHijo.setEnabled(true);
        btnQuitarHijo.setEnabled(true);
        listaHijosDisplay.setEnabled(true);
        
        listaHijosDisplay.setModel(modelo);
        
        
    }//GEN-LAST:event_btnPadreFamiliaActionPerformed

    private void btnDeportistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeportistaActionPerformed
        btnPadreFamilia.setSelected(false);
        
        tipoCliente = 1;
        
        limpiarHijos();
        
        
    }//GEN-LAST:event_btnDeportistaActionPerformed

    private void setTxtHijoCargoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_setTxtHijoCargoKeyReleased
        
        txterrHijo.setText("");
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            agregarHijo();
        }
        
    }//GEN-LAST:event_setTxtHijoCargoKeyReleased

    private void btnFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalActionPerformed
        
        switch (btnFinal.getText()) {
            case "Crear":
                agregarCliente();
                break;
            case "Modificar":
                modificando();
                break;
            case "Guardar":
                agregarCliente();
                break;
            default:
                break;
        }
        
    }//GEN-LAST:event_btnFinalActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(CrearCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField SetTextDirec;
    private javax.swing.JTextField SetTextTel;
    private javax.swing.JTextField SetTextmail;
    private javax.swing.JButton btnAgregarHijo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JToggleButton btnDeportista;
    private javax.swing.JButton btnFinal;
    private javax.swing.JToggleButton btnPadreFamilia;
    private javax.swing.JButton btnQuitarHijo;
    private javax.swing.JButton btnUser;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel getTxtId;
    private javax.swing.JLabel getTxtNombre;
    private javax.swing.JLabel getTxtPadreCargo;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listaHijosDisplay;
    private javax.swing.JTextField setTextCiudad;
    private javax.swing.JTextField setTextUser;
    private javax.swing.JTextField setTxtHijoCargo;
    private javax.swing.JLabel txterrHijo;
    private javax.swing.JLabel txterrUser;
    // End of variables declaration//GEN-END:variables
}
