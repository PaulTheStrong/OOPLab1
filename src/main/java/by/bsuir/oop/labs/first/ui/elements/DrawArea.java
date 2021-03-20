package by.bsuir.oop.labs.first.ui.elements;

import by.bsuir.oop.labs.first.factories.AbstractShapeFactory;
import by.bsuir.oop.labs.first.factories.RectangleFactory;
import by.bsuir.oop.labs.first.shapes.AbstractShape;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;

import java.util.Arrays;
import java.util.List;

public class DrawArea extends Parent {


    private final Canvas mainDrawArea;
    private final Canvas tempDrawArea;

    private DrawHistory drawHistory;

    private boolean isDrawing = false;

    private AbstractShapeFactory factory = new RectangleFactory();
    private AbstractShape shape;

    public DrawArea(double width, double height) {
        mainDrawArea = new Canvas(width, height);
        tempDrawArea = new Canvas(width, height);

        drawHistory = new DrawHistory(mainDrawArea);

        getChildren().add(mainDrawArea);
        getChildren().add(tempDrawArea);

        initHandlers();
    }

    public AbstractShapeFactory getFactory() {
        return factory;
    }

    public void setFactory(AbstractShapeFactory factory) {
        this.factory = factory;
    }

    public DrawHistory getDrawHistory() {
        return drawHistory;
    }

    public void setDrawHistory(DrawHistory drawHistory) {
        this.drawHistory = drawHistory;
    }

    public List<Canvas> getCanvases() {
        return Arrays.asList(mainDrawArea, tempDrawArea);
    }

    public void redraw() {
        mainDrawArea.getGraphicsContext2D().clearRect(0, 0, mainDrawArea.getWidth(), mainDrawArea.getHeight());
        GraphicsContext gc = mainDrawArea.getGraphicsContext2D();
        Paint strokeColor = gc.getStroke();
        double strokeWidth = gc.getLineWidth();
        Paint fillColor = gc.getFill();
        for(int i = 0; i < drawHistory.getHistoryCount(); i++) {
            drawHistory.getShapeHistory().get(i).draw(gc);
        }
        gc.setStroke(strokeColor);
        gc.setLineWidth(strokeWidth);
        gc.setFill(fillColor);
    }

    private void initHandlers() {
        EventHandler<MouseEvent> onClick = event -> {
            if (!isDrawing) {
                shape = factory.createShape(mainDrawArea.getGraphicsContext2D(), new Point2D(event.getX(), event.getY()));
                isDrawing = !isDrawing;
            } else {
                if (event.getButton() == MouseButton.SECONDARY) {
                    shape.addPoint(new Point2D(event.getX(), event.getY()));
                } else {
                    shape.draw(mainDrawArea.getGraphicsContext2D());
                    tempDrawArea.getGraphicsContext2D().clearRect(0, 0, tempDrawArea.getWidth(), tempDrawArea.getHeight());
                    isDrawing = !isDrawing;
                    drawHistory.addShape(shape);
                }
            }
        };

        EventHandler<MouseEvent> onDrag = event -> {
            if (isDrawing) {
                tempDrawArea.getGraphicsContext2D().clearRect(0, 0, tempDrawArea.getWidth(), tempDrawArea.getHeight());
                shape.update(new Point2D(event.getX(), event.getY()));
                shape.draw(tempDrawArea.getGraphicsContext2D());
            }
        };

        addEventFilter(MouseEvent.MOUSE_CLICKED, onClick);
        addEventFilter(MouseEvent.MOUSE_MOVED, onDrag);
    }

}
