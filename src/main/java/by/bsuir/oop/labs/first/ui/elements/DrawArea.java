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
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class DrawArea extends Parent {

    private Canvas mainDrawArea;
    private Canvas tempDrawArea;

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
                    shape = factory.createShape();
                    shape.primaryMouseClicked(event);
                    isDrawing = !isDrawing;
                } else {
                    if (event.getButton() == MouseButton.SECONDARY) {
                        shape.secondaryMouseClicked(event);
                    } else {
                        shape.draw(mainDrawArea.getGraphicsContext2D());
                        tempDrawArea.getGraphicsContext2D().clearRect(0, 0, tempDrawArea.getWidth(), tempDrawArea.getHeight());
                        isDrawing = !isDrawing;
                    }
                }
            }
        };

        EventHandler<MouseEvent> onDrag = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (isDrawing) {
                    tempDrawArea.getGraphicsContext2D().clearRect(0, 0, tempDrawArea.getWidth(), tempDrawArea.getHeight());
                    shape.mouseMoved(event);
                    shape.draw(tempDrawArea.getGraphicsContext2D());
                    shape.mouseMoved(event);
                }
            }
        };

        addEventFilter(MouseEvent.MOUSE_CLICKED, onClick);
        addEventFilter(MouseEvent.MOUSE_MOVED, onDrag);
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
