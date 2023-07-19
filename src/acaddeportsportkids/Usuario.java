
package acaddeportsportkids;


public class Usuario {

    //Mejoras

    //Atributos
    private String id;
    private String nombre;
    private String user;
    private char[] password;
    private boolean estado;
    
    //Metodos get y set
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
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

    //Constructores
    public Usuario(String id, String nombre, String user, char[] password, boolean estado) {
        this.id=id;
        this.nombre = nombre;
        this.user = user;
        this.password = password;
        this.estado = estado;
    }
}