package proyectofinalpoo;

import javax.swing.JOptionPane;

/**
 *
 * @author AARON
 */
public class Comodin{
    private String nombre;
    private String efecto;

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
