package by.bsuir.oop.labs.first.ui.elements.pickers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrokeWidthPicker extends ComboBox<Double> {

    private double strokeWidth = 1;

    List<Canvas> canvasList;

    public void update() {
        for (Canvas canvas : canvasList) {
            canvas.getGraphicsContext2D().setLineWidth(getValue());
        }
    }

    public StrokeWidthPicker(List<Canvas> canvases) {
        canvasList = new ArrayList<>();
        canvasList.addAll(canvases);
        ObservableList<Double> items = getItems();

        for (int i = 1; i <= 10; i++) {
            items.add((double)i);
        }

        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                update();
            }
        });

        getSelectionModel().select(0);
    }

}
