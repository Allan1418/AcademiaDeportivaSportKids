package acaddeportsportkids;

import javax.swing.JOptionPane;

public class Comun {
    
    public static Usuario buscarUsuario(String user) {
        for (Usuario actual : AcadDeportSportKids.Usuarios) {
            if (actual == null) {
                return null;
            }
            if (actual.getUser().equals(user)) {
                return actual;
            }
        }
        return null;
    }
    
    
    public static boolean regexConfirm(String regex, String txt, String err) {
        if (txt.matches(regex)) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, err, "Academia Deportiva Sport Kids", 0);
            return false;
        }
    }
    
}
