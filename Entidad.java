/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hash;

/**
 *
 * @author Ixel
 */
public abstract class Entidad {
    private String id;

    public Entidad(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public abstract void mostrarInfo();
}
