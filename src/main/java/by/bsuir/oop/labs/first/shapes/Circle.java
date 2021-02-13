package by.bsuir.oop.labs.first.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class Circle extends AbstractShape{

    private Point2D center;
    private double radius;

    public Circle(Point2D center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point2D getCenter() {
        return center;
    }

    public void setCenter(Point2D center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.strokeOval(center.getX(), center.getY(), radius, radius);
    }
}
