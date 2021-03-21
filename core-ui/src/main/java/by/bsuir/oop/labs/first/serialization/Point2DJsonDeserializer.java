package by.bsuir.oop.labs.first.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.DoubleNode;
import javafx.geometry.Point2D;

import java.io.IOException;

public class Point2DJsonDeserializer extends JsonDeserializer<Point2D> {
    @Override
    public Point2D deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        TreeNode treeNode = p.getCodec().readTree(p);

        DoubleNode x = (DoubleNode) treeNode.get("x");
        DoubleNode y = (DoubleNode) treeNode.get("y");

        return new Point2D(x.doubleValue(), y.doubleValue());
    }
}

