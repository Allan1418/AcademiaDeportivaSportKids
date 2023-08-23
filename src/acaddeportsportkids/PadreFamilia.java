
package acaddeportsportkids;


import javax.swing.DefaultListModel;


public class PadreFamilia extends Deportista{
    
    //Atributos
    //private ArrayList<String> hijos;
    private DefaultListModel<String> hijos;
    private DefaultListModel<String> facturas;
    
    
    //Metodos get y set
    public DefaultListModel<String> getHijos() {
        return hijos;
    }

    public void setHijos(DefaultListModel<String> hijos) {
        this.hijos = hijos;
    }

    public DefaultListModel<String> getFacturas() {
        return facturas;
    }

    public void setFacturas(DefaultListModel<String> facturas) {
        this.facturas = facturas;
    }
    
    //metodos obsoletos
    @Deprecated
    @Override
    public String getPadreACargo() {
        return null;
    }

    @Deprecated
    @Override
    public void setPadreACargo(String padreACargo) {}

    @Deprecated
    @Override
    public String getRutina() {
        return null;
    }

    @Deprecated
    @Override
    public void setRutina(String Rutina) {}
    
    //Constructores
    public PadreFamilia(Usuario actual, String ciudad, String direccion, String telefono, String correo, DefaultListModel<String> hijos, DefaultListModel<String> facturas) {
        super(actual, ciudad, direccion, telefono, correo, null);
        this.hijos = hijos;
        this.facturas = facturas;
    }
    
    
    
    
    
    
    
}
