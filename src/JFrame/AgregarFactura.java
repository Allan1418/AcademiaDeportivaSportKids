package JFrame;

import acaddeportsportkids.AcadDeportSportKids;
import acaddeportsportkids.Comun;
import static acaddeportsportkids.Comun.consultarArch;
import acaddeportsportkids.Deporte;
import acaddeportsportkids.Deportista;
import acaddeportsportkids.Factura;
import acaddeportsportkids.PadreFamilia;
import acaddeportsportkids.Rutina;
import acaddeportsportkids.Usuario;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author anyelo
 */
public class AgregarFactura extends javax.swing.JFrame {

    /**
     * Creates new form AgregarFactura
     */
    
    DefaultListModel<String> modelo = new DefaultListModel<>();
    DefaultListModel<String> modeloFacturas = new DefaultListModel<>();

    private Usuario actualUsuario;
    private Factura actualFactura;
    private int tipoCliente = 0;
    final static double COSTOBASE = 10000;
    private String fechacomp;

    public AgregarFactura() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        btnCancelar.setVisible(false);
        btnMostrarDatos.setVisible(false);

    }

    public void agregarFactura() {
        Calendar fecha_actual = new GregorianCalendar();
        
        String codigoFactura;

        String año = Integer.toString(fecha_actual.get(Calendar.YEAR));
        String mes = Integer.toString(fecha_actual.get(Calendar.MONTH));
        String dia = Integer.toString(fecha_actual.get(Calendar.DATE));
        String fechacomp = año + "-" + mes + "-" + dia;

        double total = 0;

        if (tipoCliente == 0) {
            getTxtId.setText(actualUsuario.getId());
            getTxtNombre.setText(actualUsuario.getNombre());
            codigoFactura = actualUsuario.getUser() + "_" + mes;
            setTxtCodigo.setText(codigoFactura);
            total = COSTOBASE * modelo.size();
            setTextMonto.setText(String.valueOf((total)));
            for (int i = 0; i < modeloFacturas.size(); i++) {
                if (modeloFacturas.get(i).equals(codigoFactura)) {
                    JOptionPane.showMessageDialog(null, "Ya hay una factura para este mes!", "Factura Cancelada!", JOptionPane.ERROR_MESSAGE);
                    limpiar();
                    return;
                }
            }

            String descripcion = "<html><body>";

            for (int i = 0; i < modelo.size(); i++) {
                descripcion += modelo.get(i);
                descripcion += "-";
                descripcion += ((Deportista) consultarArch(modelo.get(i), AcadDeportSportKids.ARCH_USUARIOS)).getRutina();
                descripcion += "<br>";
            }

            descripcion += "</body></html>";

            Factura fac = new Factura(codigoFactura, fechacomp, total, descripcion);
            Comun.agregarArch(fac, AcadDeportSportKids.ARCH_FACTURA);

            PadreFamilia cambio = (PadreFamilia) Comun.consultarArch(actualUsuario.getUser(), AcadDeportSportKids.ARCH_USUARIOS);
            cambio.getFacturas().add(0, codigoFactura);
            Comun.reempObjctArch(cambio, AcadDeportSportKids.ARCH_USUARIOS);

            JOptionPane.showMessageDialog(null, "Factura Creada correctamente!", "Nueva Factura!", JOptionPane.INFORMATION_MESSAGE);

            limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo agregar la factura cierre y vuelva a abrir!", "Factura no creada!", JOptionPane.INFORMATION_MESSAGE);
            limpiar();
            return;
        }
    }

    public void prepararFactura() {

        btnUser.setEnabled(false);
        Object preUsuario = Comun.consultarArch(setTextUser.getText(), AcadDeportSportKids.ARCH_USUARIOS);

        if (preUsuario == null) {
            txterrUser.setText("No existe el usuario!");
            return;
        }
        actualUsuario = (Usuario) preUsuario;
        txterrUser.setText("El usuario no esta registrado como cliente");

        if (!actualUsuario.getEstado()) {
            txterrUser.setText("El usuario esta inactivo");
            return;
        }

        if (actualUsuario instanceof Deportista) {
            txterrUser.setText("El cliente no puede ser un deportista");

            if (actualUsuario instanceof PadreFamilia) {

                txterrUser.setText("El cliente si es un Padre de Familia!");
                btnCancelar.setVisible(true);
                btnMostrarDatos.setEnabled(true);
                btnMostrarDatos.setVisible(true);
                btnFinal.setEnabled(true);
                btnFinal.setText("Crear");
                listCodigos.setEnabled(true);
                modelo = ((PadreFamilia) actualUsuario).getHijos();
                modeloFacturas = ((PadreFamilia) actualUsuario).getFacturas();
                listCodigos.setModel(modeloFacturas);

            }
        }
    }

    public void limpiar() {

        listCodigos.setEnabled(false);

        modelo = new DefaultListModel<>();
        modeloFacturas = new DefaultListModel<>();

        listCodigos.setModel(modeloFacturas);
        actualFactura = null;

        btnUser.setEnabled(true);
        setTextDescripcion.setText("");
        txterrUser.setText("");
        getTxtNombre.setText("");
        getTxtId.setText("");
        setTextFecha.setText("");
        setTextMonto.setText("");
        setTxtCodigo.setText("");

        btnFinal.setEnabled(false);
        btnFinal.setText("");

        btnCancelar.setVisible(false);
        btnMostrarDatos.setVisible(false);

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
        btnUser = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        setTextFecha = new javax.swing.JLabel();
        getTxtId = new javax.swing.JLabel();
        setTextUser = new javax.swing.JTextField();
        txterrUser = new javax.swing.JLabel();
        btnFinal = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        getTxtNombre = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        setTextMonto = new javax.swing.JLabel();
        setTxtCodigo = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listCodigos = new javax.swing.JList<>();
        btnMostrarDatos = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        setTextDescripcion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setFocusCycleRoot(true);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnUser.setBackground(new java.awt.Color(153, 153, 153));
        btnUser.setText("Buscar");
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });
        jPanel1.add(btnUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 120, 40));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, 20));

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("User:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, -1));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("ID:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, 20));

        setTextFecha.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(setTextFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 460, 170, 20));

        getTxtId.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(getTxtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 170, 20));

        setTextUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setTextUserActionPerformed(evt);
            }
        });
        setTextUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                setTextUserKeyReleased(evt);
            }
        });
        jPanel1.add(setTextUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 180, -1));

        txterrUser.setForeground(new java.awt.Color(153, 0, 0));
        jPanel1.add(txterrUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 250, 20));

        btnFinal.setEnabled(false);
        btnFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalActionPerformed(evt);
            }
        });
        jPanel1.add(btnFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 710, 80, 30));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 180, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 710, 80, 30));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Fecha:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, 20));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Descripcion");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, -1, -1));

        getTxtNombre.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(getTxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 170, 20));

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("monto");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 640, -1, -1));

        setTextMonto.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(setTextMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 640, 120, 20));
        jPanel1.add(setTxtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 50, 30));

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Codigo Factura");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        jLabel3.setBackground(new java.awt.Color(255, 153, 102));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Facturacion");
        jLabel3.setToolTipText("");
        jLabel3.setAutoscrolls(true);
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel3.setFocusable(false);
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel3.setName(""); // NOI18N
        jLabel3.setOpaque(true);
        jLabel3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 30));

        jScrollPane1.setViewportView(listCodigos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 150, 150));

        btnMostrarDatos.setText("Mostrar Datos");
        btnMostrarDatos.setEnabled(false);
        btnMostrarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarDatosActionPerformed(evt);
            }
        });
        jPanel1.add(btnMostrarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 120, 30));

        setTextDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(setTextDescripcion);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 500, 190, 110));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed

        prepararFactura();
    }//GEN-LAST:event_btnUserActionPerformed

    private void setTextUserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_setTextUserKeyReleased

        limpiar();

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            prepararFactura();
        }
        btnFinal.setEnabled(false);

    }//GEN-LAST:event_setTextUserKeyReleased

    private void setTextUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setTextUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_setTextUserActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalActionPerformed

        switch (btnFinal.getText()) {
            case "Crear":
                agregarFactura();
                break;
            default:
                break;
        }

        tipoCliente = 1;
    }//GEN-LAST:event_btnFinalActionPerformed

    private void btnMostrarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarDatosActionPerformed

        Object preFactura = Comun.consultarArch(listCodigos.getSelectedValue(), AcadDeportSportKids.ARCH_FACTURA);

        if (preFactura == null) {
            return;
        }

        actualFactura = (Factura) preFactura;

        getTxtId.setText(actualUsuario.getId());
        getTxtNombre.setText(actualUsuario.getNombre());
        setTextDescripcion.setText(actualFactura.getDescripcion());
        setTextFecha.setText(actualFactura.getFecha());
        setTextMonto.setText(String.valueOf(actualFactura.getMonto()));

    }//GEN-LAST:event_btnMostrarDatosActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarFactura.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarFactura.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarFactura.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarFactura.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarFactura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFinal;
    private javax.swing.JButton btnMostrarDatos;
    private javax.swing.JButton btnUser;
    private javax.swing.JLabel getTxtId;
    private javax.swing.JLabel getTxtNombre;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listCodigos;
    private javax.swing.JLabel setTextDescripcion;
    private javax.swing.JLabel setTextFecha;
    private javax.swing.JLabel setTextMonto;
    private javax.swing.JTextField setTextUser;
    private javax.swing.JLabel setTxtCodigo;
    private javax.swing.JLabel txterrUser;
    // End of variables declaration//GEN-END:variables
}
