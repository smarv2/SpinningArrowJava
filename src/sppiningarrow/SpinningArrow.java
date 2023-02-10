package sppiningarrow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;

public class SpinningArrow extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton startButton;
    private JLabel arrowLabel;
    private Timer timer;
    private Random random;
    private int angle;
    int indice = 0;

    public SpinningArrow() {
        setLayout(new BorderLayout());

        startButton = new JButton("Iniciar");
        startButton.addActionListener(this);
        add(startButton, BorderLayout.SOUTH);

        arrowLabel = new JLabel(new ImageIcon("arrow.png"));
        add(arrowLabel, BorderLayout.CENTER);

        random = new Random();

        timer = new Timer(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angle += 5;
                arrowLabel.setIcon(new ImageIcon(getRotatedImage(angle)));
                if (angle >= 360) {
                    timer.stop();
                    angle = random.nextInt(360);
                    arrowLabel.setIcon(new ImageIcon(getRotatedImage(angle)));
                    int direction = angle / 90;
                    System.out.println("angle: " + angle);
                    System.out.println("direction: " + direction);
                    switch (direction) {
                        case 0:
                            JOptionPane.showMessageDialog(null, "Arriba");
                            break;
                        case 1:
                            JOptionPane.showMessageDialog(null, "Derecha");
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, "Abajo");
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(null, "Izquierda");
                            break;
                    }
                } else {
                	indice++;
                	System.out.println("no entra: " + indice);
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        angle = 0;
        timer.start();
    }

    /**
     * Metodo getRotatedImage.
     * @param angle
     * @return
     */
    private Image getRotatedImage(int angle) {
        //ImageIcon icon = new ImageIcon("candado.jpg");
        ImageIcon icon = new ImageIcon (SpinningArrow.class.getResource("arrow.png"));
        
        Image image = icon.getImage();
        int w = image.getWidth(null);
        int h = image.getHeight(null);
                
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = bi.createGraphics();
        double x = w / 2.0;
        double y = h / 2.0;
        g2.rotate(Math.toRadians(angle), x, y);
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
        return bi;
    }

    public static void main(String[] args) {
        SpinningArrow frame = new SpinningArrow();
        frame.setTitle("Spinning Arrow");
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}