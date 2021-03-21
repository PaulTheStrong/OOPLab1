import by.bsuir.oop.labs.core.shapes.AbstractShape;
import trapezoid.RegularPolygon;
import trapezoid.RegularPolygonFactory;
import by.bsuir.oop.labs.core.factories.AbstractShapeFactory;


module PentagonModule {
    requires core.shapes;
    requires javafx.graphics;
    requires com.fasterxml.jackson.databind;

    exports trapezoid;
    opens trapezoid to com.fasterxml.jackson.databind;

    provides AbstractShapeFactory with RegularPolygonFactory;
    provides AbstractShape with RegularPolygon;
}