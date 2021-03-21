package trapezoid;

import by.bsuir.oop.labs.core.factories.AbstractShapeFactory;
import by.bsuir.oop.labs.core.shapes.AbstractShape;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class TrapezoidFactory extends AbstractShapeFactory {
    @Override
    public AbstractShape createShape(GraphicsContext graphicsContext, Point2D startPoint) {
        return new Trapezoid(graphicsContext, startPoint, 0, 0);
    }

}
