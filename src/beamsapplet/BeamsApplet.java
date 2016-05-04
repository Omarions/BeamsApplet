// Assignment #: 12
//         Name: your name
//    StudentID: your id
//      Lecture: your lecture time
//  Description: The Assignment 12 class creates a controlpanel and
//               adds it as its Applet content and also sets its size.
package beamsapplet;

import javax.swing.*;

public class BeamsApplet extends JApplet {

    private final int WIDTH = 450;
  private final int HEIGHT = 340;

  public void init()
   {
       ControlPanel panel = new ControlPanel(WIDTH,HEIGHT);
       getContentPane().add(panel);
       setSize(WIDTH,HEIGHT);
   }
    
}
