package trapezoid;

import by.bsuir.oop.labs.core.factories.AbstractShapeFactory;
import by.bsuir.oop.labs.core.shapes.AbstractShape;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class RegularPolygonFactory extends AbstractShapeFactory {
    @Override
    public AbstractShape createShape(GraphicsContext graphicsContext, Point2D startPoint) {
        return new RegularPolygon(graphicsContext, startPoint, 0, 3, 0);
    }

}
