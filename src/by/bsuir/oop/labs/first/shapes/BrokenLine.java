package by.bsuir.oop.labs.first.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BrokenLine extends AbstractShape {

    private List<Point2D> points;

    public BrokenLine(Point2D... points) {
        if (points.length < 2) {
            throw new IllegalArgumentException();
        }
        this.points = Arrays.asList(points);
    }

    public List<Point2D> getPoints() {
        return points;
    }

    public void setPoints(List<Point2D> points) {
        this.points = points;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        for (int i = 0; i < points.size() - 1; i++) {
            Point2D first = points.get(i);
            Point2D second = points.get(i + 1);
            graphicsContext.strokeLine(first.getX(), first.getY(), second.getX(), second.getY());
        }
    }
}
