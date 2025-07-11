package proyectofinalpoo;

/**
 *
 * @author AARON
 */
public class Casilla {
    private String nombre;
    private String tipo; 
    private Comodin comodin;
    private Propiedad propiedad;

    public Casilla(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Casilla(String nombre, Comodin comodin) {
        this.nombre = nombre;
        this.tipo = "comodin";
        this.comodin = comodin;
    }

    public Casilla(String nombre, Propiedad propiedad) {
        this.nombre = nombre;
        this.tipo = "propiedad";
        this.propiedad = propiedad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public Comodin getComodin() {
        return comodin;
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }
}
