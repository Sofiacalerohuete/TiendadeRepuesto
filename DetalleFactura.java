/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hash;

/**
 *
 * @author Ixel
 */
public class DetalleFactura {
    private String idFactura;
    private String idProducto;
    private int cantidad;
    private double precio;

    public DetalleFactura(String idFactura, String idProducto, int cantidad, double precio) {
      
        this.idFactura = idFactura;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    

    public String getIdFactura() {
        return idFactura;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }
}
