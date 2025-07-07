/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
