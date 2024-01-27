package frontend;

import backend.Oval;
import backend.Shape;
import java.awt.Color;
import static java.awt.Color.black;
import java.awt.Point;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AddOval extends JFrame implements Navigate {

    private Navigate parent;
    Color color = black;
    Color fillColor = black;

    public AddOval() {
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        positionY = new javax.swing.JTextField();
        xRadius = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        borderColorButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        fillingColorButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        positionX = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        yRadius = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Oval");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("X");

        borderColorButton.setText("Set Border Color");
        borderColorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borderColorButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Y");

        fillingColorButton.setText("Set Filling Color");
        fillingColorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillingColorButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Horizontal Radius");

        positionX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positionXActionPerformed(evt);
            }
        });

        jLabel4.setText("Vertical Radius");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(borderColorButton)
                        .addGap(37, 37, 37)
                        .addComponent(addButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(positionX, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(positionY, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addGap(30, 30, 30)
                        .addComponent(xRadius))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(46, 46, 46)
                        .addComponent(yRadius)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(fillingColorButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(positionX, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(positionY, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xRadius, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yRadius, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(borderColorButton)
                            .addComponent(fillingColorButton))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        if (positionX.getText().isEmpty() || positionY.getText().isEmpty() || xRadius.getText().isEmpty() || yRadius.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Some fields are empty!");
        } else if (isInteger(positionX.getText()) && isInteger(positionY.getText()) && isInteger(xRadius.getText()) && isInteger(yRadius.getText())) {
            Shape newOval = new Oval(new Point(Integer.parseInt(positionX.getText()), Integer.parseInt(positionY.getText())), Integer.parseInt(xRadius.getText()), Integer.parseInt(yRadius.getText()));
            newOval.setColor(color);
            newOval.setFillColor(fillColor);
            this.setVisible(false);
            ((JFrame) parent).setVisible(true);
            ((DrawingApplication) this.parent).addOval(newOval);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid inputs!");
        }
        resetTextFields();
    }//GEN-LAST:event_addButtonActionPerformed

    private void borderColorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borderColorButtonActionPerformed
        // TODO add your handling code here:
        color = JColorChooser.showDialog(this, "Colorize", Color.white);
    }//GEN-LAST:event_borderColorButtonActionPerformed

    private void fillingColorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillingColorButtonActionPerformed
        // TODO add your handling code here:
        fillColor = JColorChooser.showDialog(this, "Colorize", Color.white);
    }//GEN-LAST:event_fillingColorButtonActionPerformed

    private void positionXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positionXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_positionXActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.setVisible(false);
        ((JFrame) parent).setVisible(true);
        resetTextFields();
    }//GEN-LAST:event_formWindowClosing

    public void resetTextFields() {
        positionX.setText("");
        positionY.setText("");
        xRadius.setText("");
        yRadius.setText("");
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
    private javax.swing.JButton addButton;
    private javax.swing.JButton borderColorButton;
    private javax.swing.JButton fillingColorButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField positionX;
    private javax.swing.JTextField positionY;
    private javax.swing.JTextField xRadius;
    private javax.swing.JTextField yRadius;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setParentNavigate(Navigate n) {
        parent = n;
    }

    @Override
    public Navigate getParentNavigate() {
        return parent;
    }
}
