
package acaddeportsportkids;
import JFrame.Menu;
import java.io.*;
import java.util.ArrayList;
import javax.swing.DefaultListModel;


public class AcadDeportSportKids {
    
    //constantes de nombres de arch
    public static final String ARCH_USUARIOS = "usuarios.dat";
    public static final String ARCH_DEPORU = "DeportesYrutinas.dat";
    public static final String ARCH_FACTURA = "Facturas.dat";
    
    

    public static ArrayList<Usuario> listUsuarios = new ArrayList<>();
    
    
    //Metodo principal
    public static void main(String[] args) {
        
        //borrarArchivos();
        
        
        Comun.cargarArray();
        
        
//        listUsuarios.add(new Usuario("11", "1 1 1", "1", (new char[]{'1', '1'}), true));
//        Usuario pre2 = new Usuario("22", "2 2 2", "2", (new char[]{'2', '2'}), true);
//        Usuario pre3 = new Usuario("33", "3 3 3", "3", (new char[]{'3', '3'}), true);
//        listUsuarios.add(new Deportista(pre2, "22","22", "22", "22", "rutina1"));
//        listUsuarios.add(new PadreFamilia(pre3, "33","33", "33", "33", new DefaultListModel<String>(){{add(0,"2");}}, new DefaultListModel<String>()));
//        listUsuarios.add(new Usuario("44", "4 4 4", "4", (new char[]{'4', '4'}), true));
//        listUsuarios.add(new Usuario("55", "5 5 5", "5", (new char[]{'5', '5'}), true));
//        
//        Factura pref = new Factura("3_6", "antigua", 666, "descr");
//        Comun.agregarArch(pref, ARCH_FACTURA);
//        
//        ((PadreFamilia) listUsuarios.get(2)).getFacturas().add(0, "3_6");
//        
//        ((Deportista) listUsuarios.get(1)).setPadreACargo("33");
//        ((Deportista) listUsuarios.get(1)).setRutina("rutina1");
//        
//        Comun.agregarArch(listUsuarios.get(0), ARCH_USUARIOS);
//        Comun.agregarArch(listUsuarios.get(1), ARCH_USUARIOS);
//        Comun.agregarArch(listUsuarios.get(2), ARCH_USUARIOS);
//        Comun.agregarArch(listUsuarios.get(3), ARCH_USUARIOS);
//        Comun.agregarArch(listUsuarios.get(4), ARCH_USUARIOS);
        
        
        //arranque del sistema
        Menu.Arranque();
        
        }
    
    
    public static void borrarArchivos(){
        new File(ARCH_USUARIOS).delete();
        new File(ARCH_DEPORU).delete();
        new File(ARCH_FACTURA).delete();
    }
    
    
    public static void scriptFinal(){
        
        System.out.println(listUsuarios.get(0).getNombre());
        
    }

    
    
    
    
    
    
    
    
    
}
