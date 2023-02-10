package sppiningarrow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SpinArrow extends JFrame {
  private JButton startButton;
  private Arrow arrow;

  public SpinArrow() {
    startButton = new JButton("Start");
    arrow = new Arrow();

    startButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        startButton.setEnabled(false);
        arrow.startSpinning();
      }
    });

    add(startButton, BorderLayout.SOUTH);
    add(arrow, BorderLayout.CENTER);

    setSize(300, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  private class Arrow extends JComponent {
    private int angle;
    private Timer timer;

    public Arrow() {
      angle = 0;
      timer = new Timer(30, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          angle += 10;
          repaint();

          if (angle == 360) {
            timer.stop();
            angle = 0;
            int result = new Random().nextInt(4) * 90;
            arrow.setAngle(result);
            startButton.setEnabled(true);
          }
        }
      });
    }

    public void startSpinning() {
      timer.start();
    }

    public void setAngle(int angle) {
      this.angle = angle;
      repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D) g;
      g2d.rotate(Math.toRadians(angle), getWidth() / 2, getHeight() / 2);
      g2d.fillPolygon(new int[] { getWidth() / 2, getWidth() / 2 - 50, getWidth() / 2 + 50 },
          new int[] { getHeight() / 2, getHeight() / 2 + 50, getHeight() / 2 + 50 }, 3);
    }
  }

  public static void main(String[] args) {
    new SpinArrow();
  }
}
