package Week1_ColoringMoveableCircle;

// ******************************************************************
// CirclePanel.java
//
// A panel with a circle drawn in the center and buttons on the
// bottom that move the circle.
// ******************************************************************
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class CirclePanel extends JPanel
{
    private final int CIRCLE_SIZE = 50;
    private int x,y;
    private Color c;
    //---------------------------------------------------------------
// Set up circle and buttons to move it.
//---------------------------------------------------------------
    public CirclePanel(int width, int height)
    {
// Set coordinates so circle starts in middle
        x = (width/2)-(CIRCLE_SIZE/2);
        y = (height/2)-(CIRCLE_SIZE/2);
        c = Color.green;
// Need a border layout to get the buttons on the bottom
        this.setLayout(new BorderLayout());
// Create buttons to move the circle
        JButton left = new JButton("Left");
        JButton right = new JButton("Right");
        JButton up = new JButton("Up");
        JButton down = new JButton("Down");
// Create buttons to change the circle's color
        JButton blue = new JButton("Blue");
        JButton red = new JButton("Red");
        JButton black = new JButton("Black");
        JButton cyan = new JButton("Cyan");

        JButton chooseColor = new JButton("Choose Color");

// Add listeners to the buttons
        left.addActionListener(new MoveListener(-20,0));
        right.addActionListener(new MoveListener(20,0));
        up.addActionListener(new MoveListener(0,-20));
        down.addActionListener(new MoveListener(0,20));

        blue.addActionListener(new ColorListener(Color.blue));
        red.addActionListener(new ColorListener(Color.red));
        black.addActionListener(new ColorListener(Color.black));
        cyan.addActionListener(new ColorListener(Color.cyan));

        chooseColor.addActionListener(new ColorListener(null));
//Change the color of the "Change color" buttons
        blue.setForeground(Color.blue);
        red.setForeground(Color.red);
        black.setForeground(Color.black);
        cyan.setForeground(Color.cyan);

// Need a panel to put the buttons on or they'll be on
// top of each other.
        JPanel buttonPanelMove = new JPanel();
        buttonPanelMove.add(left);
        buttonPanelMove.add(right);
        buttonPanelMove.add(up);
        buttonPanelMove.add(down);

        JPanel buttonPanelColor = new JPanel();
        buttonPanelColor.add(blue);
        buttonPanelColor.add(red);
        buttonPanelColor.add(chooseColor);
        buttonPanelColor.add(black);
        buttonPanelColor.add(cyan);

// Add the button panel to the bottom of the main panel
        this.add(buttonPanelMove, "South");
// Add color buttons to the top of the main panel
        this.add(buttonPanelColor, "North");
    }
    //---------------------------------------------------------------
// Draw circle on CirclePanel
//---------------------------------------------------------------
    public void paintComponent(Graphics page)
    {
        super.paintComponent(page);
        page.setColor(c);
        page.fillOval(x,y,CIRCLE_SIZE,CIRCLE_SIZE);
    }
// Class to change the circle color asynchronously
    private class ColorListener implements  ActionListener {
        private Color shapeColor;

        public ColorListener(Color newColor) {
            this.shapeColor = newColor;
        }
// Change the circle color
        public  void  actionPerformed(ActionEvent e) {
            if (this.shapeColor == null) {
                c = JColorChooser.showDialog(null,"Select a color", Color.white);
            } else {
                c = this.shapeColor;
            }
            repaint();
        }
    }
    //---------------------------------------------------------------
// Class to listen for button clicks that move circle.
//---------------------------------------------------------------
    private class MoveListener implements ActionListener
    {
        private int dx;
        private int dy;
        //---------------------------------------------------------------
// Parameters tell how to move circle at click.
//---------------------------------------------------------------
        public MoveListener(int dx, int dy)
        {
            this.dx = dx;
            this.dy = dy;
        }
        //---------------------------------------------------------------
// Change x and y coordinates and repaint.
//---------------------------------------------------------------
        public void actionPerformed(ActionEvent e)
        {
            x += dx;
            y += dy;
            repaint();
        }
    }
}