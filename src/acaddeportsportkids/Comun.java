package acaddeportsportkids;

import javax.swing.JOptionPane;
import java.io.*;
import java.util.ArrayList;

public class Comun {
    
    public static Usuario buscarUsuarioArray(String user) {
        for (Usuario actual : AcadDeportSportKids.listUsuarios) {
            if (actual.getUser().equals(user)) {
                return actual;
            }
        }
        return null;
    }
    
    public static void reempUsuarioArray(Usuario reemp){
        Usuario actual;
        for (int i = 0; i < AcadDeportSportKids.listUsuarios.size(); i++) {
        actual = AcadDeportSportKids.listUsuarios.get(i);
        if (actual.getUser().equals(reemp.getUser())) {
            AcadDeportSportKids.listUsuarios.set(i, reemp);
            return;
        }
    }
        
    }
    
    public static void cargarArray() {
        
        Object actual = null;
        ObjectInputStream arch = null;
        
        if (!new File(AcadDeportSportKids.ARCH_USUARIOS).exists()) {
            return;
        }

        try {
            arch = new ObjectInputStream(new FileInputStream(AcadDeportSportKids.ARCH_USUARIOS));
            
            while (true) {
                AcadDeportSportKids.listUsuarios.add((Usuario) arch.readObject());
                
            }
            
            
        } catch (EOFException ex12) {
        } catch (FileNotFoundException ex13) {
            JOptionPane.showMessageDialog(null, "¡No se encontró el archivo!", "Error ex13", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex14) {
            JOptionPane.showMessageDialog(null, "hubo un error con el archivo!", "Error ex14", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex15) {
            JOptionPane.showMessageDialog(null, "hubo un error con el archivo!", "Error ex15", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                arch.close();
            } catch (IOException ex16) {
                JOptionPane.showMessageDialog(null, "hubo un error con el archivo!", "Error ex16", JOptionPane.ERROR_MESSAGE);
            }
        }

        
    }
    
    public static void agregarArch(Object actual, String nombreArch){
        try {
            ObjectOutputStream arch;
            
            
            File file = new File(nombreArch);

            if (file.exists()) {
                arch = new ObjectOutputStream(new FileOutputStream(nombreArch, true)) {
                    @Override
                    protected void writeStreamHeader() throws IOException {
                        reset();
                    }
                };
            } else {
                arch = new ObjectOutputStream(new FileOutputStream(nombreArch));
            }
            
            arch.writeObject(actual);
            
            //JOptionPane.showMessageDialog(null,"se guardo en el archivo", "Dato guardado",JOptionPane.INFORMATION_MESSAGE);
            arch.close();
            
            
 
        } catch (IOException ex01) {
            JOptionPane.showMessageDialog(null,"Ocurrió un error!","Error ex01", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public static Object consultarArch(String match, String nombreArch) {
        
        Object actual = null;
        ObjectInputStream arch = null;
        
        if (!new File(nombreArch).exists()) {
            return actual;
        }

        try {
            arch = new ObjectInputStream(new FileInputStream(nombreArch));
            

            while (true) {
                actual = arch.readObject();
                
                if (actual instanceof Usuario usuario) {
                    if (usuario.getUser().equals(match)) {
                        break;
                    }
                    
                } else if(actual instanceof Deporte deporte){
                    if (deporte.getNombre().equals(match)) {
                        break;
                    }
                } else if(actual instanceof Factura factura){
                    if (factura.getCodigo().equals(match)) {
                        break;
                    }
                }
                actual = null;
            }
            
            
        } catch (EOFException ex02) {
        } catch (FileNotFoundException ex03) {
            JOptionPane.showMessageDialog(null, "¡No se encontró el archivo!", "Error ex03", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex04) {
            JOptionPane.showMessageDialog(null, "hubo un error con el archivo!", "Error ex04", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex05) {
            JOptionPane.showMessageDialog(null, "hubo un error con el archivo!", "Error ex05", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                arch.close();
            } catch (IOException ex11) {
                JOptionPane.showMessageDialog(null, "hubo un error con el archivo!", "Error ex11", JOptionPane.ERROR_MESSAGE);
            }
        }

        
        return actual;
    }
    
    public static void reempObjctArch(Object reemp, String nombreArch){
        
        if (!new File(nombreArch).exists()) {
            agregarArch(reemp, nombreArch);
            return;
        }
        
        
        
        ArrayList<Object> listTemp = new ArrayList<>();
        
        //lectura de archivo
        try {
            ObjectInputStream arch = new ObjectInputStream(new FileInputStream(nombreArch));
            Object lectura = null;

            while (true) {
                lectura = arch.readObject();
                
                if (lectura instanceof Usuario usuario) {
                    if (usuario.getUser().equals(((Usuario) reemp).getUser())) {
                        listTemp.add(reemp);
                    }else{
                        listTemp.add(lectura);
                    }
                } else if(lectura instanceof Deporte deporte){
                    if (deporte.getNombre().equals(((Deporte) reemp).getNombre())) {
                        listTemp.add(reemp);
                    }else{
                        listTemp.add(lectura);
                    }
                }
                
                
            }

        } catch (EOFException ex06) {
        } catch (FileNotFoundException ex07) {
            JOptionPane.showMessageDialog(null, "¡No se encontró el archivo!", "Error ex07", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex08) {
            JOptionPane.showMessageDialog(null, "hubo un error con el archivo!", "Error ex08", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex09) {
            JOptionPane.showMessageDialog(null, "hubo un error con el archivo!", "Error ex09", JOptionPane.ERROR_MESSAGE);
        }
        
        //escritura de nuevo archivo
        try {
            ObjectOutputStream arch = new ObjectOutputStream(new FileOutputStream(nombreArch, false));
            
            for (Object actual : listTemp) {
                arch.writeObject(actual);
                
            }
            
            arch.close();
 
        } catch (IOException ex10) {
            JOptionPane.showMessageDialog(null,"Ocurrió un error!","Error ex01", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
    }
    
    
    
}
