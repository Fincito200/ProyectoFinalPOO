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

        // Lista de preguntas (podrias cargarlas desde archivo o base de datos en un futuro)
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(new Pregunta("¿Capital de Perú?", "Lima"));
        preguntas.add(new Pregunta("¿2 + 2?", "4"));
        preguntas.add(new Pregunta("¿Color del cielo?", "Azul"));

        // seleccionar pregunta aleatoria
        int idx = random.nextInt(preguntas.size());
        Pregunta p = preguntas.get(idx);

        // muestra pregunta
        String respuesta = JOptionPane.showInputDialog(parent, p.getEnunciado());
        //lina 42 recien agregada
        String respuestaJugador = (respuesta != null) ? respuesta : "Sin respuesta";
        
        
        // su es si agrega puntaje
        if (respuesta != null && respuesta.equalsIgnoreCase(p.getRespuesta())) {
            jugador.sumarPuntos(10);
            JOptionPane.showMessageDialog(parent, "Correcto, +10 puntos");
        //si es no se le salta otro joption
        } else {
            jugador.sumarFallo();
            JOptionPane.showMessageDialog(parent, "Incorrecto, será para la proxima");
        }
        //lina 55 recien agregada
        jugador.agregarRegistro(new RegistroPregunta(p.getEnunciado(), respuestaJugador, p.getRespuesta()));
        
    }
}
