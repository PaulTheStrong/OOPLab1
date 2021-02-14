package by.bsuir.oop.labs.first.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class Circle extends AbstractShape{

    private Point2D leftUpperCorner;
    private double width;
    private double height;

    public Circle(Point2D leftUpperCorner, double radius) {
        this.leftUpperCorner = leftUpperCorner;
        this.width = radius;
        this.height = radius;
    }

    public Point2D getLeftUpperCorner() {
        return leftUpperCorner;
    }

    public void setLeftUpperCorner(Point2D leftUpperCorner) {
        this.leftUpperCorner = leftUpperCorner;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.strokeOval(width > 0 ? leftUpperCorner.getX() : leftUpperCorner.getX() + width,
                height > 0 ? leftUpperCorner.getY() : leftUpperCorner.getY() + height,
                Math.abs(width), Math.abs(height));
    }

    @Override
    public void primaryMouseClicked(MouseEvent event) {
        this.leftUpperCorner = new Point2D(event.getX(), event.getY());
    }

    @Override
    public void mouseMoved(MouseEvent event) {
        width = event.getX() - leftUpperCorner.getX();
        height = event.getY() - leftUpperCorner.getY();

        int widthSign = width > 0 ? 1 : -1;
        int heightSign = height > 0 ? 1 : -1;

        width = Math.abs(width);
        height = Math.abs(height);

        if (width < height) {
            height = width;
        } else {
            width = height;
        }

        width *= widthSign;
        height *= heightSign;

    }
}
