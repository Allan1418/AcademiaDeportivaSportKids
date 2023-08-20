
package acaddeportsportkids;

import java.util.ArrayList;


public class Rutina extends Deporte{
    
    //Atributos
    private String deporteAsoc;
    private String duraccion;
    
    //Metodos get y set

    public String getDeporteAsoc() {
        return deporteAsoc;
    }

    public void setDeporteAsoc(String deporteAsoc) {
        this.deporteAsoc = deporteAsoc;
    }

    public String getDuraccion() {
        return duraccion;
    }

    public void setDuraccion(String duraccion) {
        this.duraccion = duraccion;
    }
    
    //Metodos obsoletos
    @Deprecated
    @Override
    public ArrayList<String> getRutinas() {
        return null;
    }

    @Deprecated
    @Override
   public void setRutinas(ArrayList<String> deportes) {}

    public Rutina(String nombre, String features, boolean estado, String deporteAsoc, String duraccion) {
        super(nombre, features, estado);
        this.deporteAsoc = deporteAsoc;
        this.duraccion = duraccion;
    }
    
    
    
    
    
}
