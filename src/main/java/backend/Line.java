package backend;

import java.awt.Graphics;
import java.awt.Point;
import org.json.simple.JSONObject;

public class Line extends Shape {

    private Point endPosition;

    public Line(Point startPosition, Point endPosition) {

        this.position = startPosition;
        this.endPosition = endPosition;
    }

    public Line(Line shape) {
        this.position = shape.position;
        this.color = shape.color;
        this.fillColor = shape.fillColor;
        this.endPosition = shape.endPosition;
    }

    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(this.getColor());
        canvas.drawLine(this.position.x, this.position.y, this.endPosition.x, this.endPosition.y);
        if (isHighlighted) {
            drawHighlight(canvas);
        }
    }

    @Override
    public void resize() {
        this.position = new Point(this.getCircleMarks()[0].position.x, this.getCircleMarks()[0].position.y);
        this.endPosition = new Point(this.getCircleMarks()[1].position.x, this.getCircleMarks()[1].position.y);
    }

    public Point getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(Point endPosition) {
        this.endPosition = endPosition;
    }
    
    public double distance(Point a, Point b) {
        return Math.sqrt((a.getX()-b.getX())*(a.getX()-b.getX()) + (a.getY()-b.getY())*(a.getY()-b.getY()));
    }
    
    @Override
    public boolean contains(Point point) {
        return (distance(position, point) + distance(endPosition, point) == distance(position, endPosition));
    }

    @Override
    public void moveTo(Point point) {
        int xDifference = (point.x + draggingPoint.x) - this.position.x;
        int yDifference = (point.y + draggingPoint.y) - this.position.y;
        setPosition(new Point(point.x + draggingPoint.x, point.y + draggingPoint.y));
        this.endPosition = new Point(this.endPosition.x + xDifference, this.endPosition.y + yDifference);
        highlight();
    }

    @Override
    public void highlight() {
        this.setIsHighlighted(true);
        this.circleMarks.clear();
        Shape markCircle1 = new Oval(new Point(this.position), 5, 5);
        markCircle1.setIsMarker(true);
        this.circleMarks.add(markCircle1);
        Shape markCircle2 = new Oval(new Point(this.endPosition), 5, 5);
        markCircle2.setIsMarker(true);
        this.circleMarks.add(markCircle2);

    }

    @Override
    public JSONObject toJSONObject() {
        JSONObject shapeDetails = new JSONObject();
        JSONObject shapeObject = new JSONObject();
        shapeDetails.put("x1", position.x);
        shapeDetails.put("y1", position.y);
        shapeDetails.put("x2", endPosition.x);
        shapeDetails.put("y2", endPosition.y);
        shapeDetails.put("redF", getColor().getRed());
        shapeDetails.put("greenF", getColor().getGreen());
        shapeDetails.put("blueF", getColor().getBlue());
        shapeObject.put("Line", shapeDetails);
        return shapeObject;
    }
}
