package by.bsuir.oop.labs.first.ui;

import by.bsuir.oop.labs.first.shapes.AbstractShape;
import by.bsuir.oop.labs.first.ui.elements.DrawArea;
import by.bsuir.oop.labs.first.ui.elements.LeftPanel;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;


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

        EventHandler<javafx.scene.input.KeyEvent> undo = new EventHandler<javafx.scene.input.KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.Z && event.isControlDown()) {
                    drawArea.getDrawHistory().undo();
                } else if (event.getCode() == KeyCode.U && event.isControlDown()) {
                    drawArea.getDrawHistory().redo();
                }
            }
        };

        addEventFilter(KeyEvent.KEY_PRESSED, undo);
    }

}
