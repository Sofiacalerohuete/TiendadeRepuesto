/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hash;


/**
 *
 * @author Ixel
 */public class Cliente extends Entidad {
    private String nomCliente;
    private String telefono;
    private String correo;
    
    public Cliente(String dni, String nomCliente, String telefono, String correo) {
        super(dni);
        this.nomCliente = nomCliente;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Cliente: " + nomCliente);
        System.out.println("DNI: " + getId());
        System.out.println("Teléfono: " + telefono);
        System.out.println("Correo: " + correo);
    }
}

    
    
