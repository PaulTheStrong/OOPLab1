package by.bsuir.oop.labs.first.ui;

import by.bsuir.oop.labs.first.ui.elements.DrawArea;
import by.bsuir.oop.labs.first.ui.elements.LeftPanel;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;


public class PaintLayout extends AnchorPane {

    public PaintLayout() {
        DrawArea drawArea = new DrawArea(1200, 800);
        setLeftAnchor(drawArea, 100.);
        getChildren().add(new LeftPanel(drawArea));
        getChildren().add(drawArea);

        EventHandler<KeyEvent> eventHandler = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.Z && event.isControlDown()) {
                    drawArea.getDrawHistory().undo();
                    drawArea.redraw();
                } else if (event.getCode() == KeyCode.U && event.isControlDown()) {
                    drawArea.getDrawHistory().redo();
                }
            }
        };

        addEventFilter(KeyEvent.KEY_PRESSED, eventHandler);
    }

}
