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

    public static void hacerPregunta(javax.swing.JFrame parent, Jugador jugador,Principal principal) {
        Random random = new Random();

        // lista de preguntas
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(new Pregunta("¿Capital de Perú?", "Lima"));
        preguntas.add(new Pregunta("¿2 + 2?", "4"));
        preguntas.add(new Pregunta("¿Color del cielo?", "Azul"));
        preguntas.add(new Pregunta("Si tengo 15 manzanas y regalo 7, ¿cuántas me quedan?", "8"));
        preguntas.add(new Pregunta("¿Cuál es el resultado de 6 × 4?", "24"));
        preguntas.add(new Pregunta("¿Qué planeta es conocido como \"el planeta rojo\"?", "Marte"));
        preguntas.add(new Pregunta("¿Cuántas sílabas tiene la palabra \"árbol\"?", "2"));
        preguntas.add(new Pregunta("¿Qué civilización antigua construyó Machu Picchu?", "Los Incas"));
        preguntas.add(new Pregunta("¿Qué animal pone huevos más grandes: el elefante o el avestruz?", "Avestruz"));
        preguntas.add(new Pregunta("¿Qué tipo de palabra es \"correr\": sustantivo o verbo?", "Verbo"));

        // selecciona pregunta aleatoria
        int idx = random.nextInt(preguntas.size());
        Pregunta p = preguntas.get(idx);

        // muestra la pregunta
        String respuesta = JOptionPane.showInputDialog(parent, p.getEnunciado());
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
        
        //prueba
        StringBuilder errores = new StringBuilder();
for (RegistroPregunta registro : jugador.getHistorial()) {
    if (!registro.getRespuestaJugador().equalsIgnoreCase(registro.getRespuestaCorrecta())) {
        errores.append("Jugador: ").append(jugador.getNombre()).append("\n")
               .append("Pregunta: ").append(registro.getPregunta()).append("\n")
               .append("Respuesta dada: ").append(registro.getRespuestaJugador()).append("\n")
               .append("Respuesta correcta: ").append(registro.getRespuestaCorrecta()).append("\n")
               .append("===================\n");
    }
        principal.actualizarErrores(errores.toString());
    //Fin prueba
    }
}
}
