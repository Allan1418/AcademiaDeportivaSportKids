
package JFrame;

import acaddeportsportkids.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DeporteRutina extends javax.swing.JFrame {
    
    //private Deporte actualDeporte;
    private Deporte actualModificar;
    private int tipoDeporu;
    private boolean estado;
    private String deporCorres;
    private String deporAnterior;
    
    public DeporteRutina() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        btnBuscarDepor.setVisible(false);
        btnCancelar.setVisible(false);
    }
    
    public void prepararDeporu() {
        
        btnBuscar.setEnabled(false);
        btnFinal.setEnabled(true);
        Object preDeporu = Comun.consultarArch(setTxtNombre.getText(), AcadDeportSportKids.ARCH_DEPORU);
        
        if (preDeporu != null) {
            actualModificar = (Deporte) preDeporu;
            prepararModificar();
            return;
        }
        
        errNombre.setText("<html><body>No existe!<br>Seleccione un boton para crear</body></html>");
        
        btnDeporte.setEnabled(true);
        btnRutina.setEnabled(true);
        btnDeporte.setSelected(false);
        btnRutina.setSelected(false);
        
        
        
    }
    
    public void prepararCrear(){
        
        limpiarCrear();
        
        getTxtName.setText(setTxtNombre.getText());
        setTxtFeatures.setEnabled(true);
        getTxtEstado.setText("Activo");
        estado = true;
        btnEstado.setEnabled(true);
        btnEstado.setText("Desactivar");
        
        if (tipoDeporu == 2) {
            setTxtDepCorres.setEnabled(true);
            btnBuscarDepor.setVisible(true);
            setTxtDurac.setEnabled(true);
        }else{
            setTxtDepCorres.setText("No Aplica!");
            setTxtDurac.setText("No Aplica!");
        }
        
        btnFinal.setText("Crear");
        btnFinal.setEnabled(true);
    }
    
    public void agregarDeporu(){
        String carac = setTxtFeatures.getText();
        String nombr = setTxtNombre.getText();
        
        if (carac.equals("")) {
            JOptionPane.showMessageDialog(null,"Por Favor rellene las caracteristicas!","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //se agrega obj Rutina
        if (tipoDeporu == 2) {
            if (deporCorres == null) {
                JOptionPane.showMessageDialog(null,"Por Favor ingrese un Deporte valido!","Error!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String durac = setTxtDurac.getText();
            if (durac.equals("")) {
                JOptionPane.showMessageDialog(null,"Por Favor rellene el tiempo de duracion!","Error!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Rutina nuevo = new Rutina(nombr, carac, estado, deporCorres, durac);
            escribirArch(nuevo);
            
            //se agrega la referencia de rutina al obj deporte
            Deporte cambio = (Deporte) Comun.consultarArch(deporCorres, AcadDeportSportKids.ARCH_DEPORU);
            
            if (!cambio.getRutinas().contains(nombr)) {
                cambio.getRutinas().add(nombr);
                Comun.reempObjctArch(cambio, AcadDeportSportKids.ARCH_DEPORU);
            }
            
            
            JOptionPane.showMessageDialog(null,"Datos guardados Correctamente!","Nueva Rutina!", JOptionPane.INFORMATION_MESSAGE);
            limpiar();
        
        //se agrega obj Deporte
        }else if (tipoDeporu == 1) {
            Deporte nuevo = new Deporte(nombr, carac, estado);
            nuevo.setRutinas(new ArrayList<>());
            escribirArch(nuevo);
            JOptionPane.showMessageDialog(null,"Datos guardados Correctamente!","Nuevo Deporte!", JOptionPane.INFORMATION_MESSAGE);
            limpiar();
            
        }
        
    }
    
    public void escribirArch(Deporte escritura){
        if (actualModificar != null) {
            Comun.reempObjctArch( escritura, AcadDeportSportKids.ARCH_DEPORU);
            
            if ((actualModificar instanceof Rutina) && (!deporCorres.equals(deporAnterior))) {
                Deporte reemp = (Deporte) Comun.consultarArch(deporAnterior, AcadDeportSportKids.ARCH_DEPORU);
                
                ArrayList<String> array = reemp.getRutinas();
                array.remove(actualModificar.getNombre());
                
                reemp.setRutinas(array);
                Comun.reempObjctArch(reemp, AcadDeportSportKids.ARCH_DEPORU);
                
                
            }
            
            
        } else{
            Comun.agregarArch(escritura, AcadDeportSportKids.ARCH_DEPORU);
        }
    }
    
    public void prepararModificar(){
        
        btnFinal.setText("Modificar");
        getTxtName.setText(actualModificar.getNombre());
        setTxtFeatures.setText(actualModificar.getFeatures());
        getTxtEstado.setText(actualModificar.getEstadoPrint());
        
        

        if (actualModificar instanceof Rutina rutina) {
            errNombre.setText("Es una Rutina!");
            tipoDeporu = 2;
            deporCorres = rutina.getDeporteAsoc();
            setTxtDepCorres.setText(deporCorres);
            setTxtDurac.setText(rutina.getDuraccion());
            
            setTxtDepCorres.setEnabled(true);
            setTxtDepCorres.setEditable(false);
            setTxtDurac.setEnabled(true);
            setTxtDurac.setEditable(false);

        } else {
            errNombre.setText("Es un Deporte!");
            tipoDeporu = 1;
            setTxtDepCorres.setText("No Aplica!");
            setTxtDurac.setText("No Aplica!");
        }

        
        setTxtFeatures.setEnabled(true);
        setTxtFeatures.setEditable(false);
        
        
    }
    
    public void modificando(){
        btnFinal.setText("Guardar");
        btnCancelar.setVisible(true);
        
        setTxtFeatures.setEditable(true);
        
        
        if (actualModificar instanceof Rutina rutina) {
            setTxtDepCorres.setEditable(true);
            setTxtDurac.setEditable(true);
            btnBuscarDepor.setVisible(true);
            deporCorres = rutina.getDeporteAsoc();
            deporAnterior = deporCorres;
            
        } else {
            if (!((Deporte) Comun.consultarArch(actualModificar.getNombre(), AcadDeportSportKids.ARCH_DEPORU)).getRutinas().isEmpty()) {
                errEstado.setText("El Deporte tiene Relacion con Rutina");
                return;
            }
        }
        
        
        
        btnEstado.setEnabled(true);
        if (actualModificar.getEstado()) {
            estado = true;
            btnEstado.setText("Desactivar");
        } else{
            estado = false;
            btnEstado.setText("Activar");
        }
        
        
    }
    
    public void buscarDepor(){
        
        if (actualModificar != null) {
            deporAnterior = ((Rutina) actualModificar).getDeporteAsoc();
        }
        
        Object preObject = Comun.consultarArch(setTxtDepCorres.getText(), AcadDeportSportKids.ARCH_DEPORU);
        if (preObject == null) {
            errDeporte.setText("El deporte No existe!");
            return;
        }
        if (preObject instanceof Rutina) {
            errDeporte.setText("Es una Rutina!");
            return;
        }
        if (preObject instanceof Deporte deporte) {
            if (!deporte.getEstado()) {
                errDeporte.setText("El deporte esta Inactivo!");
            }else{
                
                if (deporte.getRutinas().contains(deporCorres)) {
                    deporAnterior = deporCorres;
                }
                
                deporCorres = setTxtDepCorres.getText();
                errDeporte.setText("Deporte Aceptado!");
            }
        }
        
    }
    
    public void limpiar(){
        actualModificar = null;
        deporCorres = null;
        deporAnterior = null;
        tipoDeporu = 0;
        
        btnBuscar.setEnabled(true);
        btnFinal.setEnabled(false);
        btnFinal.setText("");
        
        btnDeporte.setEnabled(false);
        btnRutina.setEnabled(false);
        
        errNombre.setText("");
        getTxtName.setText("");
        
        setTxtFeatures.setEditable(true);
        setTxtDepCorres.setEditable(true);
        setTxtDurac.setEditable(true);
        
        btnCancelar.setVisible(false);
        errEstado.setText("");
        
        
        limpiarCrear();
        
    }
    
    public void limpiarCrear(){
        setTxtFeatures.setText("");
        setTxtFeatures.setEnabled(false);
        
        estado = true;
        getTxtEstado.setText("");
        btnEstado.setEnabled(false);
        btnEstado.setText("");
        
        btnFinal.setEnabled(false);
        btnFinal.setText("");
        
        setTxtDepCorres.setEnabled(false);
        errDeporte.setText("");
        btnBuscarDepor.setVisible(false);
        deporCorres = null;
        
        setTxtDurac.setEnabled(false);
        setTxtDepCorres.setText("");
        setTxtDurac.setText("");
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        errNombre = new javax.swing.JLabel();
        btnDeporte = new javax.swing.JToggleButton();
        btnRutina = new javax.swing.JToggleButton();
        setTxtFeatures = new javax.swing.JTextField();
        setTxtNombre = new javax.swing.JTextField();
        getTxtName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        getTxtEstado = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        setTxtDepCorres = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        setTxtDurac = new javax.swing.JTextField();
        btnFinal = new javax.swing.JButton();
        errDeporte = new javax.swing.JLabel();
        btnEstado = new javax.swing.JButton();
        btnBuscarDepor = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        errEstado = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 36, 88, 32));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Nombre:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 54, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("características:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 233, -1, -1));

        errNombre.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        errNombre.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(errNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 216, 42));

        btnDeporte.setText("Deporte");
        btnDeporte.setEnabled(false);
        btnDeporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeporteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDeporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 95, 32));

        btnRutina.setText("Rutina");
        btnRutina.setEnabled(false);
        btnRutina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRutinaActionPerformed(evt);
            }
        });
        jPanel1.add(btnRutina, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 140, 95, 32));

        setTxtFeatures.setEnabled(false);
        jPanel1.add(setTxtFeatures, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 227, 181, 32));

        setTxtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setTxtNombreActionPerformed(evt);
            }
        });
        setTxtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                setTxtNombreKeyReleased(evt);
            }
        });
        jPanel1.add(setTxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 35, 177, 32));

        getTxtName.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(getTxtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 190, 181, 25));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Estado:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 271, -1, -1));

        getTxtEstado.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(getTxtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 271, 87, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("Deporte al que Corresponde:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 360, -1, -1));

        setTxtDepCorres.setEnabled(false);
        setTxtDepCorres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                setTxtDepCorresKeyReleased(evt);
            }
        });
        jPanel1.add(setTxtDepCorres, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 354, 181, 32));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("Duración:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 448, -1, -1));

        setTxtDurac.setEnabled(false);
        jPanel1.add(setTxtDurac, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 442, 181, 32));

        btnFinal.setEnabled(false);
        btnFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalActionPerformed(evt);
            }
        });
        jPanel1.add(btnFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 503, 88, 32));

        errDeporte.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        errDeporte.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(errDeporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 393, 214, 24));

        btnEstado.setEnabled(false);
        btnEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadoActionPerformed(evt);
            }
        });
        jPanel1.add(btnEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 271, 88, 32));

        btnBuscarDepor.setText("Buscar");
        btnBuscarDepor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarDeporActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarDepor, new org.netbeans.lib.awtextra.AbsoluteConstraints(441, 355, 88, 32));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 503, 88, 32));

        errEstado.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        errEstado.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(errEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 309, 271, 24));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesRutinaDeporte/Ellipse 3.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, -1, 580));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesRutinaDeporte/Ellipse 1.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscarDeporActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarDeporActionPerformed
        errDeporte.setText("");
        buscarDepor();

    }//GEN-LAST:event_btnBuscarDeporActionPerformed

    private void btnEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadoActionPerformed

        if (estado) {
            estado = false;
            btnEstado.setText("Activar");
            getTxtEstado.setText("Inactivo");
        }else{
            estado = true;
            btnEstado.setText("Desactivar");
            getTxtEstado.setText("Activo");
        }
    }//GEN-LAST:event_btnEstadoActionPerformed

    private void btnFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalActionPerformed

        switch (btnFinal.getText()) {
            case "Crear":
            agregarDeporu();
            break;
            case "Modificar":
            modificando();
            break;
            case "Guardar":
            agregarDeporu();
            break;
            default:
            break;
        }
    }//GEN-LAST:event_btnFinalActionPerformed

    private void setTxtDepCorresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_setTxtDepCorresKeyReleased

        deporCorres = null;
        errDeporte.setText("");
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buscarDepor();
        }

    }//GEN-LAST:event_setTxtDepCorresKeyReleased

    private void setTxtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_setTxtNombreKeyReleased
        limpiar();

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            prepararDeporu();
        }
    }//GEN-LAST:event_setTxtNombreKeyReleased

    private void btnRutinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRutinaActionPerformed
        btnDeporte.setSelected(false);
        tipoDeporu = 2;
        prepararCrear();
    }//GEN-LAST:event_btnRutinaActionPerformed

    private void btnDeporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeporteActionPerformed

        btnRutina.setSelected(false);
        tipoDeporu = 1;
        prepararCrear();
    }//GEN-LAST:event_btnDeporteActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        prepararDeporu();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void setTxtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setTxtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_setTxtNombreActionPerformed

    
    public static void arranque() {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DeporteRutina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeporteRutina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeporteRutina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeporteRutina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeporteRutina().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarDepor;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JToggleButton btnDeporte;
    private javax.swing.JButton btnEstado;
    private javax.swing.JButton btnFinal;
    private javax.swing.JToggleButton btnRutina;
    private javax.swing.JLabel errDeporte;
    private javax.swing.JLabel errEstado;
    private javax.swing.JLabel errNombre;
    private javax.swing.JLabel getTxtEstado;
    private javax.swing.JLabel getTxtName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField setTxtDepCorres;
    private javax.swing.JTextField setTxtDurac;
    private javax.swing.JTextField setTxtFeatures;
    private javax.swing.JTextField setTxtNombre;
    // End of variables declaration//GEN-END:variables
}
