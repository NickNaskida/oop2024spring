package drawpad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DrawPadDemo {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Draw Pad");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            DrawPadPanel drawPadPanel = new DrawPadPanel();

            Shape circle = new Circle(Color.RED, 50);
            Shape triangle = new Triangle(Color.GREEN, 100);
            Shape rectangle = new Rectangle(Color.BLUE, 100, 50);

            drawPadPanel.addShape(circle);
            drawPadPanel.addShape(triangle);
            drawPadPanel.addShape(rectangle);

            Timer timer = new Timer(500, new ActionListener() {
                private double scaleFactor = 1.2;
                private boolean scaleUp = true;

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (scaleUp) {
                        circle.resize(scaleFactor);
                        triangle.resize(scaleFactor);
                        rectangle.resize(scaleFactor);
                    } else {
                        circle.resize(1 / scaleFactor);
                        triangle.resize(1 / scaleFactor);
                        rectangle.resize(1 / scaleFactor);
                    }
                    drawPadPanel.repaint();

                    // Toggle between scaling up and scaling down
                    scaleUp = !scaleUp;
                }
            });
            timer.start();

            frame.add(drawPadPanel);
            frame.setSize(800, 400);
            frame.setVisible(true);
        });
    }
}
