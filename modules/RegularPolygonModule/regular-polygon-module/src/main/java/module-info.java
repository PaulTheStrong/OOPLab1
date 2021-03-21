import by.bsuir.oop.labs.core.shapes.AbstractShape;
import regpolygon.RegularPolygon;
import regpolygon.RegularPolygonFactory;
import by.bsuir.oop.labs.core.factories.AbstractShapeFactory;


module PentagonModule {
    requires core.shapes;
    requires javafx.graphics;
    requires com.fasterxml.jackson.databind;

    exports regpolygon;
    opens regpolygon to com.fasterxml.jackson.databind;

    provides AbstractShapeFactory with RegularPolygonFactory;
    provides AbstractShape with RegularPolygon;
}