
package acaddeportsportkids;
import JFrame.Menu;
import java.io.*;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


public class AcadDeportSportKids {
    
    //constantes de nombres de arch
    public static final String ARCH_USUARIOS = "usuarios.dat";
    public static final String ARCH_DEPORTES = "deportes.dat";
    public static final String ARCH_RUTINAS = "rutinas.dat";
    

    public static ArrayList<Usuario> listUsuarios = new ArrayList<>();
    
    //Metodo principal
    public static void main(String[] args) {
        
        borrarArchivos();
        
        listUsuarios.add(new Usuario("11", "1 1 1", "1", (new char[]{'1', '1'}), false));
        Usuario pre2 = new Usuario("22", "2 2 2", "2", (new char[]{'2', '2'}), true);
        Usuario pre3 = new Usuario("33", "3 3 3", "3", (new char[]{'3', '3'}), true);
        listUsuarios.add(new Deportista(pre2, "22","22", "22", "22"));
        ((Deportista) listUsuarios.get(1)).setPadreACargo("lala");
        listUsuarios.add(new PadreFamilia(pre3, "33","33", "33", "33", new DefaultListModel<String>(){{add(0,"3");}}));
        listUsuarios.add(new Usuario("44", "4 4 4", "4", (new char[]{'4', '4'}), true));
        listUsuarios.add(new Usuario("55", "5 5 5", "5", (new char[]{'5', '5'}), true));
        
        Comun.agregarArch(listUsuarios.get(0), ARCH_USUARIOS);
        Comun.agregarArch(listUsuarios.get(1), ARCH_USUARIOS);
        Comun.agregarArch(listUsuarios.get(2), ARCH_USUARIOS);
        Comun.agregarArch(listUsuarios.get(3), ARCH_USUARIOS);
        Comun.agregarArch(listUsuarios.get(4), ARCH_USUARIOS);
        
        //arranque del sistema
        Menu.Arranque();
        
        
        
        
        }
    
    
    public static void borrarArchivos(){
        new File(ARCH_USUARIOS).delete();
        new File(ARCH_DEPORTES).delete();
        new File(ARCH_RUTINAS).delete();
    }
    
    
    public static void scriptFinal(){
        
        //System.out.println(((PadreFamilia) Comun.consultarArch("4", ARCH_USUARIOS)).getCiudad());
        //System.out.println(((PadreFamilia) listUsuarios.get(3)).getCiudad());
        
    }

    
    
    
    
    
    
    
    
    
}
