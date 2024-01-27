package backend;

import java.awt.Graphics;
import java.awt.Point;
import org.json.simple.JSONObject;

public class Oval extends Shape {

    private int xRadius;
    private int yRadius;

    private Point rect1;
    private Point rect2;
    private Point rect3;
    private Point rect4;

    public Oval(Point position, int xRadius, int yRadius) {
        this.xRadius = xRadius;
        this.yRadius = yRadius;
        this.position = position;

        rect1 = new Point(this.position.x - xRadius, this.position.y - yRadius);
        rect2 = new Point(this.position.x + xRadius, this.position.y - yRadius);
        rect3 = new Point(this.position.x - xRadius, this.position.y + yRadius);
        rect4 = new Point(this.position.x + xRadius, this.position.y + yRadius);
    }

    public Oval(Oval shape) {

        this.position = shape.position;
        this.color = shape.color;
        this.fillColor = shape.fillColor;
        this.xRadius = shape.xRadius;
        this.yRadius = shape.yRadius;

    }

    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(this.fillColor);
        canvas.fillOval(this.position.x - xRadius, this.position.y - yRadius, this.xRadius * 2, this.yRadius * 2);
        canvas.setColor(this.color);
        canvas.drawOval(this.position.x - xRadius, this.position.y - yRadius, this.xRadius * 2, this.yRadius * 2);
        
//        System.out.println("rect1" + rect1);
//        System.out.println("rect2" + rect2);
//        System.out.println("rect3" + rect3);
//        System.out.println("rect4" + rect4);
//        System.out.println("center" + position);

        if (isHighlighted && !isIsMarker()) {
            drawHighlight(canvas);
        }
    }

    @Override
    public boolean contains(Point point) {
        return (Math.pow(point.x - this.position.x, 2) / Math.pow(this.xRadius, 2)) + (Math.pow(point.y - this.position.y, 2) / Math.pow(this.yRadius, 2)) <= 1;
    }

    @Override
    public void moveTo(Point point) {
        this.circleMarks.clear();
        setPosition(new Point(point.x + draggingPoint.x, point.y + draggingPoint.y));
        highlight();
    }

    @Override
    public JSONObject toJSONObject() {
        JSONObject shapeDetails = new JSONObject();
        JSONObject shapeObject = new JSONObject();
        shapeDetails.put("Position X", getPosition().x);
        shapeDetails.put("Position Y", getPosition().y);
        shapeDetails.put("Width", this.xRadius);
        shapeDetails.put("Height", this.yRadius);
        shapeDetails.put("redF", getFillColor().getRed());
        shapeDetails.put("greenF", getFillColor().getGreen());
        shapeDetails.put("blueF", getFillColor().getBlue());
        shapeDetails.put("redB", getColor().getRed());
        shapeDetails.put("greenB", getColor().getGreen());
        shapeDetails.put("blueB", getColor().getBlue());
        shapeObject.put("Oval", shapeDetails);
        return shapeObject;
    }

    @Override
    public void highlight() {

        this.setIsHighlighted(true);
        this.circleMarks.clear();

        Shape markCircle1 = new Oval(new Point(this.position.x - xRadius, this.position.y - yRadius), 5, 5);
        this.circleMarks.add(markCircle1);
        markCircle1.setIsMarker(true);

        Shape markCircle2 = new Oval(new Point(this.position.x + xRadius, this.position.y - yRadius), 5, 5);
        this.circleMarks.add(markCircle2);
        markCircle2.setIsMarker(true);

        Shape markCircle3 = new Oval(new Point(this.position.x - xRadius, this.position.y + yRadius), 5, 5);
        this.circleMarks.add(markCircle3);
        markCircle3.setIsMarker(true);

        Shape markCircle4 = new Oval(new Point(this.position.x + xRadius, this.position.y + yRadius), 5, 5);
        this.circleMarks.add(markCircle4);
        markCircle4.setIsMarker(true);
    }
    
    public void updateMarkers() {

        this.circleMarks.get(0).setPosition(new Point(this.position.x - xRadius, this.position.y - yRadius));
        this.circleMarks.get(1).setPosition(new Point(this.position.x + xRadius, this.position.y - yRadius));
        this.circleMarks.get(2).setPosition(new Point(this.position.x - xRadius, this.position.y + yRadius));
        this.circleMarks.get(3).setPosition(new Point(this.position.x + xRadius, this.position.y + yRadius));
        
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

        this.xRadius = (rect4.x - rect1.x)/2;
        this.yRadius = (rect4.y - rect1.y)/2;
        this.position.x = rect1.x + xRadius;
        this.position.y = rect1.y + yRadius;
//        this.position = new Point(rect1.x + xRadius, rect1.y + yRadius);
        
        if(xRadius<0){
            xRadius *= -1;
            getPosition().x -= xRadius;
        }
        if(yRadius<0){
            yRadius *= -1;
            getPosition().y -= yRadius;
        }
        
        updateMarkers();
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
//        this.xRadius = rect4.x - rect1.x;
//        this.yRadius = rect4.y - rect1.y;
//        this.position = new Point(rect1.x + xRadius, rect1.y + yRadius);
//        System.out.println(this);
//    }
    
}
