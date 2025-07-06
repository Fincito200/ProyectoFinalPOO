package proyectofinalpoo;

import java.util.ArrayList;
import java.util.Random;

public class Tablero {
    private ArrayList<Casilla> casillas = new ArrayList<>();

    public Tablero() {
        initCasillas();
    }

    public Pregunta getPreguntaAzar() {
    ArrayList<Pregunta> preguntas = new ArrayList<>();
    for (Casilla c : casillas) {
        if (c instanceof Pregunta) {
            preguntas.add((Pregunta) c);
        }
    }

    // elige una al azar
    if (!preguntas.isEmpty()) {
        int indice = new Random().nextInt(preguntas.size());
        return preguntas.get(indice);
    } else {
        return new Pregunta("Default", -1, "Sin preguntas disponibles", "");
    }
    }
    
    public void initCasillas() {
        casillas.add(new Propiedad("Inicio", 0, 0));
        casillas.add(new Pregunta("Pregunta 1", 1, "¿Capital de Perú?", "Lima"));
        casillas.add(new Pregunta("Pregunta 2", 2, "5 x 6 = ?", "30"));
        casillas.add(new Pregunta("Pregunta 3", 3, "Raíz cuadrada de 49?", "7"));
        casillas.add(new Comodin("Comodin Casilla 5", 4, "Gana un comodin extra"));
        // continua hasta completar todas tus casillas
    }

    public Casilla getCasilla(int posicion) {
        return casillas.get(posicion);
    }

    public int totalCasillas() {
        return casillas.size();
    }
}
