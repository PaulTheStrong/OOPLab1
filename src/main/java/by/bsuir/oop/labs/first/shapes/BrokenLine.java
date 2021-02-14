package by.bsuir.oop.labs.first.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BrokenLine extends AbstractShape {

    private List<Point2D> points;

    public BrokenLine(Point2D... points) {
        if (points.length < 2) {
            throw new IllegalArgumentException();
        }
        this.points = new ArrayList<Point2D>();
        Collections.addAll(this.points, points);
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

    @Override
    public void primaryMouseClicked(MouseEvent event) {
        points.set(0, new Point2D(event.getX(), event.getY()));
    }

    @Override
    public void secondaryMouseClicked(MouseEvent event) {
        points.add(new Point2D(event.getX(), event.getY()));
    }

    @Override
    public void mouseMoved(MouseEvent event) {
        points.set(points.size() - 1, new Point2D(event.getX(), event.getY()));
    }
}
