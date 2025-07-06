/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinalpoo;

import javax.swing.JOptionPane;

/**
 *
 * @author AARON
 */
public class Comodin extends Casilla{
    private String efecto;

    public Comodin(String nombre, int posicion, String efecto) {
        super(nombre, posicion);
        this.efecto = efecto;
    }

    @Override
    public void accion(Jugador jugador) {
    JOptionPane.showMessageDialog(null, "Has ganado un comodín extra!");
    jugador.ganarComodin();
}
    
}
