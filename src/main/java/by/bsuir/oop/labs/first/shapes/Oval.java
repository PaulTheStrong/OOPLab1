package by.bsuir.oop.labs.first.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class Oval extends AbstractShape {

    protected Point2D leftUpperCorner;
    protected double width;
    protected double height;

    public Oval(GraphicsContext graphicsContext, Point2D leftUpperCorner, double width, double height) {
        super(graphicsContext);
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
        updateGraphics(graphicsContext);
        graphicsContext.fillOval(width > 0 ? leftUpperCorner.getX() : leftUpperCorner.getX() + width,
                height > 0 ? leftUpperCorner.getY() : leftUpperCorner.getY() + height,
                Math.abs(width), Math.abs(height));
        graphicsContext.strokeOval(width > 0 ? leftUpperCorner.getX() : leftUpperCorner.getX() + width,
                                    height > 0 ? leftUpperCorner.getY() : leftUpperCorner.getY() + height,
                                    Math.abs(width), Math.abs(height));

    }

    @Override
    public void update(Point2D newPoint) {
        width = newPoint.getX() - leftUpperCorner.getX();
        height = newPoint.getY() - leftUpperCorner.getY();
    }
}
