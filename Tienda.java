/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hash;

/**
 *
 * @author Ixel
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tienda implements Operaciones {

    private List<Producto> productos;
    private List<Cliente> clientes;
    private List<Factura> facturas;

    public Tienda() {
        this.productos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.facturas = new ArrayList<>();
    }

    @Override
    public void agregar(Entidad entidad) {
        if (entidad instanceof Producto) {
            productos.add((Producto) entidad);
        } else if (entidad instanceof Cliente) {
            clientes.add((Cliente) entidad);
        }
    }
    

    @Override
    public Entidad buscar(String id) {
       
        for (Producto producto : productos) {
            if (producto.getId().equals(id)) {
                return producto;
            }
        }
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public void mostrarTodo() {
        System.out.println("Productos:");
        for (Producto producto : productos) {
            producto.mostrarInfo();
        }

        System.out.println("\nClientes:");
        for (Cliente cliente : clientes) {
            cliente.mostrarInfo();
        }
    }
    
    public void listarProductos() {
        System.out.println("\n--- Lista de Productos ---");
        for (Producto producto : productos) {
            producto.mostrarInfo();
            System.out.println("-----------------------------");
        }
    }

    public void listarClientes() {
        System.out.println("\n--- Lista de Clientes ---");
        for (Cliente cliente : clientes) {
            cliente.mostrarInfo();
            System.out.println("-----------------------------");
        }
    }

    public void eliminarProducto(String idProducto) {
        productos.removeIf(producto -> producto.getId().equals(idProducto));
    }
    
    public void eliminarCliente(String dniCliente) {
        clientes.removeIf(cliente -> cliente.getId().equals(dniCliente));
    }

    public void eliminarFactura(String idFactura) {
        facturas.removeIf(factura -> factura.getId().equals(idFactura));
    }

    public void crearFactura(String id, String dniCli, List<DetalleFactura> detalles) {
        double importe = 0;

        for (DetalleFactura detalle : detalles) {
            Producto producto = (Producto) buscar(detalle.getIdProducto());
            if (producto != null && producto.getCantidad() >= detalle.getCantidad()) {
                importe += detalle.getCantidad() * detalle.getPrecio();
                producto.setCantidad(producto.getCantidad() - detalle.getCantidad());
            } else {
                System.out.println("No hay suficiente inventario para el producto: " + detalle.getIdProducto());
                return;
            }
        }

        Factura factura = new Factura(id, dniCli, new Date(), importe, detalles);
        
        facturas.add(factura);
    }

    public Factura buscarFactura(String idFactura) {
        for (Factura factura : facturas) {
            if (factura.getId().equals(idFactura)) {
                return factura;
            }
        }
        return null;
    }
    public void mostrarFacturas(){
    System.out.println("\n--- Lista de Facturas ---");
        for (Factura factura : facturas) {
            System.out.println("ID Factura: " + factura.getId());
            System.out.println("Cliente DNI: " + factura.getDniCli());
            System.out.println("Fecha: " + factura.getFecha());
            System.out.println("Importe: " + factura.getImporte());
          //  System.out.println("Código Factura: " + factura.getCodFact());
            System.out.println("-----------------------------");
        }
    }

    public void mostrarFactura(String idFactura) {
        Factura factura = buscarFactura(idFactura);
        if (factura == null) {
            System.out.println("Factura no encontrada.");
            return;
        } else {
            Cliente cliente = (Cliente) buscar(factura.getDniCli());
            if (cliente == null) {
                System.out.println("Cliente no encontrado.");
                return;
            }
            System.out.println("\n *******************************");
            System.out.println("Encabezado de Factura:");
            System.out.println("ID Factura: " + factura.getId());
            System.out.println("Fecha: " + factura.getFecha());
            System.out.println("Importe: " + factura.getImporte());
            //System.out.println("Código Factura: " + factura.getCodFact());
           
            System.out.println("\nDatos del Cliente:");
            cliente.mostrarInfo();

            System.out.println("\nDetalle de Productos:");
            for (DetalleFactura detalle : factura.getDetalles()) {
                Producto producto = (Producto) buscar(detalle.getIdProducto());
                if (producto != null) {
                    //producto.mostrarInfo();
                    System.out.println("Producto: " + producto.getNomProd());
                    System.out.println("ID: " + producto.getId());
                    System.out.println("Precio: " + producto.getPrecio());
                    System.out.println("Cantidad: " + detalle.getCantidad());
                    System.out.println("Subtotal: " + (detalle.getCantidad() * detalle.getPrecio()));
                    System.out.println("-----------------------------");
                }
            }
        }

    }
    
    public static boolean validarCorreo(String correo) {
        String regex  = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"; //expresion regular
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }

    public static boolean validarTelefono(String telefono) {
        String regex = "^(505)?\\d{8}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(telefono);
        return matcher.matches();
    }

    public String generarCodigoFactura() {
        return "F" + (facturas.size() + 1);
    }
    
    public String generarCodigoProducto() {
        return "P" + (productos.size() + 1);
    }
    public String generarCodigoCliente() {
        return "C" + (clientes.size() + 1);
    }

   
}
