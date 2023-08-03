
package acaddeportsportkids;
import JFrame.Menu;
import java.util.ArrayList;


public class AcadDeportSportKids {

    public static ArrayList<Usuario> Usuarios = new ArrayList<>();
    
    //Metodo principal
    public static void main(String[] args) {
            
        //usuarios de prueba
        Usuarios.add(new Usuario("1usuario", "1 1 1", "1", (new char[] {'1'}), true));
        Usuarios.set(0, new Deportista(Usuarios.get(0), "ciudad1", "1", "1", "1"));
        
        
        
        Usuarios.add(new Usuario("2usuario", "2 2 2", "2", (new char[] {'2'}), true));
        ArrayList<String> listaHijos = new ArrayList<>();
        listaHijos.add("hijo1");
        Usuarios.set(1, new PadreFamilia(Usuarios.get(1), "ciudad2", "2", "2", "2", listaHijos));
        
        
        System.out.println(((Deportista) Usuarios.get(0)).getCiudad());
        
        System.out.println(((PadreFamilia) Usuarios.get(1)).getHijos().get(0));
        System.out.println(((PadreFamilia) Usuarios.get(1)).getCiudad());
        
        //mas Usuarios de  prueba
        Usuarios.add(new Usuario("3usuario", "3 3 3", "3", (new char[] {'3'}), true));
        Usuarios.add(new Usuario("4usuario", "4 4 4", "4", (new char[] {'4'}), true));
        
        
        //arranque del sistema
        Menu.Arranque();
            
            
            
            
            
            
        }
    
    
    
    
    
    
    
    
    
    
    
}
