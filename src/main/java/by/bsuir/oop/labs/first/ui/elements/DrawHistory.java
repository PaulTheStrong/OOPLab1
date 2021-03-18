package by.bsuir.oop.labs.first.ui.elements;

import by.bsuir.oop.labs.first.shapes.AbstractShape;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(value = { "mainDrawArea" })
public class DrawHistory {
    private List<AbstractShape> shapeHistory = new ArrayList<>();
    private int historyCount = 0;
    private int maxCount = 0;

    private Canvas mainDrawArea;

    public DrawHistory() {

    }

    public DrawHistory(Canvas mainDrawArea) {
        this.mainDrawArea = mainDrawArea;
    }

    public void undo() {
        if (historyCount == 0) {
            return;
        }
        historyCount--;
    }

    public void redo() {
        if (historyCount >= maxCount) {
            return;
        }
        historyCount++;
        shapeHistory.get(historyCount - 1).draw(mainDrawArea.getGraphicsContext2D());
    }

    public void addShape(AbstractShape shape) {
        if (historyCount == shapeHistory.size()) {
            shapeHistory.add(shape);
        } else {
            shapeHistory.set(historyCount, shape);
        }
        historyCount++;
        maxCount = historyCount;
    }

    public List<AbstractShape> getShapeHistory() {
        return shapeHistory;
    }

    public void setShapeHistory(List<AbstractShape> shapeHistory) {
        this.shapeHistory = shapeHistory;
    }

    public int getHistoryCount() {
        return historyCount;
    }

    public void setHistoryCount(int historyCount) {
        this.historyCount = historyCount;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public Canvas getMainDrawArea() {
        return mainDrawArea;
    }

    public void setMainDrawArea(Canvas mainDrawArea) {
        this.mainDrawArea = mainDrawArea;
    }
}

