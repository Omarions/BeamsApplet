// Assignment #: 12
//         Name: your name
//    StudentID: your id
//      Lecture: your lecture
//  Description: The UpdateGUIThread class extends Thread Class 
//              and it's used to repaint the beamsPanel in new thread.
package beamsapplet;


public class UpdateGUIThread extends Thread{
    private BeamsPanel beamPanel;
    
    public UpdateGUIThread(BeamsPanel beamPanel){
        this.beamPanel = beamPanel;
    }
    
    @Override
    public void run() {
        beamPanel.repaint();
    }
    
}
