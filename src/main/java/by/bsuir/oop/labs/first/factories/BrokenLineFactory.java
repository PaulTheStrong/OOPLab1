package by.bsuir.oop.labs.first.factories;

import by.bsuir.oop.labs.first.shapes.BrokenLine;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class BrokenLineFactory extends AbstractShapeFactory {
    @Override
    public BrokenLine createShape(GraphicsContext graphicsContext, Point2D startPoint) {
        return new BrokenLine(graphicsContext, startPoint, startPoint);
    }
}
