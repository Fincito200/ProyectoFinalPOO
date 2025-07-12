package proyectofinalpoo;

/**
 *
 * @author Aaron
 */
public class RegistroPregunta {
    private String pregunta;
    private String respuestaJugador;
    private String respuestaCorrecta;

    //constructor
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
    //prueba
    public String getRespuestaJugador() {
    return respuestaJugador;
}

    public String getRespuestaCorrecta() {
    return respuestaCorrecta;
    }
    
    public String getPregunta() {
    return pregunta;
}
}
