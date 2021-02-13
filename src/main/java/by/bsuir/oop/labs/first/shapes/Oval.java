package by.bsuir.oop.labs.first.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class Oval extends AbstractShape {

    private Point2D center;
    private double width;
    private double height;

    public Oval(Point2D center, double width, double height) {
        this.center = center;
        this.width = width;
        this.height = height;
    }

    public Point2D getCenter() {
        return center;
    }

    public void setCenter(Point2D center) {
        this.center = center;
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
        graphicsContext.strokeOval(center.getX(), center.getY(), width, height);
    }
}
