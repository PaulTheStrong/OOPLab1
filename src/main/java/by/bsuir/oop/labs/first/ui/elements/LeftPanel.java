package by.bsuir.oop.labs.first.ui.elements;

import by.bsuir.oop.labs.first.factories.shapes.*;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeftPanel extends FlowPane {

    public LeftPanel(DrawArea drawArea) {
        setMaxWidth(100);
        ObservableList<Node> children = getChildren();
        setVgap(5);
        setHgap(10);
        setPadding(new Insets(5));
        List<Button> buttons = new ArrayList<>();
        List<AbstractShapeFactory> factories = Arrays.asList(new RectangleFactory(), new CircleFactory(), new OvalFactory(), new PolygonFactory(), new BrokenLineFactory());
        List<String> names = Arrays.asList("Rectangle", "Circle", "Oval", "Polygon", "Broken");

        for (int i = 0; i <  factories.size(); i++) {
            AbstractShapeFactory factory = factories.get(i);
            Button btn = new Button(names.get(i));
            btn.setPrefSize(90, 15);
            btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    drawArea.setFactory(factory);
                }
            });
            children.add(btn);
        }
        setStyle("-fx-background-color: purple");

        ColorPicker cp = new ColorPicker();
        cp.setPrefWidth(90);
        children.add(cp);
    }

}
