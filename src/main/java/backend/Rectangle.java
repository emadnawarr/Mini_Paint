package backend;

import java.awt.Graphics;
import java.awt.Point;
import org.json.simple.JSONObject;

public class Rectangle extends Shape {

    private int width;
    private int height;

    private Point rect1;
    private Point rect2;
    private Point rect3;
    private Point rect4;

    public Rectangle(Point position, int width, int height) {

        this.position = position;
        this.width = width;
        this.height = height;

        rect1 = new Point(position.x, position.y);
        rect2 = new Point(position.x + width, position.y);
        rect3 = new Point(position.x, position.y + height);
        rect4 = new Point(position.x + width, position.y + height);
    }

    public Rectangle(Rectangle shape) {
        this.position = shape.position;
        this.color = shape.color;
        this.fillColor = shape.fillColor;
        this.height = shape.height;
        this.width = shape.width;
    }

    @Override
    public void draw(Graphics canvas) {
//        System.out.println(this);
        canvas.setColor(this.fillColor);
        canvas.fillRect(position.x, position.y, width, height);
        canvas.setColor(this.color);
        canvas.drawRect(position.x, position.y, width, height);

        if (isHighlighted) {
            drawHighlight(canvas);
        }
    }

    @Override
    public boolean contains(Point point) {
        return this.position.x <= point.x && (this.position.x + this.width) >= point.x && this.position.y <= point.y && (this.position.y + this.height) >= point.y;
    }

    @Override
    public void moveTo(Point point) {
        setPosition(new Point(point.x + draggingPoint.x, point.y + draggingPoint.y));
        highlight();

    }

    @Override
    public JSONObject toJSONObject() {
        JSONObject shapeDetails = new JSONObject();
        JSONObject shapeObject = new JSONObject();
        shapeDetails.put("Position X", getPosition().x);
        shapeDetails.put("Position Y", getPosition().y);
        shapeDetails.put("Width", width);
        shapeDetails.put("Height", height);
        shapeDetails.put("redF", getFillColor().getRed());
        shapeDetails.put("greenF", getFillColor().getGreen());
        shapeDetails.put("blueF", getFillColor().getBlue());
        shapeDetails.put("redB", getColor().getRed());
        shapeDetails.put("greenB", getColor().getGreen());
        shapeDetails.put("blueB", getColor().getBlue());
        shapeObject.put("Rectangle", shapeDetails);
        return shapeObject;
    }

    @Override
    public void highlight() {

        this.setIsHighlighted(true);
        this.circleMarks.clear();

        Shape markCircle1 = new Oval(new Point(this.position.x, this.position.y), 5, 5);
        this.circleMarks.add(markCircle1);
        markCircle1.setIsMarker(true);

        Shape markCircle2 = new Oval(new Point(this.position.x + width, this.position.y), 5, 5);
        this.circleMarks.add(markCircle2);
        markCircle2.setIsMarker(true);

        Shape markCircle3 = new Oval(new Point(this.position.x, this.position.y + height), 5, 5);
        this.circleMarks.add(markCircle3);
        markCircle3.setIsMarker(true);

        Shape markCircle4 = new Oval(new Point(this.position.x + width, this.position.y + height), 5, 5);
        this.circleMarks.add(markCircle4);
        markCircle4.setIsMarker(true);
    }

    public void updateMarkers() {
        
        this.circleMarks.get(0).setPosition(new Point(this.position.x, this.position.y));
        this.circleMarks.get(1).setPosition(new Point(this.position.x + width, this.position.y));
        this.circleMarks.get(2).setPosition(new Point(this.position.x, this.position.y + height));
        this.circleMarks.get(3).setPosition(new Point(this.position.x + width, this.position.y + height));

    }

    @Override
    public void resize() {

        Point upperLeft = this.getCircleMarks()[0].position;
        Point upperRight = this.getCircleMarks()[1].position;
        Point lowerLeft = this.getCircleMarks()[2].position;
        Point lowerRight = this.getCircleMarks()[3].position;

        if (!upperLeft.equals(rect1)) {

            rect1 = new Point(upperLeft.x, upperLeft.y);
            rect2 = new Point(rect2.x, upperLeft.y);
            rect3 = new Point(upperLeft.x, rect3.y);

        } else if (!upperRight.equals(rect2)) {
            rect1 = new Point(rect1.x, upperRight.y);
            rect2 = new Point(upperRight.x, upperRight.y);
            rect4 = new Point(upperRight.x, rect4.y);

        } else if (!lowerLeft.equals(rect3)) {
            rect1 = new Point(lowerLeft.x, rect1.y);
            rect3 = new Point(lowerLeft.x, lowerLeft.y);
            rect4 = new Point(rect4.x, lowerLeft.y);

        } else if (!lowerRight.equals(rect4)) {
            rect2 = new Point(lowerRight.x, rect2.y);
            rect3 = new Point(rect3.x, lowerRight.y);
            rect4 = new Point(lowerRight.x, lowerRight.y);
        }

        this.width = rect4.x - rect1.x;
        this.height = rect4.y - rect1.y;
        this.position = rect1;

        if (width < 0) {
            width *= -1;
            this.position.x -= width;
        }
        if (height < 0) {
            height *= -1;
            this.position.y -= height;
        }

        updateMarkers();
        System.out.println(this);
        System.out.println("width" + width);
        System.out.println("height" + height);

        //replaceBasePoint();
    }

//    private void replaceBasePoint() {
//        if (rect1.x <= rect2.x && rect1.y <= rect3.y) {
//            System.out.println("first case");
//        } else if (rect1.x >= rect2.x && rect1.y <= rect3.y) {
//            rect1 = new Point(rect2);
//            rect2 = new Point(rect1);
//            System.out.println("second case");
//
//        } else if (rect1.x <= rect2.x && rect1.y >= rect3.y) {
//            rect1 = new Point(rect3);
//            rect3 = new Point(rect1);
//            System.out.println("third case");
//
//        } else if (rect1.x >= rect2.x && rect1.y >= rect3.y) {
//            rect1 = new Point(rect4);
//            rect4 = new Point(rect1);
//            System.out.println("fourth case");
//
//        }
//
//        this.width = rect4.x - rect1.x;
//        this.height = rect4.y - rect1.y;
//        this.position = rect1;
//        System.out.println(this);
//    }
    @Override
    public String toString() {
        String str = "";
        str += "\n";
        str += "upper left: " + rect1;
        str += "| upper right: " + rect2;
        str += "| lower left: " + rect3;
        str += "| lower right" + rect4;

        return str;
    }
}
