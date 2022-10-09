import javax.swing.JButton;
import javax.swing.JFrame;

import java.time.LocalTime;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private boolean isOn;
    private boolean isPaused;

    private void StartTimer() {
        isOn = true;
    }

    private void StopTimer() {
        isOn = false;
    }

    public Main() {
        JFrame frame = new JFrame();
        frame.setTitle("Timer");
        frame.setSize(400, 200);
        frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton StartBtn = new JButton("Start");
        StartBtn.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(!isOn) {
                        StartBtn.setText("Start");
                        
                        StartTimer();
                    } else {
                        StartBtn.setText("Stop");
                    
                        StopTimer();
                    }
                }
            }
        );

        frame.setLayout(new FlowLayout());
        frame.add(StartBtn);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}
