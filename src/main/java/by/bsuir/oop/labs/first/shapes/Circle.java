package by.bsuir.oop.labs.first.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class Circle extends Oval{

    public Circle(GraphicsContext graphicsContext, Point2D leftUpperCorner, double radius) {
        super(graphicsContext, leftUpperCorner, radius, radius);
    }


    @Override
    public void update(Point2D newPoint) {
        width = newPoint.getX() - leftUpperCorner.getX();
        height = newPoint.getY() - leftUpperCorner.getY();

        int widthSign = width > 0 ? 1 : -1;
        int heightSign = height > 0 ? 1 : -1;

        width = Math.abs(width);
        height = Math.abs(height);

        if (width < height) {
            height = width;
        } else {
            width = height;
        }

        width *= widthSign;
        height *= heightSign;

    }
}
