package proyectofinalpoo;

import java.util.ArrayList;

public class Tablero {
    private ArrayList<Casilla> casillas;

    public Casilla getCasilla(int posicion) {
        return casillas.get(posicion % casillas.size());
    }

    public int getTotalCasillas() {
        return casillas.size();
    }
    
    public Tablero() {
        casillas = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            casillas.add(new Casilla("Casilla " + i, "normal"));
        }
    }
}
