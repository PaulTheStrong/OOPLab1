package by.bsuir.oop.labs.first.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Polygon extends AbstractShape {

    private List<Point2D> points;

    public Polygon(Point2D... points) {
        this.points = new ArrayList<>();
        Collections.addAll(this.points, points);
    }

    public List<Point2D> getPoints() {
        return points;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        double[] xPoints = new double[points.size()];
        double[] yPoints = new double[points.size()];

        for (int i = 0; i < points.size(); i++) {
            Point2D pt = points.get(0);
            xPoints[i] = pt.getX();
            yPoints[i] = pt.getY();
        }

        graphicsContext.fillPolygon(xPoints, yPoints, points.size());
    }

    @Override
    public void primaryMouseClicked(MouseEvent event) {
        points.set(0, new Point2D(event.getX(), event.getY()));
    }

    @Override
    public void secondaryMouseClicked(MouseEvent event) {
        System.out.println(points);
        points.add(new Point2D(event.getX(), event.getY()));
    }

    @Override
    public void mouseMoved(MouseEvent event) {
        points.set(points.size() - 1, new Point2D(event.getX(), event.getY()));
    }
}


