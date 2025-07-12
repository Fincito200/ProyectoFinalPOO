package proyectofinalpoo;


import java.awt.Dimension;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import javax.swing.JOptionPane;


/**
 *
 * @author Aaron
 */
public class Principal extends javax.swing.JFrame {

    private String nombreJugador1 = "Jugador1";
    private String nombreJugador2 = "Jugador2";
    private Juego juego;
    private javax.swing.JLabel[] jlblCasillas;
    private Random random = new Random();
    
    public Principal() {
        initComponents();
        inicializarLabels();
        inicializarJuego();
        //dimensiones para el centro
        setMinimumSize(new Dimension(1320, 756));
        setSize(1320, 710);
        setLocationRelativeTo(null);
    }
    
    //casillas
    private void inicializarLabels() {
    jlblCasillas = new javax.swing.JLabel[12];
    jlblCasillas[0] = jlblInicio;
    jlblCasillas[1] = jlblCasilla2;
    jlblCasillas[2] = jlblCasilla3;
    jlblCasillas[3] = jlblCasilla4;
    jlblCasillas[4] = jlblCasilla5;
    jlblCasillas[5] = jlblCasilla6;
    jlblCasillas[6] = jlblCasilla7;
    jlblCasillas[7] = jlblCasilla8;
    jlblCasillas[8] = jlblCasilla9;
    jlblCasillas[9] = jlblCasilla10;
    jlblCasillas[10] = jlblCasilla11;
    jlblCasillas[11] = jlblCasilla12;
    }
    
    //actualiza las casillas y puntajes y comodines
    private void actualizarTablero() {
    // primero limpia las casillas y coloca nombre original correctamente
    for (int i = 0; i < jlblCasillas.length; i++) {
        if (i == 0) {
            jlblCasillas[i].setText("Inicio");
        } else {
            jlblCasillas[i].setText("Casilla " + (i + 1));
        }
    }

    // coloca jugadores
    for (Jugador jugador : juego.getJugadores()) {
        int pos = jugador.getPosicion();
        String marcador = jugador.getNombre().equals("Jugador 1") ? "J1" : "J2";

        // asegura que la posición no exceda los límites
        if (pos >= 0 && pos < jlblCasillas.length) {
            String textoActual = jlblCasillas[pos].getText();

            // si ya tiene J1 o J2, no duplicar, solo agregar si no está
            if (!textoActual.contains(marcador)) {
                jlblCasillas[pos].setText(textoActual + "-" + marcador);
            }
        }
    }
    // actualizar puntajes y comodines
    jlblPuntosJ1.setText("Puntos: " + juego.getJugadores().get(0).getPuntos());
    jlblPuntosJ2.setText("Puntos: " + juego.getJugadores().get(1).getPuntos());
    jlblComodinJ1.setText("Comodines: " + juego.getJugadores().get(0).getComodines());
    jlblComodinJ2.setText("Comodines: " + juego.getJugadores().get(1).getComodines());
    
    }
    
    //incia y actualiza
    private void inicializarJuego() {
    juego = new Juego();
    actualizarTablero();
    }
    
    //muestra el escore cuando llega a 100+
    private void mostrarScore() {
    // obtiene los jugadores
    Jugador j1 = juego.getJugadores().get(0);
    Jugador j2 = juego.getJugadores().get(1);
    
    //crea el resultado
    String resultado1 = j1.getNombre() + " puntos: " + j1.getPuntos() + " | Fallos: " + j1.getFallos();
    String resultado2 = j2.getNombre() + " puntos: " + j2.getPuntos() + " | Fallos: " + j2.getFallos();

    // determina ganador y perdedor
    String primero, segundo;
    if (j1.getPuntos() >= j2.getPuntos()) {
        primero = "1er Puesto: " + j1.getNombre();
        segundo = "2do Puesto: " + j2.getNombre();
    } else {
        primero = "1er Puesto: " + j2.getNombre();
        segundo = "2do Puesto: " + j1.getNombre();
    }

    // actualiza los labels de score
    jlblResultado1.setText(resultado1);
    jlblResultado2.setText(resultado2);
    jlblPuntos1.setText(primero);
    jlblPuntos2.setText(segundo);

    // Cambiar a la pestaña Score cuando termine la partida
    jtblMonopolyPrincipal.setSelectedIndex(3); // Ajusta con el índice de tu pestaña Score
    
    //exporta al txt
    exportarEstadisticas();
    }
    
    //txt creado
    private void exportarEstadisticas() {
        //crea el archivo con las estadisticas
    try {
        FileWriter fw = new FileWriter("Estadisticas.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        for (Jugador j : juego.getJugadores()) {
            bw.write("=====================================\n");
            bw.write("Jugador: " + j.getNombre() + "\n");
            bw.write("Puntaje: " + j.getPuntos() + "\n");
            bw.write("Fallos: " + j.getFallos() + "\n\n");
            bw.write(">>> Historial de preguntas:\n");
            
            for (RegistroPregunta r : j.getHistorial()) {
                bw.write(r.toString() + "\n");
            }
        }

        bw.close();
        fw.close();
        //confirma la creacion
        JOptionPane.showMessageDialog(null, "Estadísticas exportadas exitosamente en Estadisticas.txt");
        //sistema de error
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al exportar estadísticas.");
    }
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtblMonopolyPrincipal = new javax.swing.JTabbedPane();
        jpanelIntroduccion = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jtxtJ1 = new javax.swing.JTextField();
        jtxtJ2 = new javax.swing.JTextField();
        jbtnNombreConfirma = new javax.swing.JButton();
        jlblTitulo = new javax.swing.JLabel();
        jpanelMonopoly = new javax.swing.JPanel();
        jlblInicio = new javax.swing.JLabel();
        jlblCasilla12 = new javax.swing.JLabel();
        jlblCasilla2 = new javax.swing.JLabel();
        jlblCasilla3 = new javax.swing.JLabel();
        jlblCasilla4 = new javax.swing.JLabel();
        jlblCasilla5 = new javax.swing.JLabel();
        jlblCasilla6 = new javax.swing.JLabel();
        jlblCasilla7 = new javax.swing.JLabel();
        jlblCasilla8 = new javax.swing.JLabel();
        jlblCasilla9 = new javax.swing.JLabel();
        jlblCasilla10 = new javax.swing.JLabel();
        jlblCasilla11 = new javax.swing.JLabel();
        jpanelJ1 = new javax.swing.JPanel();
        jlblJ1 = new javax.swing.JLabel();
        jlblPuntosJ1 = new javax.swing.JLabel();
        jlblComodinJ1 = new javax.swing.JLabel();
        jpanelJ2 = new javax.swing.JPanel();
        jlblJ2 = new javax.swing.JLabel();
        jlblPuntosJ2 = new javax.swing.JLabel();
        jlblComodinJ2 = new javax.swing.JLabel();
        jlblNumeroDado = new javax.swing.JLabel();
        jbtnTirar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jpanelScore = new javax.swing.JPanel();
        jlblPuntos1 = new javax.swing.JLabel();
        jlblResultado1 = new javax.swing.JLabel();
        jlblPuntos2 = new javax.swing.JLabel();
        jlblResultado2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtblMonopolyPrincipal.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jtblMonopolyPrincipal.setForeground(new java.awt.Color(51, 51, 51));
        jtblMonopolyPrincipal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jpanelIntroduccion.setBackground(new java.awt.Color(255, 255, 255));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(245, 245, 220));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("El juego consiste en varias preguntas que constaran de unos enciados donde estudiaremos temas importantes como la suma, una operación básica que combina cantidades para obtener un total, y la resta, que consiste en encontrar la diferencia entre números. También aprenderemos sobre la multiplicación, una forma rápida de sumar grupos iguales, y la división, que nos ayuda a repartir cantidades en partes equitativas. Además, exploraremos la fascinante historia del Perú, desde sus antiguas civilizaciones como los incas hasta su desarrollo en la época colonial y republicana, conociendo sus grandes logros y desafíos. Por último, profundizaremos en la geografía peruana, analizando sus tres regiones naturales costa, sierra y selva, sus recursos, climas y las principales ciudades que conforman este diverso país. Estos temas nos darán una base sólida tanto en matemáticas como en el conocimiento de nuestro país.");
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        jtxtJ1.setBackground(new java.awt.Color(255, 255, 255));
        jtxtJ1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtJ1.setBorder(javax.swing.BorderFactory.createTitledBorder("Jugador1"));

        jtxtJ2.setBackground(new java.awt.Color(255, 255, 255));
        jtxtJ2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtJ2.setBorder(javax.swing.BorderFactory.createTitledBorder("Jugador2"));

        jbtnNombreConfirma.setBackground(new java.awt.Color(76, 175, 80));
        jbtnNombreConfirma.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jbtnNombreConfirma.setForeground(new java.awt.Color(255, 255, 255));
        jbtnNombreConfirma.setText("Confirmar Jugadores");
        jbtnNombreConfirma.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        jbtnNombreConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNombreConfirmaActionPerformed(evt);
            }
        });

        jlblTitulo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlblTitulo.setForeground(new java.awt.Color(0, 100, 0));
        jlblTitulo.setText("¡Aprende con Monopoly Educativo!");

        javax.swing.GroupLayout jpanelIntroduccionLayout = new javax.swing.GroupLayout(jpanelIntroduccion);
        jpanelIntroduccion.setLayout(jpanelIntroduccionLayout);
        jpanelIntroduccionLayout.setHorizontalGroup(
            jpanelIntroduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelIntroduccionLayout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(jtxtJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jtxtJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(220, 220, 220))
            .addGroup(jpanelIntroduccionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jpanelIntroduccionLayout.createSequentialGroup()
                .addGap(400, 400, 400)
                .addComponent(jlblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(551, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelIntroduccionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtnNombreConfirma, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(447, 447, 447))
        );
        jpanelIntroduccionLayout.setVerticalGroup(
            jpanelIntroduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelIntroduccionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanelIntroduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtnNombreConfirma, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        jtblMonopolyPrincipal.addTab("Introduccion", jpanelIntroduccion);

        jpanelMonopoly.setBackground(new java.awt.Color(245, 245, 245));
        jpanelMonopoly.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jlblInicio.setBackground(new java.awt.Color(255, 249, 196));
        jlblInicio.setFont(new java.awt.Font("Comic Sans MS", 0, 48)); // NOI18N
        jlblInicio.setForeground(new java.awt.Color(255, 153, 102));
        jlblInicio.setText("Inicio");
        jlblInicio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(46, 139, 87), 2, true));

        jlblCasilla12.setBackground(new java.awt.Color(255, 249, 196));
        jlblCasilla12.setFont(new java.awt.Font("Comic Sans MS", 0, 48)); // NOI18N
        jlblCasilla12.setForeground(new java.awt.Color(255, 153, 102));
        jlblCasilla12.setText("Casilla 12");
        jlblCasilla12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(46, 139, 87), 2));

        jlblCasilla2.setBackground(new java.awt.Color(255, 249, 196));
        jlblCasilla2.setFont(new java.awt.Font("Comic Sans MS", 0, 48)); // NOI18N
        jlblCasilla2.setForeground(new java.awt.Color(255, 153, 102));
        jlblCasilla2.setText("Casilla 2");
        jlblCasilla2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(46, 139, 87), 2));

        jlblCasilla3.setBackground(new java.awt.Color(255, 249, 196));
        jlblCasilla3.setFont(new java.awt.Font("Comic Sans MS", 0, 48)); // NOI18N
        jlblCasilla3.setForeground(new java.awt.Color(255, 153, 102));
        jlblCasilla3.setText("Casilla 3");
        jlblCasilla3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(46, 139, 87), 2));

        jlblCasilla4.setBackground(new java.awt.Color(255, 249, 196));
        jlblCasilla4.setFont(new java.awt.Font("Comic Sans MS", 0, 48)); // NOI18N
        jlblCasilla4.setForeground(new java.awt.Color(255, 153, 102));
        jlblCasilla4.setText("Casilla 4");
        jlblCasilla4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(46, 139, 87), 2));

        jlblCasilla5.setBackground(new java.awt.Color(255, 249, 196));
        jlblCasilla5.setFont(new java.awt.Font("Comic Sans MS", 0, 48)); // NOI18N
        jlblCasilla5.setForeground(new java.awt.Color(255, 153, 102));
        jlblCasilla5.setText("Casilla 5");
        jlblCasilla5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(46, 139, 87), 2));

        jlblCasilla6.setBackground(new java.awt.Color(255, 249, 196));
        jlblCasilla6.setFont(new java.awt.Font("Comic Sans MS", 0, 48)); // NOI18N
        jlblCasilla6.setForeground(new java.awt.Color(255, 153, 102));
        jlblCasilla6.setText("Casilla 6");
        jlblCasilla6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(46, 139, 87), 2));

        jlblCasilla7.setBackground(new java.awt.Color(255, 249, 196));
        jlblCasilla7.setFont(new java.awt.Font("Comic Sans MS", 0, 48)); // NOI18N
        jlblCasilla7.setForeground(new java.awt.Color(255, 153, 102));
        jlblCasilla7.setText("Casilla 7");
        jlblCasilla7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(46, 139, 87), 2));

        jlblCasilla8.setBackground(new java.awt.Color(255, 249, 196));
        jlblCasilla8.setFont(new java.awt.Font("Comic Sans MS", 0, 48)); // NOI18N
        jlblCasilla8.setForeground(new java.awt.Color(255, 153, 102));
        jlblCasilla8.setText("Casilla 8");
        jlblCasilla8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(46, 139, 87), 2));

        jlblCasilla9.setBackground(new java.awt.Color(255, 249, 196));
        jlblCasilla9.setFont(new java.awt.Font("Comic Sans MS", 0, 48)); // NOI18N
        jlblCasilla9.setForeground(new java.awt.Color(255, 153, 102));
        jlblCasilla9.setText("Casill 9");
        jlblCasilla9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(46, 139, 87), 2));

        jlblCasilla10.setBackground(new java.awt.Color(255, 249, 196));
        jlblCasilla10.setFont(new java.awt.Font("Comic Sans MS", 0, 48)); // NOI18N
        jlblCasilla10.setForeground(new java.awt.Color(255, 153, 102));
        jlblCasilla10.setText("Casilla 10");
        jlblCasilla10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(46, 139, 87), 2));

        jlblCasilla11.setBackground(new java.awt.Color(255, 249, 196));
        jlblCasilla11.setFont(new java.awt.Font("Comic Sans MS", 0, 48)); // NOI18N
        jlblCasilla11.setForeground(new java.awt.Color(255, 153, 102));
        jlblCasilla11.setText("Casilla 11");
        jlblCasilla11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(46, 139, 87), 2));

        jpanelJ1.setBackground(new java.awt.Color(227, 242, 253));
        jpanelJ1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jlblJ1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jlblJ1.setForeground(new java.awt.Color(255, 82, 82));
        jlblJ1.setText("Jugador 1");

        jlblPuntosJ1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jlblPuntosJ1.setText("Puntos: 0");

        jlblComodinJ1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jlblComodinJ1.setText("Comodines: 0");

        javax.swing.GroupLayout jpanelJ1Layout = new javax.swing.GroupLayout(jpanelJ1);
        jpanelJ1.setLayout(jpanelJ1Layout);
        jpanelJ1Layout.setHorizontalGroup(
            jpanelJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelJ1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jpanelJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblComodinJ1)
                    .addComponent(jlblPuntosJ1)
                    .addComponent(jlblJ1))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        jpanelJ1Layout.setVerticalGroup(
            jpanelJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelJ1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jlblJ1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlblPuntosJ1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlblComodinJ1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpanelJ2.setBackground(new java.awt.Color(255, 235, 238));
        jpanelJ2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jlblJ2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jlblJ2.setForeground(new java.awt.Color(68, 138, 255));
        jlblJ2.setText("Jugador 2");

        jlblPuntosJ2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jlblPuntosJ2.setText("Puntos: 0");

        jlblComodinJ2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jlblComodinJ2.setText("Comodines: 0");

        javax.swing.GroupLayout jpanelJ2Layout = new javax.swing.GroupLayout(jpanelJ2);
        jpanelJ2.setLayout(jpanelJ2Layout);
        jpanelJ2Layout.setHorizontalGroup(
            jpanelJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelJ2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jpanelJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblComodinJ2)
                    .addComponent(jlblPuntosJ2)
                    .addComponent(jlblJ2))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jpanelJ2Layout.setVerticalGroup(
            jpanelJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelJ2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jlblJ2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlblPuntosJ2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jlblComodinJ2))
        );

        jlblNumeroDado.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jlblNumeroDado.setText("1");

        jbtnTirar.setBackground(new java.awt.Color(33, 150, 243));
        jbtnTirar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jbtnTirar.setForeground(new java.awt.Color(255, 255, 255));
        jbtnTirar.setText("Tirar");
        jbtnTirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTirarActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalpoo/Sin-título-2.png"))); // NOI18N

        javax.swing.GroupLayout jpanelMonopolyLayout = new javax.swing.GroupLayout(jpanelMonopoly);
        jpanelMonopoly.setLayout(jpanelMonopolyLayout);
        jpanelMonopolyLayout.setHorizontalGroup(
            jpanelMonopolyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelMonopolyLayout.createSequentialGroup()
                .addGroup(jpanelMonopolyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelMonopolyLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jpanelMonopolyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpanelMonopolyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jlblCasilla11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlblCasilla12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE))
                            .addGroup(jpanelMonopolyLayout.createSequentialGroup()
                                .addGroup(jpanelMonopolyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jlblInicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlblCasilla10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpanelMonopolyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jlblCasilla9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlblCasilla2, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpanelMonopolyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlblCasilla3, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                            .addComponent(jlblCasilla8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpanelMonopolyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlblCasilla4, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                            .addComponent(jlblCasilla7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlblCasilla6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlblCasilla5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jpanelMonopolyLayout.createSequentialGroup()
                        .addGap(600, 600, 600)
                        .addComponent(jbtnTirar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpanelMonopolyLayout.createSequentialGroup()
                        .addGap(634, 634, 634)
                        .addComponent(jlblNumeroDado))
                    .addGroup(jpanelMonopolyLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(jpanelJ1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpanelJ2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(331, 331, 331))
        );
        jpanelMonopolyLayout.setVerticalGroup(
            jpanelMonopolyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelMonopolyLayout.createSequentialGroup()
                .addGroup(jpanelMonopolyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelMonopolyLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jpanelMonopolyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jpanelJ1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpanelJ2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelMonopolyLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jpanelMonopolyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblCasilla2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jpanelMonopolyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlblInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlblCasilla3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlblCasilla4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanelMonopolyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblCasilla12)
                    .addComponent(jlblCasilla5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanelMonopolyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblCasilla6)
                    .addComponent(jlblCasilla11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanelMonopolyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblCasilla10)
                    .addComponent(jlblCasilla9)
                    .addComponent(jlblCasilla8)
                    .addComponent(jlblCasilla7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addComponent(jlblNumeroDado, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnTirar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        jtblMonopolyPrincipal.addTab("Monopoly", jpanelMonopoly);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1270, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 645, Short.MAX_VALUE)
        );

        jtblMonopolyPrincipal.addTab("Correccion", jPanel3);

        jpanelScore.setBackground(new java.awt.Color(255, 255, 255));

        jlblPuntos1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlblPuntos1.setForeground(new java.awt.Color(0, 51, 102));
        jlblPuntos1.setText("1er Puesto: \"\"");
        jlblPuntos1.setBorder(javax.swing.BorderFactory.createTitledBorder("Puntuación"));

        jlblResultado1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlblResultado1.setForeground(new java.awt.Color(0, 51, 102));
        jlblResultado1.setText("Jugador X puntos: \"\" | Fallos: \"\"");
        jlblResultado1.setBorder(javax.swing.BorderFactory.createTitledBorder("Puntuación"));

        jlblPuntos2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlblPuntos2.setForeground(new java.awt.Color(0, 51, 102));
        jlblPuntos2.setText("2do Puesto: \"\"");
        jlblPuntos2.setBorder(javax.swing.BorderFactory.createTitledBorder("Puntuación"));

        jlblResultado2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlblResultado2.setForeground(new java.awt.Color(0, 51, 102));
        jlblResultado2.setText("Jugador X puntos: \"\" | Fallos: \"\"");
        jlblResultado2.setBorder(javax.swing.BorderFactory.createTitledBorder("Puntuación"));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalpoo/aaaaaa.gif"))); // NOI18N

        javax.swing.GroupLayout jpanelScoreLayout = new javax.swing.GroupLayout(jpanelScore);
        jpanelScore.setLayout(jpanelScoreLayout);
        jpanelScoreLayout.setHorizontalGroup(
            jpanelScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelScoreLayout.createSequentialGroup()
                .addContainerGap(217, Short.MAX_VALUE)
                .addGroup(jpanelScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelScoreLayout.createSequentialGroup()
                        .addGroup(jpanelScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblResultado1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlblPuntos1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(258, 258, 258)
                        .addGroup(jpanelScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblResultado2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlblPuntos2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(195, 195, 195))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelScoreLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(448, 448, 448))))
        );
        jpanelScoreLayout.setVerticalGroup(
            jpanelScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelScoreLayout.createSequentialGroup()
                .addGroup(jpanelScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelScoreLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jlblPuntos2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlblResultado2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpanelScoreLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jlblPuntos1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlblResultado1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jtblMonopolyPrincipal.addTab("Score", jpanelScore);

        getContentPane().add(jtblMonopolyPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 1290, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnNombreConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNombreConfirmaActionPerformed
        // TODO add your handling code here:
        String nombre1 = jtxtJ1.getText().trim();
        String nombre2 = jtxtJ2.getText().trim();
        
        //si no se coloca nombre en los jugadores
        if (nombre1.isEmpty() || nombre2.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor ingresa ambos nombres.");
            return;
        }

        // actualiza los labels con los nombres ingresados en el panel monopoly
        jlblJ1.setText(nombre1);
        jlblJ2.setText(nombre2);

        // deshabilita los campos de texto y el botón para que no se cambie para que no salga errores
        jtxtJ1.setEnabled(false);
        jtxtJ2.setEnabled(false);
        jbtnNombreConfirma.setEnabled(false);
    }//GEN-LAST:event_jbtnNombreConfirmaActionPerformed

    private void jbtnTirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTirarActionPerformed
        Jugador jugadorActual = juego.getJugadorActual();
        int dado = juego.getDado().tirar();
        jlblNumeroDado.setText("" + dado);

        // mover al jugador la casilla dependiendo del dado
        jugadorActual.mover(dado, jlblCasillas.length);

        // revisar si cae en casilla 5 y otorgar el comodín
        if (jugadorActual.getPosicion() == 5) {
            jugadorActual.ganarComodin();
            JOptionPane.showMessageDialog(this, jugadorActual.getNombre() + " ganó un comodín");
        }

        // mostrar pregunta del comodin
        boolean quiereUsarComodin = false;
        if (jugadorActual.getComodines() > 0) {
            int usar = JOptionPane.showConfirmDialog(this, jugadorActual.getNombre() + " ¿Quieres usar un comodín para saltar la pregunta?", "Usar comodín", JOptionPane.YES_NO_OPTION);
            if (usar == JOptionPane.YES_OPTION) {
                jugadorActual.usarComodin();
                quiereUsarComodin = true;
                JOptionPane.showMessageDialog(this, "Has usado un comodín. No respondes pregunta esta vez.");
            }
        }
        //si dice que no realiza la pregunta con normalidad
        if (!quiereUsarComodin) {
            Pregunta.hacerPregunta(this, jugadorActual);
        }

        actualizarTablero();

        // revisar si algún jugador llegó a 100 puntos y lleva al Score
        int puntosJ1 = juego.getJugadores().get(0).getPuntos();
        int puntosJ2 = juego.getJugadores().get(1).getPuntos();
        if (puntosJ1 >= 100 || puntosJ2 >= 100) {

            mostrarScore();
        }

        juego.siguienteTurno();
    }//GEN-LAST:event_jbtnTirarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton jbtnNombreConfirma;
    private javax.swing.JButton jbtnTirar;
    private javax.swing.JLabel jlblCasilla10;
    private javax.swing.JLabel jlblCasilla11;
    private javax.swing.JLabel jlblCasilla12;
    private javax.swing.JLabel jlblCasilla2;
    private javax.swing.JLabel jlblCasilla3;
    private javax.swing.JLabel jlblCasilla4;
    private javax.swing.JLabel jlblCasilla5;
    private javax.swing.JLabel jlblCasilla6;
    private javax.swing.JLabel jlblCasilla7;
    private javax.swing.JLabel jlblCasilla8;
    private javax.swing.JLabel jlblCasilla9;
    private javax.swing.JLabel jlblComodinJ1;
    private javax.swing.JLabel jlblComodinJ2;
    private javax.swing.JLabel jlblInicio;
    private javax.swing.JLabel jlblJ1;
    private javax.swing.JLabel jlblJ2;
    private javax.swing.JLabel jlblNumeroDado;
    private javax.swing.JLabel jlblPuntos1;
    private javax.swing.JLabel jlblPuntos2;
    private javax.swing.JLabel jlblPuntosJ1;
    private javax.swing.JLabel jlblPuntosJ2;
    private javax.swing.JLabel jlblResultado1;
    private javax.swing.JLabel jlblResultado2;
    private javax.swing.JLabel jlblTitulo;
    private javax.swing.JPanel jpanelIntroduccion;
    private javax.swing.JPanel jpanelJ1;
    private javax.swing.JPanel jpanelJ2;
    private javax.swing.JPanel jpanelMonopoly;
    private javax.swing.JPanel jpanelScore;
    private javax.swing.JTabbedPane jtblMonopolyPrincipal;
    private javax.swing.JTextField jtxtJ1;
    private javax.swing.JTextField jtxtJ2;
    // End of variables declaration//GEN-END:variables
}
