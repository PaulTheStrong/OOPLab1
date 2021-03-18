package by.bsuir.oop.labs.first.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.sun.jdi.DoubleValue;
import javafx.scene.paint.Color;

import java.io.IOException;

public class ColorJsonDeserializer extends JsonDeserializer<Color> {

    @Override
    public Color deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        TreeNode treeNode = p.getCodec().readTree(p);

        DoubleNode red = (DoubleNode) treeNode.get("red");
        DoubleNode green = (DoubleNode) treeNode.get("green");
        DoubleNode blue = (DoubleNode) treeNode.get("blue");
        DoubleNode opacity = (DoubleNode) treeNode.get("opacity");

        return new Color(red.doubleValue(), green.doubleValue(), blue.doubleValue(), opacity.doubleValue());
    }
}
