import by.bsuir.oop.labs.core.factories.*;
import by.bsuir.oop.labs.core.shapes.*;

module core.shapes {
    requires javafx.graphics;
    requires com.fasterxml.jackson.databind;

    exports by.bsuir.oop.labs.core.shapes;
    exports by.bsuir.oop.labs.core.factories;

    uses AbstractShape;
    uses AbstractShapeFactory;

    provides AbstractShape with Rectangle, Oval, Circle, BrokenLine, Polygon;
    provides AbstractShapeFactory with RectangleFactory, OvalFactory, CircleFactory, BrokenLineFactory, PolygonFactory;

}