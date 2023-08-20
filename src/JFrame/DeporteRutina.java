
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
            cambio.getDeportes().add(nombr);
            Comun.reempObjctArch(cambio, AcadDeportSportKids.ARCH_DEPORU);
            
            JOptionPane.showMessageDialog(null,"Datos guardados Correctamente!","Nueva Rutina!", JOptionPane.INFORMATION_MESSAGE);
            limpiar();
        
        //se agrega obj Deporte
        }else if (tipoDeporu == 1) {
            Deporte nuevo = new Deporte(nombr, carac, estado);
            nuevo.setDeportes(new ArrayList<>());
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
                
                ArrayList<String> array = reemp.getDeportes();
                array.remove(actualModificar.getNombre());
                
                reemp.setDeportes(array);
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
            if (!((Deporte) Comun.consultarArch(actualModificar.getNombre(), AcadDeportSportKids.ARCH_DEPORU)).getDeportes().isEmpty()) {
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
                
                if (deporte.getDeportes().contains(deporCorres)) {
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

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Nombre:");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("características:");

        errNombre.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        errNombre.setForeground(new java.awt.Color(255, 0, 0));

        btnDeporte.setText("Deporte");
        btnDeporte.setEnabled(false);
        btnDeporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeporteActionPerformed(evt);
            }
        });

        btnRutina.setText("Rutina");
        btnRutina.setEnabled(false);
        btnRutina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRutinaActionPerformed(evt);
            }
        });

        setTxtFeatures.setEnabled(false);

        setTxtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                setTxtNombreKeyReleased(evt);
            }
        });

        getTxtName.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Estado:");

        getTxtEstado.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("Deporte al que Corresponde:");

        setTxtDepCorres.setEnabled(false);
        setTxtDepCorres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                setTxtDepCorresKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("Duración:");

        setTxtDurac.setEnabled(false);

        btnFinal.setEnabled(false);
        btnFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalActionPerformed(evt);
            }
        });

        errDeporte.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        errDeporte.setForeground(new java.awt.Color(255, 0, 0));

        btnEstado.setEnabled(false);
        btnEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadoActionPerformed(evt);
            }
        });

        btnBuscarDepor.setText("Buscar");
        btnBuscarDepor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarDeporActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        errEstado.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        errEstado.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnDeporte, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRutina, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(errNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(setTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(errDeporte, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(getTxtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(setTxtFeatures, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(getTxtName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(setTxtDepCorres, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(setTxtDurac, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscarDepor, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(errEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(304, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(errNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeporte, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRutina, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(getTxtName, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(setTxtFeatures, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(getTxtEstado)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(setTxtDepCorres, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarDepor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errDeporte, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(setTxtDurac, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField setTxtDepCorres;
    private javax.swing.JTextField setTxtDurac;
    private javax.swing.JTextField setTxtFeatures;
    private javax.swing.JTextField setTxtNombre;
    // End of variables declaration//GEN-END:variables
}
