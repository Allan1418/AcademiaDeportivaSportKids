
package acaddeportsportkids;

import javax.swing.JOptionPane;


public class AcadDeportSportKids {
    //Metodo principal
    public static void main(String[] args) {


        //arranque del sistema
        menu();
    }
    //Metodos menu
    public static void menu(){
        AlmacenamientoUsuarios almacenamiento = new AlmacenamientoUsuarios();
        String[] botones = {"agregar Usuario", "Consultar Usuario", "Inactivar un Usuario", "Op4", "SALIR"};
        int opcion;
        OUTER:
        while (true) {
            opcion = JOptionPane.showOptionDialog(null,
                    "MENU PRINCIPAL",
                    "Menu temporal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, 
                    null,
                    botones, botones[1]);
            
            switch (opcion) {
                case 0:
                    op1();

                    String nombre= JOptionPane.showInputDialog("Ingrese su nombre: ");

                    String apellidos=JOptionPane.showInputDialog("Ingrese sus apellidos: ");

                    String usuario=JOptionPane.showInputDialog("Ingrese su nombre de usuario: ");

                    String password=JOptionPane.showInputDialog("Ingrese su contraseña: ");

                    Usuario usuarioNuevo = new Usuario(nombre, apellidos, usuario, password, true);
                    almacenamiento.agregarUsuario(usuarioNuevo);

                    JOptionPane.showMessageDialog(null,"!Usuario agregado correctamente");

                    break;
                case 1:
                    //insetar funcion
                    String consultarUsuario = JOptionPane.showInputDialog("!Digite el usuario por consultar: ");
                    Usuario consultado = almacenamiento.consultarUsuario(consultarUsuario);

                    if (consultado != null) {
                        JOptionPane.showMessageDialog(null,"Usuario encontrado \n"
                                + consultado.getNombre() + " " + consultado.getApellidos() + " \n"
                                + consultado.getUsuario() + "\n"+consultado.isEstado(),"Usuario encontrado: ",JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null,"Ingrese un usuario que se haya registrado o ingrese correctamente el nombre.",
                                "¡Usuario no encontrado!" ,JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 2:
                    //insetar funcion
                    String buscarUsuario = JOptionPane.showInputDialog("!Digite el usuario que deseas inactivar: ");
                    almacenamiento.inactivarUsuario(buscarUsuario);
                    if (buscarUsuario != null) {
                        JOptionPane.showMessageDialog(null,"Usuario encontrado",
                                "El estado del usuario se cambio correctamente",JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Ingrese un usuario que se haya registrado o ingrese correctamente el nombre.",
                                "¡Usuario no encontrado!" ,JOptionPane.ERROR_MESSAGE);
                    }
                break;
                case 3:
                    //insetar funcion
                    break;
                default:
                    break OUTER;
            }
            
        }
    }
    
    
    //Metodos de opcion
    public static void op1() {
        
    }
    
    
    //OtrosMetodos
    
    
    
    
    
    
    
}
