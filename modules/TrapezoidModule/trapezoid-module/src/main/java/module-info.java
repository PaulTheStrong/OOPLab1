import by.bsuir.oop.labs.core.shapes.AbstractShape;
import by.bsuir.oop.labs.core.factories.AbstractShapeFactory;
import trapezoid.Trapezoid;
import trapezoid.TrapezoidFactory;

module TrapezoidModule {
    requires core.shapes;
    requires javafx.graphics;
    requires com.fasterxml.jackson.databind;

    exports trapezoid;
    opens trapezoid to com.fasterxml.jackson.databind;

    provides AbstractShapeFactory with TrapezoidFactory;
    provides AbstractShape with Trapezoid;
}