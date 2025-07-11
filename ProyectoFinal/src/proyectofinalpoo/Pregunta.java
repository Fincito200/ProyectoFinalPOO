package proyectofinalpoo;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;



public class Pregunta {
    private String enunciado;
    private String respuesta;

    public Pregunta(String enunciado, String respuesta) {
        this.enunciado = enunciado;
        this.respuesta = respuesta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public static void hacerPregunta(javax.swing.JFrame parent, Jugador jugador) {
        Random random = new Random();

        // lista de preguntas
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(new Pregunta("¿Capital de Perú?", "Lima"));
        preguntas.add(new Pregunta("¿2 + 2?", "4"));
        preguntas.add(new Pregunta("¿Color del cielo?", "Azul"));

        // selecciona pregunta aleatoria
        int idx = random.nextInt(preguntas.size());
        Pregunta p = preguntas.get(idx);

        // muestra la pregunta
        String respuesta = JOptionPane.showInputDialog(parent, p.getEnunciado());
        //para el txt
        String respuestaJugador = (respuesta != null) ? respuesta : "Sin respuesta";
        
        
        // si es si agrega puntaje
        if (respuesta != null && respuesta.equalsIgnoreCase(p.getRespuesta())) {
            jugador.sumarPuntos(10);
            JOptionPane.showMessageDialog(parent, "Correcto, +10 puntos");
        //si es no se le salta otro joption
        } else {
            jugador.sumarFallo();
            JOptionPane.showMessageDialog(parent, "Incorrecto, será para la proxima");
        }
        //para el txt
        jugador.agregarRegistro(new RegistroPregunta(p.getEnunciado(), respuestaJugador, p.getRespuesta()));
        
    }
}
