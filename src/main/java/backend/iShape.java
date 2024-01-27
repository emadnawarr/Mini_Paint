package backend;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import org.json.simple.JSONObject;

public interface iShape {

    /* set position */
    public void setPosition(Point position);

    public Point getPosition();

    /* colorize */
    public void setColor(Color color);

    public Color getColor();

    public void setFillColor(Color color);

    public java.awt.Color getFillColor();

    /* redraw the shape on the canvas */
    public void draw(Graphics canvas);

    public JSONObject toJSONObject();
    
    public void highlight();
    
    public void dehighlight();
}
