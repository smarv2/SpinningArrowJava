package sppiningarrow;


import javax.swing.*;
import java.awt.*;

public class PruebaIconos extends JFrame {

    private final ImageIcon iconoAbrir = new ImageIcon("src/imagenes/candado.jpg");
    private final ImageIcon iconoCerrar = new ImageIcon("candado.jpg");
    private final ImageIcon iconoBorrar = new ImageIcon("imagenes/borrar.png");
    private final ImageIcon iconoGuardar = new ImageIcon("imagenes/guardar.jpg");

    public PruebaIconos() {
        setLayout(new GridLayout(1, 4, 5, 5));
        add(new JLabel(iconoAbrir));
        add(new JButton(iconoCerrar));
        add(new JButton(iconoBorrar));
        add(new JLabel(iconoGuardar));
    }

    public static void main(String[] args) {
        PruebaIconos frame = new PruebaIconos();
        frame.setTitle("PruebaIconos");
        frame.setSize(200, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
