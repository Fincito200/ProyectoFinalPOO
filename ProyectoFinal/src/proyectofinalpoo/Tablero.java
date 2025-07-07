package proyectofinalpoo;

import java.util.ArrayList;

public class Tablero {
    private ArrayList<Casilla> casillas;

    public Tablero() {
        casillas = new ArrayList<>();
        inicializarCasillas();
    }

    private void inicializarCasillas() {
        casillas.add(new Casilla("Inicio", "inicio"));
        casillas.add(new Casilla("Casilla 2", "pregunta"));
        casillas.add(new Casilla("Casilla 3", new Propiedad("Parque", 100)));
        casillas.add(new Casilla("Casilla 4", "pregunta"));
        casillas.add(new Casilla("Casilla 5", new Comodin("Comodín estrella", "gana comodín")));
    }

    public Casilla getCasilla(int posicion) {
        return casillas.get(posicion % casillas.size());
    }

    public int getTotalCasillas() {
        return casillas.size();
    }
}
