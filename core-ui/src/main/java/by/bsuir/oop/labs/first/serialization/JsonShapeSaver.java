package by.bsuir.oop.labs.first.serialization;

import by.bsuir.oop.labs.first.ui.elements.DrawHistory;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonShapeSaver {

    public void saveShapes(DrawHistory drawHistory, String filename) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(filename), drawHistory);
        } catch (IOException e) {
            System.out.println("Error saving file" + e);
        }
    }

}
