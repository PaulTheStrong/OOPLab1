package by.bsuir.oop.labs.first;

import by.bsuir.oop.labs.first.ui.PaintLayout;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class OOPPaint extends Application {
    @Override
    public void start(Stage primaryStage){
        primaryStage.setScene(new Scene(new PaintLayout()));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

