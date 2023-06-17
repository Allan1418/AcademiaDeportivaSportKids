
package acaddeportsportkids;


import java.util.ArrayList;

public class Usuario {

    //Mejoras

    //Atributos
    private String nombre;
    private String apellidos;
    private String usuario;
    private String password;
    private boolean estado;
    
    
    //Metodos get y set

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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


    public Usuario(String nombre, String apellidos, String usuario, String password, boolean estado) {
        this.nombre = "";
        this.apellidos = "";
        this.usuario = "";
        this.password = "";
        this.estado = true;
    }
}
    
    
    //OtrosMetodos


class AlmacenamientoUsuarios {
    private ArrayList<Usuario> usuarios;

    public AlmacenamientoUsuarios() {
        usuarios = new ArrayList<>();
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario consultarUsuario(String usuario) {
        for (Usuario u : usuarios) {
            if (u.getUsuario().equals(usuario)) {
                return u;
            }
        }
        return null;
    }

    public void inactivarUsuario(String usuario) {
        Usuario usuarioEncontrado = null;
        for (Usuario u : usuarios) {
            if (u.getUsuario().equals(usuario)) {
                usuarioEncontrado = u;
                break;
            }
        }
        if (usuarioEncontrado != null) {
            // Se verifica si el usuario tiene datos en otros catalogos
            // Realizar las acciones necesarias para inactivar al usuario
            usuarioEncontrado.setEstado(false);
        }
    }
}


