package by.bsuir.oop.labs.first.shapes;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "className")
public abstract class AbstractShape {

    protected Color strokeColor;
    protected Color fillColor;
    protected double strokeWidth;

    public abstract void draw(GraphicsContext graphicsContext);

    public void addPoint(Point2D newPoint) {}
    public abstract void update(Point2D newPoint);

    public AbstractShape() {}

    public AbstractShape(GraphicsContext graphicsContext) {
        strokeColor = (Color) graphicsContext.getStroke();
        fillColor = (Color) graphicsContext.getFill();
        strokeWidth = graphicsContext.getLineWidth();
    }

    protected void updateGraphics(GraphicsContext graphicsContext) {
        graphicsContext.setStroke(strokeColor);
        graphicsContext.setLineWidth(strokeWidth);
        graphicsContext.setFill(fillColor);
    }

    public Color getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(Color strokeColor) {
        this.strokeColor = strokeColor;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public double getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(double strokeWidth) {
        this.strokeWidth = strokeWidth;
    }
}
