package drawpad;

import java.awt.*;

public class Triangle extends AbstractShape {
    private double side;

    public Triangle(Color color, double side) {
        super(color);
        this.side = side;
    }

    public void resize(double factor) {
        this.side = this.side * factor;
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillPolygon(new int[]{300, 300 + (int) side, 300 + (int) (side / 2)},
                new int[]{50 + (int) side, 50 + (int) side, 50}, 3);
    }

    public double getArea() {
        return Math.sqrt(3) / 4 * side * side;
    }
}
