
package acaddeportsportkids;

import java.util.ArrayList;


public class Deportista extends Usuario{
    
    //Atributos
    private String ciudad;
    private String direccion;
    private String telefono;
    private String correo;
    
    //Atributos exclusivos
    private String padreACargo;
    private String Rutina;
        
    //Metodos get y set
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    //get y set exclusivos
    public String getPadreACargo() {
        return padreACargo;
    }

    public void setPadreACargo(String padreACargo) {
        this.padreACargo = padreACargo;
    }

    public String getRutina() {
        return Rutina;
    }

    public void setRutina(String Rutina) {
        this.Rutina = Rutina;
    }
    
    
    

    //Constructores
    public Deportista(Usuario actual, String ciudad, String direccion, String telefono, String correo) {
        super(actual.getId(), actual.getNombre(), actual.getUser(), actual.getPassword(), actual.getEstado());
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        
        this.padreACargo = "";
        this.Rutina = "";
    }
    
    
    
}
