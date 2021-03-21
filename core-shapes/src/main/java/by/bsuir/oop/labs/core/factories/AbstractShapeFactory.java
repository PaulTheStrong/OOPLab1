package by.bsuir.oop.labs.core.factories;

import by.bsuir.oop.labs.core.shapes.AbstractShape;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

public abstract class AbstractShapeFactory {

    public abstract AbstractShape createShape(GraphicsContext graphicsContext, Point2D startPoint);

    public static List<AbstractShapeFactory> getServices(ModuleLayer layer) {
        return ServiceLoader
                .load(layer, AbstractShapeFactory.class)
                .stream()
                .map(ServiceLoader.Provider::get)
                .collect(Collectors.toList());
    }

}
