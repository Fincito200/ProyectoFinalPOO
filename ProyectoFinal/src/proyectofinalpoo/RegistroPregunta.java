package proyectofinalpoo;

/**
 *
 * @author Aaron
 */
public class RegistroPregunta {
    private String pregunta;
    private String respuestaJugador;
    private String respuestaCorrecta;

    public RegistroPregunta(String pregunta, String respuestaJugador, String respuestaCorrecta) {
        this.pregunta = pregunta;
        this.respuestaJugador = respuestaJugador;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String toString() {
        return "Pregunta: " + pregunta +
               "\nRespuesta dada: " + respuestaJugador +
               "\nRespuesta correcta: " + respuestaCorrecta + "\n";
    }
}
