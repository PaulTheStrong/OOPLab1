package by.bsuir.oop.labs.first.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public abstract class AbstractShape {

    protected Paint strokeColor;
    protected Paint fillColor;
    protected double strokeWidth;

    public abstract void draw(GraphicsContext graphicsContext);

    public void addPoint(Point2D newPoint) {}
    public abstract void update(Point2D newPoint);

    protected AbstractShape(GraphicsContext graphicsContext) {
        strokeColor = graphicsContext.getStroke();
        fillColor = graphicsContext.getFill();
        strokeWidth = graphicsContext.getLineWidth();
    }

    protected void updateGraphics(GraphicsContext graphicsContext) {
        graphicsContext.setStroke(strokeColor);
        graphicsContext.setLineWidth(strokeWidth);
        graphicsContext.setFill(fillColor);
    }
}
