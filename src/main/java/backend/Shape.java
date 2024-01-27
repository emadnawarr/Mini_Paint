package backend;

import java.awt.Color;
import static java.awt.Color.black;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import org.json.simple.JSONObject;

public abstract class Shape implements iShape, Moveable {

    protected ArrayList<Shape> circleMarks = new ArrayList<>();
    protected Point position;
    protected Color color = black;
    protected Color fillColor = black;
    protected Point draggingPoint;
    protected boolean isHighlighted;
    protected boolean isMarker;

    @Override
    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public Point getPosition() {
        return this.position;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public void setFillColor(Color color) {
        this.fillColor = color;
    }

    @Override
    public Color getFillColor() {
        return this.fillColor;
    }

    @Override
    public void setDraggingPoint(Point draggingPoint) {
        this.draggingPoint = draggingPoint;
    }

    @Override
    public Point getDraggingPoint() {
        return this.draggingPoint;
    }

    public Shape[] getCircleMarks() {
        Shape[] circleMarksArray = new Shape[this.circleMarks.size()];
        circleMarksArray = this.circleMarks.toArray(circleMarksArray);
        return circleMarksArray;
    }

    public abstract void resize();

    @Override
    public abstract void draw(Graphics canvas);

    @Override
    public abstract JSONObject toJSONObject();

    @Override
    public abstract void highlight();

    public void dehighlight() {
        this.circleMarks.clear();
        this.setIsHighlighted(false);
    }

    public boolean isHighlighted() {
        return isHighlighted;
    }

    public void setIsHighlighted(boolean isHighlighted) {
        this.isHighlighted = isHighlighted;
    }

    public boolean isIsMarker() {
        return isMarker;
    }

    public void setIsMarker(boolean isMarker) {
        this.isMarker = isMarker;
    }

    public void drawHighlight(Graphics canvas) {
        for (Shape x : this.circleMarks) {
            x.draw(canvas);
        }
    }

}
