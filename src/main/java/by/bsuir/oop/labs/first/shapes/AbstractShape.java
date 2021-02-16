package by.bsuir.oop.labs.first.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public abstract class AbstractShape {

    protected Color strokeColor;
    protected Color fillColor;

    public abstract void draw(GraphicsContext graphicsContext);

    public void addPoint(Point2D newPoint) {}
    public abstract void update(Point2D newPoint);

}
