/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinalpoo;

/**
 *
 * @author AARON
 */
public class Propiedad {
    private String nombre;
    private int precio;
    private Jugador propietario;

    public Propiedad(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.propietario = null;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public Jugador getPropietario() {
        return propietario;
    }

    public void comprar(Jugador jugador) {
        if (propietario == null) {
            propietario = jugador;
        }
    }
}
