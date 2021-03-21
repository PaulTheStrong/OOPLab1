module core.ui {
    requires core.shapes;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.base;
    requires com.fasterxml.jackson.databind;

    exports by.bsuir.oop.labs.first;
    opens by.bsuir.oop.labs.first to javafx.graphics;
}