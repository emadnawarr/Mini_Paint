package backend;

import java.awt.Graphics;
import java.awt.Point;
import org.json.simple.JSONObject;

public class Triangle extends Shape {

    private Point point2;
    private Point point3;

    public Triangle(Point point1, Point point2, Point point3) {
        this.position = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    public Triangle(Triangle shape) {
        this.position = shape.position;
        this.color = shape.color;
        this.fillColor = shape.fillColor;
        this.point2 = shape.point2;
        this.point3 = shape.point3;
    }

    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(this.fillColor);
        canvas.fillPolygon(new int[]{this.position.x, this.point2.x, this.point3.x}, new int[]{this.position.y, this.point2.y, this.point3.y}, 3);
        canvas.setColor(this.color);
        canvas.drawPolygon(new int[]{this.position.x, this.point2.x, this.point3.x}, new int[]{this.position.y, this.point2.y, this.point3.y}, 3);
        
        if (isHighlighted) {
            drawHighlight(canvas);
        }
    }

    @Override
    public boolean contains(Point point) {
        double area = calculateArea(position, point2, point3);
        double a1 = calculateArea(point, point2, point3);
        double a2 = calculateArea(position, point, point3);
        double a3 = calculateArea(position, point2, point);

        return (area == a1 + a2 + a3);
    }

    static double calculateArea(Point p1, Point p2, Point p3) {
        return Math.abs((p1.x * (p2.y - p3.y) + p2.x * (p3.y - p1.y) + p3.x * (p1.y - p2.y)) / 2.0);
    }

    @Override
    public void moveTo(Point point) {
        int xDifference = (point.x + draggingPoint.x) - this.position.x;
        int yDifference = (point.y + draggingPoint.y) - this.position.y;

        setPosition(new Point(point.x + draggingPoint.x, point.y + draggingPoint.y));
        this.point2 = new Point(this.point2.x + xDifference, this.point2.y + yDifference);
        this.point3 = new Point(this.point3.x + xDifference, this.point3.y + yDifference);
        highlight();
    }

    @Override
    public JSONObject toJSONObject() {
        JSONObject shapeDetails = new JSONObject();
        JSONObject shapeObject = new JSONObject();
        shapeDetails.put("x1", position.x);
        shapeDetails.put("y1", position.y);
        shapeDetails.put("x2", point2.x);
        shapeDetails.put("y2", point2.y);
        shapeDetails.put("x3", point3.x);
        shapeDetails.put("y3", point3.y);
        shapeDetails.put("redF", getFillColor().getRed());
        shapeDetails.put("greenF", getFillColor().getGreen());
        shapeDetails.put("blueF", getFillColor().getBlue());
        shapeDetails.put("redB", getColor().getRed());
        shapeDetails.put("greenB", getColor().getGreen());
        shapeDetails.put("blueB", getColor().getBlue());
        shapeObject.put("Triangle", shapeDetails);
        return shapeObject;
    }

    @Override
    public void highlight() {
        this.setIsHighlighted(true);
        this.circleMarks.clear();
        Shape markCircle1 = new Oval(this.position, 5, 5);
        markCircle1.setIsMarker(true);
        this.circleMarks.add(markCircle1);

        Shape markCircle2 = new Oval(this.point2, 5, 5);
        this.circleMarks.add(markCircle2);
        markCircle2.setIsMarker(true);

        Shape markCircle3 = new Oval(this.point3, 5, 5);
        this.circleMarks.add(markCircle3);
        markCircle3.setIsMarker(true);

    }

    @Override
    public void resize() {

        this.position = new Point(this.getCircleMarks()[0].position.x, this.getCircleMarks()[0].position.y);
        this.point2 = new Point(this.getCircleMarks()[1].position.x, this.getCircleMarks()[1].position.y);
        this.point3 = new Point(this.getCircleMarks()[2].position.x, this.getCircleMarks()[2].position.y);
    }
}
