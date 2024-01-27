package backend;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class DrawingArea extends JPanel implements iDrawingEngine {

    private final ArrayList<Shape> shapes;

    public DrawingArea() {
        shapes = new ArrayList<>();
    }

    @Override
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    @Override
    public void removeShape(Shape shape) {
        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) == shape) {
                shapes.remove(i);
            }
        }
    }

    @Override
    public Shape[] getShapes() {
        Shape[] shape = new Shape[shapes.size()];
        shape = shapes.toArray(shape);
        return shape;
    }

    public void dehighlightAllV2() {
        for (Shape shape : this.getShapes()) {
            shape.dehighlight();
        }
    }

    public boolean isHighlighted(Shape shape) {
        return !shape.circleMarks.isEmpty();
    }

    public void resizeShapes() {
        for (Shape shape : this.getShapes()) {
            if (shape.isHighlighted()) {
                shape.resize();
                break;
            }
        }
    }

    public void removeAllShapes() {
        shapes.clear();
    }

    @Override
    public void refresh(Graphics canvas) {
        for (Shape shape : this.getShapes()) {
            shape.draw(canvas);
        }
    }

    @Override
    public void paintComponent(Graphics canvas) {
        super.paintComponent(canvas);
        refresh(canvas);
    }
}
