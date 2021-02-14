package by.bsuir.oop.labs.first;

import by.bsuir.oop.labs.first.shapes.*;
import by.bsuir.oop.labs.first.ui.PaintLayout;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class OOPPaint extends Application {

    public static void drawShapes(GraphicsContext graphicsContext) {
        List<AbstractShape> shapes = new ArrayList<>();
        shapes.add(new Rectangle(new Point2D(150, 50), 100, 120));
        shapes.add(new Circle(new Point2D(10, 10), 10));
        shapes.add(new Oval(new Point2D(200, 150), 30, 70));
        shapes.add(new Polygon(
                new Point2D(10, 10),
                new Point2D(30, 40),
                new Point2D(5, 100),
                new Point2D(250, 300)
        ));
        for (AbstractShape shape : shapes) {
            shape.draw(graphicsContext);
        }
    }

    @Override
    public void start(Stage primaryStage){
        primaryStage.setScene(new Scene(new PaintLayout()));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

