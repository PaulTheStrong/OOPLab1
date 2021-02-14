package by.bsuir.oop.labs.first.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class Rectangle extends AbstractShape {

    private Point2D leftUpperCorner;
    private double width;
    private double height;

    public Rectangle(Point2D leftUpperCorner, double width, double height) {
        this.leftUpperCorner = leftUpperCorner;
        this.width = width;
        this.height = height;
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
        graphicsContext.strokeRect(width > 0 ? leftUpperCorner.getX() : leftUpperCorner.getX() + width,
                                    height > 0 ? leftUpperCorner.getY() : leftUpperCorner.getY() + height,
                                    Math.abs(width), Math.abs(height));
    }

    @Override
    public void primaryMouseClicked(MouseEvent event) {
        leftUpperCorner = new Point2D(event.getX(), event.getY());
    }

    @Override
    public void mouseMoved(MouseEvent event) {
        width = event.getX() - leftUpperCorner.getX();
        height = event.getY() - leftUpperCorner.getY();
    }
}
