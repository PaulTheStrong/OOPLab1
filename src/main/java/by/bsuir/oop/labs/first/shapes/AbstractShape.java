package by.bsuir.oop.labs.first.shapes;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public abstract class AbstractShape {

    protected Color strokeColor;
    protected Color fillColor;

    public abstract void draw(GraphicsContext graphicsContext);

    public abstract void primaryMouseClicked(MouseEvent event);
    public void secondaryMouseClicked(MouseEvent event) {}
    public abstract void mouseMoved(MouseEvent event);

}
