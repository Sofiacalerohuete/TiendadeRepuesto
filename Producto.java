/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hash;

/**
 *
 * @author Ixel
 */public class Producto extends Entidad {
    private String nomProd;
    private double precio;
    private int cantidad;

    public Producto(String idProd, String nomProd, double precio, int cantidad) {
        super(idProd);
        this.nomProd = nomProd;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNomProd() {
        return nomProd;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Producto: " + nomProd);
        System.out.println("ID: " + getId());
        System.out.println("Precio: " + precio);
        System.out.println("Cantidad: " + cantidad);
    }
}
