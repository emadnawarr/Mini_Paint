package frontend;

import backend.Shape;
import backend.DrawingArea;
import backend.Line;
import backend.Oval;
import backend.Rectangle;
import backend.Triangle;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
//////////////////////////////////////////colorssss
//////////////////////////////////////////isinteger

public class DrawingApplication extends JFrame implements MouseListener, MouseMotionListener, Navigate {

    private Shape selectedShape;
    private AddRectangle addRectangleWindow;
    private AddLine addLineWindow;
    private AddOval addOvalWindow;
    private AddTriangle addTriangleWindow;
    private int numOfLines = 0;
    private int numOfRectangles = 0;
    private int numOfOvals = 0;
    private int numOfTriangles = 0;

    public DrawingApplication() {

        canvas = new DrawingArea();
        initComponents();
        canvas.addMouseListener(this);
        canvas.addMouseMotionListener(this);
        this.shapesChooser.add("Choose shape...");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        lineSegmentButton = new javax.swing.JButton();
        ovalButton = new javax.swing.JButton();
        rectangleButton = new javax.swing.JButton();
        shapesChooser = new java.awt.Choice();
        colorizeOutlinesButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        colorizeFillingButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        triangleButton = new javax.swing.JButton();
        canvas = new backend.DrawingArea();
        copyButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        saveMenuButton = new javax.swing.JMenuItem();
        loadMenuButton = new javax.swing.JMenuItem();

        jMenu2.setText("jMenu2");

        jMenu3.setText("jMenu3");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Drawing Application");
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowIconified(java.awt.event.WindowEvent evt) {
                formWindowIconified(evt);
            }
        });

        lineSegmentButton.setText("Line Segment");
        lineSegmentButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lineSegmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineSegmentButtonActionPerformed(evt);
            }
        });

        ovalButton.setText("Oval");
        ovalButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ovalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ovalButtonActionPerformed(evt);
            }
        });

        rectangleButton.setText("Rectangle");
        rectangleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rectangleButtonActionPerformed(evt);
            }
        });

        shapesChooser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        shapesChooser.setName("Choose Shape"); // NOI18N

        colorizeOutlinesButton.setText("Colorize Outline");
        colorizeOutlinesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorizeOutlinesButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        colorizeFillingButton.setText("Colorize Filling");
        colorizeFillingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorizeFillingButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Select Shape");

        triangleButton.setText("Triangle");
        triangleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        triangleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                triangleButtonActionPerformed(evt);
            }
        });

        canvas.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout canvasLayout = new javax.swing.GroupLayout(canvas);
        canvas.setLayout(canvasLayout);
        canvasLayout.setHorizontalGroup(
            canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 638, Short.MAX_VALUE)
        );
        canvasLayout.setVerticalGroup(
            canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        copyButton.setText("Copy");
        copyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyButtonActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        saveMenuButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        saveMenuButton.setText("Save As");
        saveMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuButtonActionPerformed(evt);
            }
        });
        jMenu1.add(saveMenuButton);

        loadMenuButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        loadMenuButton.setText("Load");
        loadMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadMenuButtonActionPerformed(evt);
            }
        });
        jMenu1.add(loadMenuButton);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(shapesChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(deleteButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(copyButton))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(colorizeOutlinesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(colorizeFillingButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(canvas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lineSegmentButton)
                        .addGap(44, 44, 44)
                        .addComponent(ovalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(rectangleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(triangleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(triangleButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rectangleButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ovalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lineSegmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(shapesChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deleteButton)
                            .addComponent(copyButton))
                        .addGap(18, 18, 18)
                        .addComponent(colorizeOutlinesButton)
                        .addGap(18, 18, 18)
                        .addComponent(colorizeFillingButton)
                        .addGap(119, 119, 119))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(canvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        shapesChooser.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lineSegmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineSegmentButtonActionPerformed

        if (this.addLineWindow == null) {
            this.addLineWindow = new AddLine();
        }
        this.setVisible(false);
        addLineWindow.setParentNavigate(this);
        addLineWindow.setVisible(true);

    }//GEN-LAST:event_lineSegmentButtonActionPerformed

    public void addLine(Shape newLine) {
        canvas.addShape(newLine);
        shapesChooser.add("Line #" + ++this.numOfLines);
        canvas.repaint();
    }

    private void rectangleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rectangleButtonActionPerformed

        if (this.addRectangleWindow == null) {
            this.addRectangleWindow = new AddRectangle();
        }
        this.setVisible(false);
        addRectangleWindow.setParentNavigate(this);
        addRectangleWindow.setVisible(true);
    }//GEN-LAST:event_rectangleButtonActionPerformed

    public void addRectangle(Shape newRectangle) {
        canvas.addShape(newRectangle);
        shapesChooser.add("Rectangle #" + ++this.numOfRectangles);
        canvas.repaint();
    }

    private void ovalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ovalButtonActionPerformed
        // TODO add your handling code here:
        if (this.addOvalWindow == null) {
            this.addOvalWindow = new AddOval();
        }
        this.setVisible(false);
        addOvalWindow.setParentNavigate(this);
        addOvalWindow.setVisible(true);
    }//GEN-LAST:event_ovalButtonActionPerformed

    public void addOval(Shape newOval) {
        canvas.addShape(newOval);
        shapesChooser.add("Oval #" + ++this.numOfOvals);
        canvas.repaint();
    }

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        if (!shapesChooser.getSelectedItem().equals("Choose shape...")) {
            canvas.removeShape(getShapeFromChooser(shapesChooser.getSelectedIndex()));
            canvas.repaint();
            shapesChooser.remove(shapesChooser.getSelectedItem());
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void colorizeOutlinesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorizeOutlinesButtonActionPerformed
        // TODO add your handling code here:
        if (!shapesChooser.getSelectedItem().equals("Choose shape...")) {
            Color color = JColorChooser.showDialog(this.canvas, "Colorize", Color.white);
            Shape shape = getShapeFromChooser(shapesChooser.getSelectedIndex());
            shape.setColor(color);
            canvas.repaint();
        }
    }//GEN-LAST:event_colorizeOutlinesButtonActionPerformed

    private void colorizeFillingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorizeFillingButtonActionPerformed
        // TODO add your handling code here:
        if (!shapesChooser.getSelectedItem().equals("Choose shape...")) {
            Color color = JColorChooser.showDialog(this.canvas, "Colorize", Color.white);
            Shape shape = getShapeFromChooser(shapesChooser.getSelectedIndex());
            shape.setFillColor(color);
            canvas.repaint();
        }
    }//GEN-LAST:event_colorizeFillingButtonActionPerformed

    private void triangleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_triangleButtonActionPerformed
        // TODO add your handling code here:
        if (this.addTriangleWindow == null) {
            this.addTriangleWindow = new AddTriangle();
        }
        this.setVisible(false);
        addTriangleWindow.setParentNavigate(this);
        addTriangleWindow.setVisible(true);
    }//GEN-LAST:event_triangleButtonActionPerformed

    public void addTriangle(Shape newTriangle) {
        canvas.addShape(newTriangle);
        shapesChooser.add("Triangle #" + ++this.numOfTriangles);
        canvas.repaint();
    }

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void formWindowIconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowIconified
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowIconified

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowStateChanged

    private void copyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyButtonActionPerformed

        if (!shapesChooser.getSelectedItem().equals("Choose shape...")) {
            selectedShape = getShapeFromChooser(shapesChooser.getSelectedIndex());
            if (selectedShape.getClass() == Line.class) {
                Shape newLine = new Line((Line) selectedShape);
                addLine(newLine);
            } else if (selectedShape.getClass() == Rectangle.class) {
                Shape newRect = new Rectangle((Rectangle) selectedShape);
                addRectangle(newRect);
            } else if (selectedShape.getClass() == Oval.class) {
                Shape newOval = new Oval((Oval) selectedShape);
                addOval(newOval);
            } else if (selectedShape.getClass() == Triangle.class) {
                Shape newTriangle = new Triangle((Triangle) selectedShape);
                addTriangle(newTriangle);
            }
        }
        shapesChooser.select(shapesChooser.getItemCount() - 1);
    }//GEN-LAST:event_copyButtonActionPerformed

    private void saveMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuButtonActionPerformed

        JSONArray jArray = new JSONArray();

        for (Shape shape : canvas.getShapes()) {
            jArray.add(shape.toJSONObject());
        }
        JFrame parentFrame = new JFrame();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save location...");

        int userSelection = fileChooser.showSaveDialog(parentFrame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try ( FileWriter file = new FileWriter(fileToSave)) {
                file.write(jArray.toJSONString());
                file.close();

            } catch (IOException e) {
            }
        }
    }//GEN-LAST:event_saveMenuButtonActionPerformed

    private void parseShapeObject(JSONObject shape) throws NullPointerException {
        try {
            JSONObject shapeObject = (JSONObject) shape.get("Line");
            Point p1 = new Point(Integer.parseInt(shapeObject.get("x1").toString()), Integer.parseInt(shapeObject.get("y1").toString()));
            Point p2 = new Point(Integer.parseInt(shapeObject.get("x2").toString()), Integer.parseInt(shapeObject.get("y2").toString()));
            Color c = new Color(Integer.parseInt(shapeObject.get("redF").toString()), Integer.parseInt(shapeObject.get("greenF").toString()), Integer.parseInt(shapeObject.get("blueF").toString()));
            Shape line = new Line(p1, p2);
            line.setColor(c);
            this.addLine(line);
            canvas.repaint();

        } catch (NullPointerException e) {
            try {
                JSONObject shapeObject = (JSONObject) shape.get("Triangle");
                //load for tri
                Point p1 = new Point(Integer.parseInt(shapeObject.get("x1").toString()), Integer.parseInt(shapeObject.get("y1").toString()));
                Point p2 = new Point(Integer.parseInt(shapeObject.get("x2").toString()), Integer.parseInt(shapeObject.get("y2").toString()));
                Point p3 = new Point(Integer.parseInt(shapeObject.get("x3").toString()), Integer.parseInt(shapeObject.get("y3").toString()));
                Color fColor = new Color(Integer.parseInt(shapeObject.get("redF").toString()), Integer.parseInt(shapeObject.get("greenF").toString()), Integer.parseInt(shapeObject.get("blueF").toString()));
                Color bColor = new Color(Integer.parseInt(shapeObject.get("redB").toString()), Integer.parseInt(shapeObject.get("greenB").toString()), Integer.parseInt(shapeObject.get("blueB").toString()));
                Shape tri = new Triangle(p1, p2, p3);
                tri.setFillColor(fColor);
                tri.setColor(bColor);
                this.addTriangle(tri);
                canvas.repaint();
            } catch (NullPointerException d) {
                try {
                    JSONObject shapeObject = (JSONObject) shape.get("Rectangle");
                    //load for rect
                    Point position = new Point(Integer.parseInt(shapeObject.get("Position X").toString()), Integer.parseInt(shapeObject.get("Position Y").toString()));
                    int width = Integer.parseInt(shapeObject.get("Width").toString());
                    int height = Integer.parseInt(shapeObject.get("Height").toString());
                    Color fColor = new Color(Integer.parseInt(shapeObject.get("redF").toString()), Integer.parseInt(shapeObject.get("greenF").toString()), Integer.parseInt(shapeObject.get("blueF").toString()));
                    Color bColor = new Color(Integer.parseInt(shapeObject.get("redB").toString()), Integer.parseInt(shapeObject.get("greenB").toString()), Integer.parseInt(shapeObject.get("blueB").toString()));
                    Shape rect = new Rectangle(position, width, height);
                    rect.setFillColor(fColor);
                    rect.setColor(bColor);
                    this.addRectangle(rect);
                    canvas.repaint();
                } catch (NullPointerException z) {
                    try {
                        JSONObject shapeObject = (JSONObject) shape.get("Oval");
                        Point position = new Point(Integer.parseInt(shapeObject.get("Position X").toString()), Integer.parseInt(shapeObject.get("Position Y").toString()));
                        int width = Integer.parseInt(shapeObject.get("Width").toString());
                        int height = Integer.parseInt(shapeObject.get("Height").toString());
                        Color fColor = new Color(Integer.parseInt(shapeObject.get("redF").toString()), Integer.parseInt(shapeObject.get("greenF").toString()), Integer.parseInt(shapeObject.get("blueF").toString()));
                        Color bColor = new Color(Integer.parseInt(shapeObject.get("redB").toString()), Integer.parseInt(shapeObject.get("greenB").toString()), Integer.parseInt(shapeObject.get("blueB").toString()));
                        Shape oval = new Oval(position, width, height);
                        oval.setFillColor(fColor);
                        oval.setColor(bColor);
                        this.addOval(oval);
                        canvas.repaint();
                        //load for oval
                    } catch (NullPointerException x) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void loadMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadMenuButtonActionPerformed

        JFileChooser fileChooser = new JFileChooser();
        JSONParser parser = new JSONParser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {

            File fileToRead = fileChooser.getSelectedFile();
            try ( FileReader myReader = new FileReader(fileToRead)) {
                Object obj = parser.parse(myReader);
                canvas.removeAllShapes();
                canvas.dehighlightAllV2();
                shapesChooser.removeAll();
                shapesChooser.add("Choose shape...");
                JSONArray shapeList = (JSONArray) obj;
                shapeList.forEach(shp -> parseShapeObject((JSONObject) shp));
                myReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (org.json.simple.parser.ParseException ex) {
                Logger.getLogger(DrawingApplication.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_loadMenuButtonActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new DrawingApplication().setVisible(true);
        });
    }

    private Shape getShapeFromChooser(int idx) {
        return canvas.getShapes()[idx - 1];
    }

    public boolean isInteger(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private backend.DrawingArea canvas;
    private javax.swing.JButton colorizeFillingButton;
    private javax.swing.JButton colorizeOutlinesButton;
    private javax.swing.JButton copyButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JButton lineSegmentButton;
    private javax.swing.JMenuItem loadMenuButton;
    private javax.swing.JButton ovalButton;
    private javax.swing.JButton rectangleButton;
    private javax.swing.JMenuItem saveMenuButton;
    private java.awt.Choice shapesChooser;
    private javax.swing.JButton triangleButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent pressed) {
        Shape shape;
        shapesChooser.select(0);
        boolean flag = false;
        System.out.println("------------------");
        for (int i = canvas.getShapes().length - 1; i >= 0; i--) {
            shape = canvas.getShapes()[i];
            if (!shape.isHighlighted()) {
                if (shape.contains(new Point(pressed.getX(), pressed.getY()))) {
                    flag = true;
                    shapesChooser.select(i + 1);
                    selectedShape = shape;
                    selectedShape.setDraggingPoint(new Point(selectedShape.getPosition().x - pressed.getX(), selectedShape.getPosition().y - pressed.getY()));
                    canvas.dehighlightAllV2();
                    selectedShape.highlight();
                    break;
                }
            } else if (shape.isHighlighted()) {
                for (Shape circleMark : shape.getCircleMarks()) {
                    System.out.println(circleMark);
                    if (circleMark.contains(new Point(pressed.getX(), pressed.getY()))) {
                        flag = true;
                        selectedShape = circleMark;
                        selectedShape.setDraggingPoint(new Point(selectedShape.getPosition().x - pressed.getX(), selectedShape.getPosition().y - pressed.getY()));
                        break;
                    }
                }
            }
            if (selectedShape == null && shape.contains(new Point(pressed.getX(), pressed.getY()))) {
                flag = true;
                shapesChooser.select(i + 1);
                selectedShape = shape;
                selectedShape.setDraggingPoint(new Point(selectedShape.getPosition().x - pressed.getX(), selectedShape.getPosition().y - pressed.getY()));
                canvas.dehighlightAllV2();
                selectedShape.highlight();
                break;
            }
        }
        if (flag == false) {
            canvas.dehighlightAllV2();
        }
        canvas.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e
    ) {
        selectedShape = null;
    }

    @Override
    public void mouseEntered(MouseEvent e
    ) {
    }

    @Override
    public void mouseExited(MouseEvent e
    ) {
    }

    @Override
    public void mouseDragged(MouseEvent e
    ) {
        try {
            selectedShape.moveTo(new Point(e.getX(), e.getY()));
            if (selectedShape.isIsMarker()) {
                canvas.resizeShapes();
            }
            canvas.repaint();
        } catch (Exception ex) {

        }

    }

    @Override
    public void mouseMoved(MouseEvent e
    ) {
    }

    @Override
    public void setParentNavigate(Navigate n
    ) {
    }

    @Override
    public Navigate getParentNavigate() {
        return null;
    }
}
