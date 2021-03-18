package by.bsuir.oop.labs.first.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Polygon extends AbstractShape {

    private List<Point2D> points;

    public Polygon() {}

    public Polygon(GraphicsContext graphicsContext, Point2D... points) {
        super(graphicsContext);
        this.points = new ArrayList<>();
        Collections.addAll(this.points, points);
    }

    public List<Point2D> getPoints() {
        return points;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        updateGraphics(graphicsContext);
        double[] xPoints = new double[points.size()];
        double[] yPoints = new double[points.size()];

        for (int i = 0; i < points.size(); i++) {
            Point2D pt = points.get(i);
            xPoints[i] = pt.getX();
            yPoints[i] = pt.getY();
        }

        graphicsContext.fillPolygon(xPoints, yPoints, points.size());
        graphicsContext.strokePolygon(xPoints, yPoints, points.size());
    }

    @Override
    public void addPoint(Point2D newPoint) {
        points.add(newPoint);
    }

    @Override
    public void update(Point2D newPoint) {
        points.set(points.size() - 1, new Point2D(newPoint.getX(), newPoint.getY()));
    }
}


