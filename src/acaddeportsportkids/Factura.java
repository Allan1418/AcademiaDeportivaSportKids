package acaddeportsportkids;

import java.io.Serializable;
import javax.swing.DefaultListModel;

public class Factura implements Serializable, cFacturas{
   
  private String codigo;
  private String fecha;
  private String descripcion;
  private double monto;
  
    
    
  public Factura(String user, String fecha_actual, double monto, String descripcion) {
    this.codigo = user;
    this.fecha = fecha_actual;
    this.monto = monto;
    this.descripcion = descripcion;
  }

  @Override
  public String getCodigo() {
    return codigo;
  }

  @Override
  public String getFecha() {
    return fecha;
  }

    @Override
  public double getMonto() {
    return monto;
  }

  @Override
  public String getDescripcion() {
    return descripcion;
  }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

  
  
}
//    hijo1 - rutina1
//    hijo2 - rutina2
    
