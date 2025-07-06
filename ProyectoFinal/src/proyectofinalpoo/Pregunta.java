package proyectofinalpoo;

import javax.swing.JOptionPane;


public class Pregunta extends Casilla{
   private String enunciado;
    private String respuesta;

    public Pregunta(String nombre, int posicion, String enunciado, String respuesta) {
        super(nombre, posicion);
        this.enunciado = enunciado;
        this.respuesta = respuesta;
    }

    @Override
    public void accion(Jugador jugador) {
        String r = JOptionPane.showInputDialog(null, enunciado);
        if (r != null && r.equalsIgnoreCase(respuesta)) {
            JOptionPane.showMessageDialog(null, "Correcto!");
            jugador.ganarPuntos(10);
        } else {
            JOptionPane.showMessageDialog(null, "Incorrecto. La respuesta era: " + respuesta);
        }
    }
}
