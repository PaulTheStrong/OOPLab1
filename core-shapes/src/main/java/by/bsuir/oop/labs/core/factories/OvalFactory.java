package by.bsuir.oop.labs.core.factories;

import by.bsuir.oop.labs.core.shapes.Oval;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class OvalFactory extends AbstractShapeFactory {
    @Override
    public Oval createShape(GraphicsContext graphicsContext, Point2D startPoint) {
        return new Oval(graphicsContext, startPoint, 0, 0);
    }
}
