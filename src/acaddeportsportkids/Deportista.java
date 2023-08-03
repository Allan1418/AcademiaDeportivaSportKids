
package acaddeportsportkids;


public class Deportista extends Usuario{
    
    //Atributos
    private String ciudad;
    private String direccion;
    private String telefono;
    private String correo;
        
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

    //Constructores
    public Deportista(Usuario actual, String ciudad, String direccion, String telefono, String correo) {
        super(actual.getId(), actual.getNombre(), actual.getUser(), actual.getPassword(), actual.getEstado());
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }
    
    
    
}
