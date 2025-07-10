package proyectofinalpoo;

import java.util.Random;

/**
 *
 * @author AARON
 */
public class Dado {
    private Random random = new Random();

    public int tirar() {
        return random.nextInt(6) + 1;
    }
}
