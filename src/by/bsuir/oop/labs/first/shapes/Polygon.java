package by.bsuir.oop.labs.first.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public class Polygon extends BrokenLine {

    public Polygon(Point2D... points) {
        super(points);
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        List<Point2D> points = getPoints();
        Point2D pt1 = points.get(0);
        Point2D pt2 = points.get(points.size() - 1);
        graphicsContext.strokeLine(pt1.getX(), pt1.getY(), pt2.getX(), pt2.getY());
    }
}


