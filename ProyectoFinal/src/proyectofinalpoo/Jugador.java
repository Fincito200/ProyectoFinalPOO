package proyectofinalpoo;

import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private int posicion;
    private int puntos;
    private int comodines;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.posicion = 0;
        this.puntos = 0;
        this.comodines = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPosicion() {
        return posicion;
    }

    public void mover(int pasos, int totalCasillas) {
        posicion = (posicion + pasos) % totalCasillas;
    }

    public void ganarPuntos(int p) {
        puntos += p;
        System.out.println(nombre + " ahora tiene " + puntos + " puntos.");
    }

    public int getPuntos() {
        return puntos;
    }
    
    public void ganarComodin() {
    comodines++;
    System.out.println(nombre + " ahora tiene " + comodines + " comodines.");
}

public int getComodines() {
    return comodines;
}
}
