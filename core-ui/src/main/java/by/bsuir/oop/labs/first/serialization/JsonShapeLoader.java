package by.bsuir.oop.labs.first.serialization;

import by.bsuir.oop.labs.core.shapes.AbstractShape;
import by.bsuir.oop.labs.first.ModuleLoader;
import by.bsuir.oop.labs.first.ui.elements.DrawArea;
import by.bsuir.oop.labs.first.ui.elements.DrawHistory;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.module.SimpleModule;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonShapeLoader {

   public DrawHistory loadShapes(String filename, DrawArea drawArea) {
       ObjectMapper objectMapper = new ObjectMapper();
       List<AbstractShape> subtypes = new ModuleLoader().getAllShapes();
       for (AbstractShape subtype : subtypes) {
           objectMapper.registerSubtypes(new NamedType(subtype.getClass(), subtype.getClass().getName()));
       }
       SimpleModule module = new SimpleModule();
       module.setDeserializerModifier(new BeanDeserializerModifier() {
           @Override public JsonDeserializer<?> modifyDeserializer(
                   DeserializationConfig config, BeanDescription beanDesc, JsonDeserializer<?> deserializer) {
               if (beanDesc.getBeanClass() == Color.class) {
                   return new ColorJsonDeserializer();
               }
               else if (beanDesc.getBeanClass() == Point2D.class) {
                   return new Point2DJsonDeserializer();
               }
               return deserializer;
           }
       });
       objectMapper.registerModule(module);
       Canvas mainDrawArea = drawArea.getCanvases().get(0);
       DrawHistory drawHistory = drawArea.getDrawHistory();
        try {
            drawHistory = objectMapper.readValue(new File(filename), DrawHistory.class);
            drawHistory.setMainDrawArea(mainDrawArea);
        } catch (IOException e) {
            System.out.println("Error loading file" + e);
        }
        return drawHistory;
    }

}
