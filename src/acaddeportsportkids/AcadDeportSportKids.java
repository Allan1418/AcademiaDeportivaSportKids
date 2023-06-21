
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
        String[] botones = {"agregar Usuario", "Consultar Usuario", "Op3", "Op4", "SALIR"};
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
                    Usuario usuarioEncontrado = almacenamiento.consultarUsuario(consultarUsuario);
                    if (usuarioEncontrado != null) {
                        System.out.println("Usuario encontrado: " + usuarioEncontrado.getNombre() + " " + usuarioEncontrado.getApellidos());
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                case 2:
                    //insetar funcion
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
