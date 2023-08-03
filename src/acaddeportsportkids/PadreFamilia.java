
package acaddeportsportkids;

import java.util.ArrayList;


public class PadreFamilia extends Deportista{
    
    //Atributos
    private ArrayList<String> hijos;

    
    //Metodos get y set
    public ArrayList<String> getHijos() {
        return hijos;
    }

    public void setHijos(ArrayList<String> hijos) {
        this.hijos = hijos;
    }

    
    //Constructores
    public PadreFamilia(Usuario actual, String ciudad, String direccion, String telefono, String correo, ArrayList<String> hijos) {
        super(actual, ciudad, direccion, telefono, correo);
        this.hijos = hijos;
    }
    
    
    
    
    
    
    
}
