package by.bsuir.oop.labs.first.ui.elements.pickers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class FillColorPicker extends ColorPicker {

    List<Canvas> canvases;

    public void update() {
        for (Canvas canvas : canvases) {
            canvas.getGraphicsContext2D().setFill(getValue());
        }
    }

    public FillColorPicker(List<Canvas> canvases) {
        this.canvases = new ArrayList<>();
        this.canvases.addAll(canvases);

        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                update();
            }
        });

        setValue(Color.WHITE);
        update();
    }
}
