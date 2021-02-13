package by.bsuir.oop.labs.first.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

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
        graphicsContext.strokeRect(leftUpperCorner.getX(), leftUpperCorner.getY(), width, height);
    }
}
