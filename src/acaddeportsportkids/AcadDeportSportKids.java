
package acaddeportsportkids;
import JFrame.Menu;
import java.io.*;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


public class AcadDeportSportKids {
    
    //constantes de nombres de arch
    public static final String ARCH_USUARIOS = "usuarios.dat";
    public static final String ARCH_DEPORU = "DeportesYrutinas.dat";
    
    //public static final String ARCH_DEPORTES = "deportes.dat";
    //public static final String ARCH_RUTINAS = "rutinas.dat";
    

    public static ArrayList<Usuario> listUsuarios = new ArrayList<>();
    
    //Metodo principal
    public static void main(String[] args) {
        
        borrarArchivos();
        
        Deporte a = new Deporte("1", "1 1 1", true);
        a.setRutinas(new ArrayList<>());
        Deporte b = new Deporte("2", "2 2 2", true);
        b.setRutinas(new ArrayList<>());
        Deporte c = new Deporte("3", "3 3 3", true);
        c.setRutinas(new ArrayList<String>(){{ add("4"); }});
        
        
        Comun.agregarArch(a, ARCH_DEPORU);
        Comun.agregarArch(b, ARCH_DEPORU);
        Comun.agregarArch(c, ARCH_DEPORU);
        Comun.agregarArch(new Rutina("4", "4 4 4", true, "3", "4"), ARCH_DEPORU);
        
        //arranque del sistema
        Menu.Arranque();
        
        }
    
    
    public static void borrarArchivos(){
        new File(ARCH_USUARIOS).delete();
        new File(ARCH_DEPORU).delete();
    }
    
    
    public static void scriptFinal(){
        
        //System.out.println(((Deporte) Comun.consultarArch("3", ARCH_DEPORU)).getDeportes());
        
    }

    
    
    
    
    
    
    
    
    
}
