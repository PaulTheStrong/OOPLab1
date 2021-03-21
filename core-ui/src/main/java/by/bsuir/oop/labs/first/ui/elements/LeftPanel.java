package by.bsuir.oop.labs.first.ui.elements;

import by.bsuir.oop.labs.core.factories.*;
import by.bsuir.oop.labs.first.ModuleLoader;
import by.bsuir.oop.labs.first.serialization.JsonShapeLoader;
import by.bsuir.oop.labs.first.ui.elements.pickers.FillColorPicker;
import by.bsuir.oop.labs.first.ui.elements.pickers.StrokeColorPicker;
import by.bsuir.oop.labs.first.serialization.JsonShapeSaver;
import by.bsuir.oop.labs.first.ui.elements.pickers.StrokeWidthPicker;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class LeftPanel extends FlowPane {

    public LeftPanel(DrawArea drawArea) {
        setMaxWidth(100);
        ObservableList<Node> children = getChildren();
        setVgap(5);
        setHgap(10);
        setPadding(new Insets(5));
        List<Button> buttons = new ArrayList<>();
//        List<AbstractShapeFactory> factories = Arrays.asList(new RectangleFactory(), new OvalFactory(), new CircleFactory(), new PolygonFactory(), new BrokenLineFactory());
        List<AbstractShapeFactory> factories = new ModuleLoader().getAllFactories();
        System.out.println(Arrays.toString(factories.toArray()));
        List<String> names = Arrays.asList("Rectangle", "Circle", "Oval", "Polygon", "Broken");

        for (int i = 0; i <  factories.size(); i++) {
            AbstractShapeFactory factory = factories.get(i);
            Button btn = new Button(names.get(i));
            btn.setPrefSize(90, 15);
            btn.setOnMouseClicked(event -> drawArea.setFactory(factory));
            children.add(btn);
        }

        StrokeWidthPicker strokeWidthPicker = new StrokeWidthPicker(drawArea.getCanvases());
        strokeWidthPicker.setPrefSize(90, 10);
        children.add(strokeWidthPicker);

        StrokeColorPicker strokeColorPicker = new StrokeColorPicker(drawArea.getCanvases());
        strokeColorPicker.setMaxWidth(90);
        children.add(strokeColorPicker);

        FillColorPicker fillColorPicker = new FillColorPicker(drawArea.getCanvases());
        fillColorPicker.setMaxWidth(90);
        children.add(fillColorPicker);

        Button saveButton = new Button("Save");
        saveButton.setPrefWidth(90);
        children.add(saveButton);
        saveButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Выберите файл сохранения");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON", "*.json"));
            fileChooser.setInitialDirectory(new File("."));
            File file = fileChooser.showSaveDialog(getScene().getWindow());
            JsonShapeSaver saver = new JsonShapeSaver();
            saver.saveShapes(drawArea.getDrawHistory(), file.getAbsolutePath());
        });

        Button loadButton = new Button("Load");
        children.add(loadButton);
        loadButton.setPrefWidth(90);
        loadButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Выберите файл загрузки");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON", "*.json"));
            fileChooser.setInitialDirectory(new File("."));
            File file = fileChooser.showOpenDialog(getScene().getWindow());
            JsonShapeLoader loader = new JsonShapeLoader();
            DrawHistory drawHistory = loader.loadShapes(file.getAbsolutePath(), drawArea);
            drawArea.setDrawHistory(drawHistory);
            drawArea.redraw();
        });
    }

}
