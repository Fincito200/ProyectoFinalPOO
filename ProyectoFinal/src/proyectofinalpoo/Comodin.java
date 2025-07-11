package proyectofinalpoo;

import javax.swing.JOptionPane;

/**
 *
 * @author AARON
 */
public class Comodin{
    private String nombre;
    private String efecto;

    public Comodin(String nombre, String efecto) {
        this.nombre = nombre;
        this.efecto = efecto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEfecto() {
        return efecto;
    }
    
}
