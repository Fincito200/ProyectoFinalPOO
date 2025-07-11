package proyectofinalpoo;

import java.util.ArrayList;


public class Juego {
    private ArrayList<Jugador> jugadores;
    private int turnoActual;
    private Dado dado;
    private Tablero tablero;
    
    //Jugadores
    public Juego() {
        jugadores = new ArrayList<>();
        jugadores.add(new Jugador("Jugador 1"));
        jugadores.add(new Jugador("Jugador 2"));
        turnoActual = 0;
        dado = new Dado();
        tablero = new Tablero();
    }

    public Casilla getCasillaActual(Jugador jugador) {
        return tablero.getCasilla(jugador.getPosicion());
    }
    
    public Jugador getJugadorActual() {
        return jugadores.get(turnoActual);
    }

    public void siguienteTurno() {
        turnoActual = (turnoActual + 1) % jugadores.size();
    }

    public Dado getDado() {
        return dado;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
}
