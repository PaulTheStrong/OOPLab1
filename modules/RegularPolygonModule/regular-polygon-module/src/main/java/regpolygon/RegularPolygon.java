package regpolygon;

import by.bsuir.oop.labs.core.shapes.AbstractShape;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class RegularPolygon extends AbstractShape {

    private Point2D center;
    private double radius;
    private int pointCount;
    private double angleRad;

    public RegularPolygon() {}

    public RegularPolygon(GraphicsContext graphicsContext, Point2D center, double radius, int pointCount, double angleRad) {
        super(graphicsContext);
        this.center = center;
        this.radius = radius;
        this.pointCount = pointCount;
        this.angleRad = angleRad;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        double[] xPoints = new double[pointCount];
        double[] yPoints = new double[pointCount];

        Point2D[] points = getPointList();
//        System.out.println(Arrays.toString(points));

        for (int i = 0; i < pointCount; i++) {
            xPoints[i] = points[i].getX();
            yPoints[i] = points[i].getY();
        }

        graphicsContext.strokePolygon(xPoints, yPoints, pointCount);
        graphicsContext.fillPolygon(xPoints, yPoints, pointCount);
    }

    @Override
    public void update(Point2D newPoint) {
        angleRad = calculateStartAngle(newPoint);
        double deltaX = newPoint.getX() - center.getX();
        double deltaY = -(newPoint.getY() - center.getY());
        radius = Math.hypot(deltaX, deltaY);
    }

    @Override
    public void addPoint(Point2D newPoint) {
        pointCount++;
    }

    public Point2D getCenter() {
        return center;
    }

    public void setCenter(Point2D center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getPointCount() {
        return pointCount;
    }

    public void setPointCount(int pointCount) {
        this.pointCount = pointCount;
    }

    public double getAngleRad() {
        return angleRad;
    }

    public void setAngleRad(double angleRad) {
        this.angleRad = angleRad;
    }

    private double calculateStartAngle(Point2D secondPoint) {
        double deltaX = secondPoint.getX() - center.getX();
        double deltaY = -(secondPoint.getY() - center.getY());
        double hypot = Math.hypot(deltaX, deltaY);
        double sin = deltaY / hypot;
        return Math.asin(sin);
    }

    private Point2D getPoint(double angle) {
        double dy = -radius * Math.sin(angle);
        double dx = radius * Math.cos(angle);
        return new Point2D(center.getX() + dx, center.getY() + dy);
    }

    private Point2D[] getPointList() {
        double deltaAngle = 2 * Math.PI / pointCount;
        Point2D[] result = new Point2D[pointCount];
        for (int i = 0; i < pointCount; i++) {
            result[i] = getPoint(angleRad + deltaAngle * i);
        }
        return result;
    }


}
