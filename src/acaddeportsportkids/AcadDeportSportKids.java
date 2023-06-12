
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
        String[] botones = {"Op1", "Op2", "Op3", "Op4", "SALIR"};
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
                    break;
                case 1:
                    //insetar funcion
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
