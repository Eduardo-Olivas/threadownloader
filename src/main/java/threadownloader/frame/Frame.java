package threadownloader.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import threadownloader.thread.Worker;
import threadownloader.thread.Worker2;
import threadownloader.threadpainter.ProgressBarPainter;
import threadownloader.threadpainter.ProgressBarPainter2;


public class Frame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JProgressBar bar;
    private JProgressBar bar2;

    public Frame(){
        JPanel contentPanel = (JPanel) getContentPane();
        JButton b = new JButton("Start Download");
        bar = new JProgressBar();
        bar2 = new JProgressBar();
        
        contentPanel.setPreferredSize(new Dimension(550, 250));
        b.setPreferredSize(new Dimension(256, 256));
        
        final ProgressBarPainter p = new ProgressBarPainter();
        final ProgressBarPainter2 p2 = new ProgressBarPainter2();
        
        b.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {
  
                p.jProgressBar1 = bar; //Fill in with the bar you want painted
                p2.jProgressBar2 = bar2; //Fill in with the bar you want painted
             
                Thread t = new Thread(p);
                Thread t2 = new Thread(p2);
                
                t.start();
                t2.start();

                Worker w = new Worker();
                Worker2 w2 = new Worker2();
                
                w.jProgressBar1 = bar;
                w2.jProgressBar2 = bar2;
                
                Thread q = new Thread(w);
                Thread q2 = new Thread(w2);
                q.start();
                q2.start();
            }

        });
        contentPanel.add(b, BorderLayout.CENTER);
        contentPanel.add(bar, BorderLayout.WEST);   
        contentPanel.add(bar2, BorderLayout.EAST);

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

 

}

