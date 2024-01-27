package backend;

public interface iDrawingEngine {

    /* manage shapes objects */
    public void addShape(Shape shape);

    public void removeShape(Shape shape);

    /* return the created shapes objects */
    public iShape[] getShapes();

    /* redraw all shapes on the canvas */
    public void refresh(java.awt.Graphics canvas);

}
