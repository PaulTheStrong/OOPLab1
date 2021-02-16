package by.bsuir.oop.labs.first.ui.elements;

import by.bsuir.oop.labs.first.factories.shapes.AbstractShapeFactory;
import by.bsuir.oop.labs.first.factories.shapes.CircleFactory;
import by.bsuir.oop.labs.first.shapes.AbstractShape;
import by.bsuir.oop.labs.first.shapes.Polygon;
import by.bsuir.oop.labs.first.shapes.Rectangle;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.*;

import java.util.ArrayList;
import java.util.List;

public class DrawArea extends Parent {

    private Canvas mainDrawArea;
    private Canvas tempDrawArea;

    private List<AbstractShape> shapeHistory = new ArrayList<>();
    private int historyCount = 0;

    private boolean isDrawing;

    private AbstractShapeFactory factory = new CircleFactory();
    private AbstractShape shape;

    public AbstractShapeFactory getFactory() {
        return factory;
    }

    public void setFactory(AbstractShapeFactory factory) {
        this.factory = factory;
    }

    private void initHandlers() {
        EventHandler<MouseEvent> onClick = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!isDrawing) {
                    shape = factory.createShape(new Point2D(event.getX(), event.getY()));
                    isDrawing = !isDrawing;
                } else {
                    if (event.getButton() == MouseButton.SECONDARY) {
                        shape.addPoint(new Point2D(event.getX(), event.getY()));
                    } else {
                        shape.draw(mainDrawArea.getGraphicsContext2D());
                        tempDrawArea.getGraphicsContext2D().clearRect(0, 0, tempDrawArea.getWidth(), tempDrawArea.getHeight());
                        isDrawing = !isDrawing;
                        if (historyCount == shapeHistory.size()) {
                            shapeHistory.add(shape);
                        } else {
                            shapeHistory.set(historyCount, shape);
                        }
                        historyCount++;
                    }
                }
            }
        };

        EventHandler<MouseEvent> onDrag = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (isDrawing) {
                    tempDrawArea.getGraphicsContext2D().clearRect(0, 0, tempDrawArea.getWidth(), tempDrawArea.getHeight());
                    shape.update(new Point2D(event.getX(), event.getY()));
                    shape.draw(tempDrawArea.getGraphicsContext2D());
                }
            }
        };

        addEventFilter(MouseEvent.MOUSE_CLICKED, onClick);
        addEventFilter(MouseEvent.MOUSE_MOVED, onDrag);
    }

    public void undo() {
        if (historyCount == 0) {
            return;
        }
        historyCount--;
        mainDrawArea.getGraphicsContext2D().clearRect(0, 0, mainDrawArea.getWidth(), mainDrawArea.getHeight());
        GraphicsContext gc = mainDrawArea.getGraphicsContext2D();
        for(int i = 0; i < historyCount; i++) {
            shapeHistory.get(i).draw(gc);
        }
    }

    public void redo() {
        if (historyCount >= shapeHistory.size()) {
            return;
        }
        historyCount++;
        shapeHistory.get(historyCount - 1).draw(mainDrawArea.getGraphicsContext2D());
    }

    public DrawArea(double width, double height) {
        mainDrawArea = new Canvas(width, height);
        tempDrawArea = new Canvas(width, height);

        new Rectangle(new Point2D(0, 0), width, height)
                .draw(mainDrawArea.getGraphicsContext2D());

        new Polygon(new Point2D(3, 3), new Point2D(100, 100), new Point2D(200, 200))
                .draw(mainDrawArea.getGraphicsContext2D());

        mainDrawArea.getGraphicsContext2D().setLineWidth(5);
        tempDrawArea.getGraphicsContext2D().setLineWidth(6);

        getChildren().add(mainDrawArea);
        getChildren().add(tempDrawArea);

        isDrawing = false;
        initHandlers();
    }


}
