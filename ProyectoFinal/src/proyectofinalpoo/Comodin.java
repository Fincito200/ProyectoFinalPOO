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
public class Comodin{
    private String nombre;
    private String efecto; // ej: "gana comodín", "pierde turno", "suma 20 puntos"

    public Comodin(String nombre, String efecto) {
        this.nombre = nombre;
        this.efecto = efecto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEfecto() {
        return efecto;
    }

    public void aplicarEfecto(Jugador jugador) {
        switch (efecto) {
            case "gana comodín":
                jugador.ganarComodin();
                break;
            case "suma 20 puntos":
                jugador.sumarPuntos(20);
                break;
            case "pierde turno":
                // lógica de perder turno si implementas
                break;
        }
    }
    
}
