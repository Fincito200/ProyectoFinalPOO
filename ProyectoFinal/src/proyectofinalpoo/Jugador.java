package proyectofinalpoo;

import java.util.ArrayList;


public class Jugador {
    private String nombre;
    private int puntos;
    private int comodines;
    private int posicion;
    private int fallos = 0;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
        this.comodines = 0;
        this.posicion = 0; // Inicio
    }

    public void mover(int pasos, int totalCasillas) {
        posicion = (posicion + pasos) % totalCasillas;
    }

    public int getPosicion() {
        return posicion;
    }

    public void ganarComodin() {
        comodines++;
    }

    public void sumarPuntos(int puntos) {
        this.puntos += puntos;
    }

    public int getPuntos() {
        return puntos;
    }

    public int getComodines() {
        return comodines;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void usarComodin() {
        if (comodines > 0) {
        comodines--;
        }
    }
    
    public int getFallos() {
        return fallos;
    }
    
    public void sumarFallo() {
        this.fallos++;
    }
    
    //Para el txt
    private ArrayList<RegistroPregunta> historial = new ArrayList<>();

    public void agregarRegistro(RegistroPregunta registro) {
    historial.add(registro);
    }

    public ArrayList<RegistroPregunta> getHistorial() {
    return historial;
    }
}
