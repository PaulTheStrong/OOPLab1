package by.bsuir.oop.labs.first.serialization;

import by.bsuir.oop.labs.core.shapes.AbstractShape;
import by.bsuir.oop.labs.first.ModuleLoader;
import by.bsuir.oop.labs.first.ui.elements.DrawHistory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonShapeSaver {

    public void saveShapes(DrawHistory drawHistory, String filename) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<AbstractShape> subtypes = new ModuleLoader().getAllShapes();
        for (AbstractShape subtype : subtypes) {
            objectMapper.registerSubtypes(new NamedType(subtype.getClass(), subtype.getClass().getName()));
        }
        try {
            objectMapper.writeValue(new File(filename), drawHistory);
        } catch (IOException e) {
            System.out.println("Error saving file" + e);
        }
    }

}
