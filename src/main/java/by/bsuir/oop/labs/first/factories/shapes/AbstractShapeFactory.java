package by.bsuir.oop.labs.first.factories.shapes;

import by.bsuir.oop.labs.first.shapes.AbstractShape;
import javafx.geometry.Point2D;

public abstract class AbstractShapeFactory {

    public abstract AbstractShape createShape(Point2D startPoint);

}
