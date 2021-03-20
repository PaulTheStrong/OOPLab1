import by.bsuir.oop.labs.first.factories.*;
import by.bsuir.oop.labs.first.shapes.*;

module core {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires com.fasterxml.jackson.databind;

    opens by.bsuir.oop.labs.first to javafx.graphics,
            javafx.controls,
            javafx.base,
            com.fasterxml.jackson.databind;

    exports by.bsuir.oop.labs.first.shapes;
    exports by.bsuir.oop.labs.first.factories;

    uses AbstractShape;
    uses AbstractShapeFactory;

    provides AbstractShape with Rectangle, Oval, Circle, BrokenLine, Polygon;
    provides AbstractShapeFactory with RectangleFactory, OvalFactory, CircleFactory, BrokenLineFactory, PolygonFactory;
}