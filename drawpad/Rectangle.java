package drawpad;

import java.awt.*;

public class Rectangle extends AbstractShape {
    private double width;
    private double height;

    public Rectangle(Color color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    public void resize(double factor) {
        this.width = this.width * factor;
        this.height = this.height * factor;
    }

    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect(50, 50, (int) width, (int) height);
    }

    public double getArea() {
        return width * height;
    }
}
