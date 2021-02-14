package by.bsuir.oop.labs.first.ui;

import by.bsuir.oop.labs.first.shapes.Rectangle;
import by.bsuir.oop.labs.first.ui.elements.DrawArea;
import by.bsuir.oop.labs.first.ui.elements.LeftPanel;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import static by.bsuir.oop.labs.first.OOPPaint.drawShapes;

public class PaintLayout extends AnchorPane {

    public PaintLayout() {
        VBox buttons = new VBox(10);
        buttons.setMinHeight(500);
        buttons.setMinWidth(100);
        buttons.setStyle("-fx-border-color: red;");

        DrawArea drawArea = new DrawArea(500, 500);
        setLeftAnchor(drawArea, 100.);
        getChildren().add(new LeftPanel(drawArea));
        getChildren().add(drawArea);
    }

}
