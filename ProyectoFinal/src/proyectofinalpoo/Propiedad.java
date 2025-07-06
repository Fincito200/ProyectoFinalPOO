/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinalpoo;

/**
 *
 * @author AARON
 */
public class Propiedad extends Casilla {
    private int precio;
    private Jugador dueno;

    public Propiedad(String nombre, int posicion, int precio) {
        super(nombre, posicion);
        this.precio = precio;
        this.dueno = null;
    }

    @Override
    public void accion(Jugador jugador) {
        if (dueno == null) {
            System.out.println(jugador.getNombre() + " puede comprar " + nombre + " por " + precio);
            // lógica de compra aquí
        } else if (!dueno.equals(jugador)) {
            System.out.println(jugador.getNombre() + " paga renta a " + dueno.getNombre());
            // lógica de pago aquí
        }
    }
}
