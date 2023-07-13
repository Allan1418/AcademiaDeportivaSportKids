package acaddeportsportkids;

public class Comun {
    
    public static Usuario buscarClienteUsuario(String Usuario) {
        for (Usuario actual : AcadDeportSportKids.ListaUnica) {
            if (actual == null) {
                return null;
            }
            if (actual.getUsuario().equals(Usuario)) {
                return actual;
            }
        }
        return null;
    }
}
