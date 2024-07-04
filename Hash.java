/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hash;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Ixel
 */
public class Hash {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* // Agregar productos
        tienda.agregar(new Producto("P001", "Aceite Motor", 50.0, 10));
        tienda.agregar(new Producto("P002", "Filtro de Aire", 30.0, 5));

        // Agregar clientes
        tienda.agregar(new Cliente("12345678", "Juan Perez", "987654321", "juan@example.com"));

        // Crear factura
        List<DetalleFactura> detalles = new ArrayList<>();
        detalles.add(new DetalleFactura("D001", "F001", "P001", 2, 50.0));
        detalles.add(new DetalleFactura("D002", "F001", "P002", 1, 30.0));

        tienda.crearFactura("F001", "12345678", detalles);

        // Mostrar factura
        tienda.mostrarFactura("F001");*/

        // Mostrar todos los productos y clientes
       // tienda.mostrarTodo();
       Tienda tienda = new Tienda();
       Scanner scanner = new Scanner(System.in);
       int opcion;

        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Gestionar Productos");
            System.out.println("2. Gestionar Clientes");
            System.out.println("3. Gestionar Facturas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = leerOpcion(scanner);//scanner.nextInt();
            //scanner.nextLine();  // Consumir la nueva línea
           
            switch (opcion) {
                case 1:
                    gestionarProductos(tienda, scanner);
                    break;
                case 2:
                    gestionarClientes(tienda, scanner);
                    break;
                case 3:
                    gestionarFacturas(tienda, scanner);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();

    }
    private static void gestionarProductos(Tienda tienda, Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Productos ---");
            System.out.println("1. Insertar Producto");
            System.out.println("2. Eliminar Producto");
            System.out.println("3. Buscar Producto");
            System.out.println("4. Listar Productos");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            opcion = leerOpcion(scanner);//scanner.nextInt();
           // scanner.nextLine();  // Consumir la nueva línea

            switch (opcion) {
                
                case 1:
                    //System.out.print("ID Producto: ");
                    String idProd=null;
                    //String idProd = scanner.nextLine();
                    System.out.print("Nombre Producto: ");
                    String nomProd = scanner.nextLine();
                    System.out.print("Precio: ");
                    double precio = scanner.nextDouble();
                    System.out.print("Cantidad en existencia: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine();  // Consumir la nueva línea

                    Producto producto = new Producto(tienda.generarCodigoProducto(), nomProd, precio, cantidad);
                    tienda.agregar(producto);
                    System.out.println("Producto agregado con éxito.");
                    break;
                case 2:
                    System.out.print("ID Producto a eliminar: ");
                    idProd = scanner.nextLine();
                    Producto prod = (Producto) tienda.buscar(idProd);
                    if (prod != null) {
                        tienda.eliminarProducto(idProd);
                        System.out.println("Producto eliminado con éxito.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("ID Producto a buscar: ");
                    idProd = scanner.nextLine();
                    prod = (Producto) tienda.buscar(idProd);
                    if (prod != null) {
                         System.out.println("\n--- Detalle del producto ---");
                        prod.mostrarInfo();
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 4:
                    tienda.listarProductos();
                    break;
                case 5:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }
    private static void gestionarClientes(Tienda tienda, Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Clientes ---");
            System.out.println("1. Insertar Cliente");
            System.out.println("2. Eliminar Cliente");
            System.out.println("3. Buscar Cliente");
            System.out.println("4. Listar Clientes");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            opcion = leerOpcion(scanner);//scanner.nextInt();
           // scanner.nextLine();  // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    //System.out.print("DNI Cliente: ");
                    String dni = null;//scanner.nextLine();
                    System.out.print("Nombre Cliente: ");
                    String nomCliente = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();
                    while (!tienda.validarTelefono(telefono)) {
                    System.out.println("Número telefónico no válido. Intente de nuevo.");
                    System.out.print("Ingrese su número telefónico: ");
                    telefono = scanner.nextLine();
                    }
                    System.out.println("Número telefónico válido.");
                    System.out.print("Correo: ");
                    String correo = scanner.nextLine();
                    while (!tienda.validarCorreo(correo)) {
                    System.out.println("Correo electrónico no válido. Intente de nuevo.");
                    System.out.print("Ingrese su correo electrónico: ");
                    correo = scanner.nextLine();
                    }
                    System.out.println("Correo electrónico válido.");
        
                    Cliente cliente = new Cliente(tienda.generarCodigoCliente(), nomCliente, telefono, correo);
                    tienda.agregar(cliente);
                    System.out.println("Cliente agregado con éxito.");
                    break;
                case 2:
                    System.out.print("DNI Cliente a eliminar: ");
                    dni = scanner.nextLine();
                    Cliente cli = (Cliente) tienda.buscar(dni);
                    if (cli != null) {
                        tienda.eliminarCliente(dni);
                        System.out.println("Cliente eliminado con éxito.");
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("DNI Cliente a buscar: ");
                    dni = scanner.nextLine();
                    cli = (Cliente) tienda.buscar(dni);
                    if (cli != null) {
                         System.out.println("\n--- Detalle del producto ---");
                        cli.mostrarInfo();
                    } else {
                        System.out.println("\n Cliente no encontrado.");
                    }
                    break;
                case 4:
                    tienda.listarClientes();
                    break;
                case 5:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }
    private static void gestionarFacturas(Tienda tienda, Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Facturas ---");
            System.out.println("1. Crear Factura");
            System.out.println("2. Buscar Factura");
            System.out.println("3. Listar Facturas");
            System.out.println("4. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            opcion = leerOpcion(scanner);//scanner.nextInt();
            //scanner.nextLine();  // Consumir la nueva línea

            switch (opcion) {
                case 1:
                   // System.out.print("ID Factura: ");
                   String idFactura = tienda.generarCodigoFactura(); //scanner.nextLine();
                    System.out.print("DNI Cliente: ");
                    String dniCli = scanner.nextLine();
                    boolean clientE = false;
                    
                    while(!clientE){
                        Cliente cli = (Cliente) tienda.buscar(dniCli);
                         if (cli != null) {
                            clientE=true;
                            break;
                         } //else {
                            //System.out.println("Cliente no encontrado.");
                        //}
                       System.out.println("Vuelva digitar codigo del Cliente: ");
                       dniCli = scanner.nextLine();
                    }
                    System.out.println("Cliente encontrado. \n ");
                    
                    
                    List<DetalleFactura> detalles = new ArrayList<>();

                    String continuar;
                    do {
                        System.out.print("ID Producto: ");
                        String idProd = scanner.nextLine();
                        boolean idProdE = false;
                       
                     Producto prod=null;
                    while(!idProdE){
                        prod = (Producto) tienda.buscar(idProd);
                         if (prod != null) {
                            idProdE=true;
                            break;
                         } 
                       System.out.println("Vuelva digitar codigo del Producto: ");
                       idProd = scanner.nextLine();
                      }
                       System.out.println("Producto encontrado. \n ");
                    
                        System.out.print("Cantidad: ");
                        int cantidad = scanner.nextInt();
                      //  System.out.print("Precio: ");
                       // double precio = scanner.nextDouble();
                        scanner.nextLine();  // Consumir la nueva línea

                        DetalleFactura detalle = new DetalleFactura(idFactura,idProd, cantidad, prod.getPrecio());
                        detalles.add(detalle);

                        System.out.print("¿Agregar otro producto? (s/n): ");
                        continuar = scanner.nextLine();
                    } while (continuar.equalsIgnoreCase("s"));

                    tienda.crearFactura(idFactura, dniCli, detalles);
                    System.out.println("Factura creada con éxito.");
                    break;
                case 2:
                    System.out.print("ID Factura a buscar: ");
                    idFactura = scanner.nextLine();
                    Factura factura = tienda.buscarFactura(idFactura);
                    if (factura != null) {
                        tienda.mostrarFactura(idFactura);
                    } else {
                        System.out.println("Factura no encontrada.");
                    }
                    break;
                case 3:
                    tienda.mostrarFacturas();
                    break;
                case 4:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);
    }
    private static int leerOpcion(Scanner scanner) {
        int opcion = -1;
        boolean valido = false;
        while (!valido) {
            try {
                opcion = scanner.nextInt();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.print("Entrada no válida. Por favor, ingrese un número: ");
                scanner.next(); // Limpiar la entrada inválida
            }
        }
        scanner.nextLine(); // Consumir la nueva línea
        return opcion;
    }
}
