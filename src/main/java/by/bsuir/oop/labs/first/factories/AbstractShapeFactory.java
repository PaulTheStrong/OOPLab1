package by.bsuir.oop.labs.first.factories;

import by.bsuir.oop.labs.first.shapes.AbstractShape;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public abstract class AbstractShapeFactory {

    public abstract AbstractShape createShape(GraphicsContext graphicsContext, Point2D startPoint);

}
