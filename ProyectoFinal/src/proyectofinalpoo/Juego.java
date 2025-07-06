package proyectofinalpoo;

import java.util.ArrayList;


public class Juego {
    private ArrayList<Jugador> jugadores;
    private int turnoActual;
    private Tablero tablero;
    private Dado dado;

    public Juego(ArrayList<Jugador> jugadores, Tablero tablero) {
        this.jugadores = jugadores;
        this.tablero = tablero;
        this.dado = new Dado();
        this.turnoActual = 0;
    }

    public void jugarTurno() {
        Jugador j = jugadores.get(turnoActual);
        int valor = dado.tirar();
        System.out.println(j.getNombre() + " tira el dado: " + valor);
        j.mover(valor, tablero.totalCasillas());
        Casilla c = tablero.getCasilla(j.getPosicion());
        c.accion(j);
        turnoActual = (turnoActual + 1) % jugadores.size();
    }
    
    public Jugador getJugadorActual() {
    return jugadores.get(turnoActual);
    }

    public void siguienteTurno() {
    turnoActual = (turnoActual + 1) % jugadores.size();
    }

    public ArrayList<Jugador> getJugadores() {
    return jugadores;
    }

    public Dado getDado() {
    return dado;
    }
}
