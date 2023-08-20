
package acaddeportsportkids;

import java.io.Serializable;
import java.util.ArrayList;


public class Deporte implements Serializable{
    
    //Atributos
    private String nombre;
    private String features;
    private boolean estado;
    
    //Atributos exclusivos
    private ArrayList<String> rutinas;
    
    //Metodos get y set

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public boolean getEstado() {
        return estado;
    }
    
    public String getEstadoPrint() {
        if (this.estado) {
           return "Activo";
        }
        return "Inactivo";
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    //Metodo exclusivos

    public ArrayList<String> getRutinas() {
        return rutinas;
    }

    public void setRutinas(ArrayList<String> rutinas) {
        this.rutinas = rutinas;
    }
    
    
    //Constructor

    public Deporte(String nombre, String features, boolean estado) {
        this.nombre = nombre;
        this.features = features;
        this.estado = estado;
        this.rutinas = null;
    }
    
    
}
