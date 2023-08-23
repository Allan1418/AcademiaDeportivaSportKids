package acaddeportsportkids;

import java.io.Serializable;
import javax.swing.DefaultListModel;

public class Factura implements Serializable, cFacturas {

    private String codigo;
    private String fecha;
    private String descripcion;
    private double monto;

    public Factura(String codigo, String fecha_actual, double monto, String descripcion) {
        this.codigo = codigo;
        this.fecha = fecha_actual;
        this.monto = monto;
        this.descripcion = descripcion;
    }
    
    @Override
    public String getCodigo() {
        return codigo;
    }
    
    @Override
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String getFecha() {
        return fecha;
    }
    
    @Override
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public double getMonto() {
        return monto;
    }
    
    @Override
    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}

