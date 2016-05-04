// Assignment #: 12
//         Name: your name
//    StudentID: your id
//      Lecture: your lecture
//  Description: The BeamsPanel class creates a panel to draw the beams on it, 
//              Also, it create the timer of animation.
package beamsapplet;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BeamsPanel extends JPanel {
    
    private Color color;        //color of beams
    private int diameter;       //diameter of beams
    private int centerX;        //x point of center
    private int centerY;        //y point of center
    private int diameterLimit;  //limit of diameter
    private int step;           //step of diameter increament
    private int delay;          //speed of animation
    private int angleSize;      //angle size of drawing
    private int beamNum;        //number of beams
    private Timer timer;        //timer of animation

    //constructor with init color and width.
    public BeamsPanel(Color initialColor, int width) {
        color = initialColor;               //set the color of drawing with color which user choose.
        setBackground(Color.black);         //the default color of background
        beamNum = 8;                        //the default value of beams
        angleSize = 360 / (beamNum * 2);    //the calculation of angle size depend on number of beams.
        diameter = 0;                       //the default diameter size
        diameterLimit = (width - 10) / 2;   //the calculation of diameter limit.
        step = 3;                           //the default step size
        centerX = width / 2;                //the default center x point
        centerY = width / 2;                //the default ceneter y point
        delay = 20;                         //the default delay of timer
        timer = new Timer(delay, new MoveListener());   //create the timer
        timer.start();                      //start the timer.    
    }

    /**
     * To start the animation again, called when start button clicked
     */
    public void resume() {
        timer.start();
    }

    /**
     * To stop the animation, called when stop button is clicked
     */
    public void suspend() {
        timer.stop();           
    }

    /**
     * change the color of beams.
     * @param color the parameter to set for the color property
     */
    public void changeColor(Color color) {
        this.color = color;
    }

    /**
     * setter of beam numbers property
     * @param beam the parameter to set for the beam number property
     */
    public void setBeamNumber(int beam) {
        beamNum = beam;
    }

    /**
     * setter of delay property
     * @param delayValue the parameter to set for the delay property
     */
    public void setDelay(int delayValue) {
        delay = delayValue;     
        timer.setDelay(delay);
    }

    /**
     * Paint method to draw the beams with the animation.
     * @param g 
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);             
        g.setColor(color);                          //set the pen color       
        drawAnimation(g);                           //draw the beams and do the animation
    }
    
    /**
     * draw the beams with animation.
     * @param g 
     */
    private void drawAnimation(Graphics g){
        //loop on beams to draw them.
        for (int b = 1; b <= beamNum; b++) {
            int currentAngle = 0;
            for (;currentAngle < 360;) {
                //fill the arc (so the beam is drawen)
                //set the start angle (0 - 360) and the end angle is calculated.
                g.fillArc(centerX - diameter / 2, centerY - diameter / 2,
                        diameter, diameter, currentAngle, (360 / (beamNum * 2)));
                //recalculate teh current angle.
                currentAngle += 2 * (360 / (beamNum * 2));
            }
        }
    }

    /**
     * an inner class for the listener of the timer
     * it check for diameter and ensure that is in its limit 
     * and then repaint the beams with new diameter on every tick of the timer
     */
    private class MoveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //ensure the diameter is not more than the limit.
            while (diameter >= diameterLimit) {
                diameter = 0;       //set the diameter to 0, and start animation from first.
                break;              //break the loop and go to do animation.
            }
            //increase the diameter with the step and repaint, so the animation happens
            diameter += step;
            //redraw the beams again with new diameter.
            repaint();
        }

    }

}
