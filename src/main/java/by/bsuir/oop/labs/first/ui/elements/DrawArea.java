package by.bsuir.oop.labs.first.ui.elements;

import by.bsuir.oop.labs.first.factories.shapes.AbstractShapeFactory;
import by.bsuir.oop.labs.first.factories.shapes.CircleFactory;
import by.bsuir.oop.labs.first.shapes.AbstractShape;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DrawArea extends Parent {

    public class DrawHistory {
        private List<AbstractShape> shapeHistory = new ArrayList<>();
        private int historyCount = 0;
        private int maxCount = 0;

        public void undo() {
            if (historyCount == 0) {
                return;
            }
            historyCount--;
            mainDrawArea.getGraphicsContext2D().clearRect(0, 0, mainDrawArea.getWidth(), mainDrawArea.getHeight());
            GraphicsContext gc = mainDrawArea.getGraphicsContext2D();
            Paint strokeColor = gc.getStroke();
            double strokeWidth = gc.getLineWidth();
            Paint fillColor = gc.getFill();
            for(int i = 0; i < historyCount; i++) {
                shapeHistory.get(i).draw(gc);
            }
            gc.setStroke(strokeColor);
            gc.setLineWidth(strokeWidth);
            gc.setFill(fillColor);
        }

        public void redo() {
            if (historyCount >= maxCount) {
                return;
            }
            historyCount++;
            shapeHistory.get(historyCount - 1).draw(mainDrawArea.getGraphicsContext2D());
        }

        public void addShape(AbstractShape shape) {
            if (historyCount == shapeHistory.size()) {
                shapeHistory.add(shape);
            } else {
                shapeHistory.set(historyCount, shape);
            }
            historyCount++;
            maxCount = historyCount;
        }
    }

    private Canvas mainDrawArea;
    private Canvas tempDrawArea;

    private DrawHistory drawHistory = new DrawHistory();

    private boolean isDrawing = false;

    private AbstractShapeFactory factory = new CircleFactory();
    private AbstractShape shape;

    public DrawArea(double width, double height) {
        mainDrawArea = new Canvas(width, height);
        tempDrawArea = new Canvas(width, height);

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

    public List<Canvas> getCanvases() {
        return Arrays.asList(mainDrawArea, tempDrawArea);
    }

    private void initHandlers() {
        EventHandler<MouseEvent> onClick = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
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

}
