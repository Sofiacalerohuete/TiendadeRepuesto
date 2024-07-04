/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hash;

/**
 *
 * @author Ixel
 */
import java.util.Date;
import java.util.List;

public class Factura {
    private String id;
    private String dniCli;
    private Date fecha;
    private double importe;
    private List<DetalleFactura> detalles;

    public Factura() {
    }
    
    public Factura(String id, String dniCli, Date fecha, double importe, List<DetalleFactura> detalles) {
        this.id = id;
        this.dniCli = dniCli;
        this.fecha = fecha;
        this.importe = importe;
        this.detalles = detalles;
    }

    public String getId() {
        return id;
    }

    public String getDniCli() {
        return dniCli;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getImporte() {
        return importe;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDniCli(String dniCli) {
        this.dniCli = dniCli;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }


    public void setDetalles(List<DetalleFactura> detalles) {
        this.detalles = detalles;
    }
    

    public List<DetalleFactura> getDetalles() {
        return detalles;
    }
    public void mostrarFactura() {
        System.out.println("Factura ID: " + id);
        System.out.println("Cliente DNI: " + dniCli);
        System.out.println("Fecha: " + fecha);
        System.out.println("Importe: " + importe);
    //    System.out.println("Código Factura: " + codFact);
        System.out.println("Detalles:");
        for (DetalleFactura detalle : detalles) {
            System.out.println("  Producto ID: " + detalle.getIdProducto() + ", Cantidad: " + detalle.getCantidad() + ", Precio: " + detalle.getPrecio());
        }
    }
}

