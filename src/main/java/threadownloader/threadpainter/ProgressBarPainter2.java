package threadownloader.threadpainter;

import javax.swing.JProgressBar;

public class ProgressBarPainter2 implements Runnable{
    public JProgressBar jProgressBar2;
    public void run(){
        while(true){
            try {
                Thread.sleep(50);
                jProgressBar2.repaint();
            } catch (InterruptedException ex) {
               break;
            }
        }
    }
}