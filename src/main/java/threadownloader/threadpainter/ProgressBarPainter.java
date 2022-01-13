package threadownloader.threadpainter;

import javax.swing.JProgressBar;

public class ProgressBarPainter implements Runnable{
    public JProgressBar jProgressBar1;
    public void run(){
        while(true){
            try {
                Thread.sleep(50);
                jProgressBar1.repaint();
            } catch (InterruptedException ex) {
               break;
            }
        }
    }
}