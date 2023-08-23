
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
    public static final String ARCH_FACTURA = "Facturas.dat";
    
    //public static final String ARCH_DEPORTES = "deportes.dat";
    //public static final String ARCH_RUTINAS = "rutinas.dat";
    

    public static ArrayList<Usuario> listUsuarios = new ArrayList<>();
    
    
    //Metodo principal
    public static void main(String[] args) {
        
        borrarArchivos();
        
        //arranque del sistema
        Menu.Arranque();
        
        }
    
    
    public static void borrarArchivos(){
        new File(ARCH_USUARIOS).delete();
        new File(ARCH_DEPORU).delete();
        new File(ARCH_FACTURA).delete();
    }
    
    
    public static void scriptFinal(){
        
        //System.out.println(((Deporte) Comun.consultarArch("3", ARCH_DEPORU)).getDeportes());
        
    }

    
    
    
    
    
    
    
    
    
}
