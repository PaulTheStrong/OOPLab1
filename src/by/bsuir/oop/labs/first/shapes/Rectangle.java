package by.bsuir.oop.labs.first.shapes;

public class Rectangle extends AbstractShape {

    private Point2D leftDownCorner;
    private double width;
    private double height;

    public Rectangle(Point2D leftDownCorner, double width, double height) {
        this.leftDownCorner = leftDownCorner;
        this.width = width;
        this.height = height;
    }

    public Point2D getLeftDownCorner() {
        return leftDownCorner;
    }

    public void setLeftDownCorner(Point2D leftDownCorner) {
        this.leftDownCorner = leftDownCorner;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "leftDownCorner=" + leftDownCorner +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
