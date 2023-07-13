
package acaddeportsportkids;
import java.util.ArrayList;

public class Usuario {

    //Mejoras

    //Atributos
    private int id;
    private String nombre;
    private String apellido;
    private String usuario;
    private String password;
    private boolean estado;

    public int getId() {
        return id;
    }

    //Metodos get y set
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellidos) {
        this.apellido = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    //Constructores


    public Usuario(int id,String nombre, String apellido, String usuario, String password, boolean estado) {
        this.id=id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.password = password;
        this.estado = estado;
    }
}