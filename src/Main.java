import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.util.Timer;
import java.util.TimerTask;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    JLabel timeText;
    Timer timer;

    private boolean isOn;
    private boolean isPaused;

    private int elapsedSeconds;

    private String ConvertToCorrectFormat(int seconds)
    {
        int sec = seconds % 60;
        int min = (seconds / 60) % 60;
        int hours = (seconds / 60) / 60;

        return hours + ":" + min + ":" + sec;
    }

    private void Update() {
        if(!isPaused)
        {
            elapsedSeconds++;
            timeText.setText(ConvertToCorrectFormat(elapsedSeconds));
        }
    }

    private void StartTimer() {
        isOn = true;
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Update();
            }
        }, 0, 1000);
    }

    private void StopTimer() {
        isOn = false;
    }

    private void PauseTimer() {
        isPaused = true;
    }

    private void ResumeTimer() {
        isPaused = false;
    }

    public Main() {
        JFrame frame = new JFrame();
        frame.setTitle("Timer");
        frame.setSize(400, 200);
        frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        timeText = new JLabel("Time");
        timeText.setFont(new Font("Arial", Font.PLAIN, 40));
        timeText.setBounds(5, -20, 1000, 100);

        JButton StartBtn = new JButton("Start");
        StartBtn.setBounds(0, 117, 100, 40);
        StartBtn.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(isOn) {
                        StopTimer();
                        StartBtn.setText("Start");
                    } else {
                        StartTimer();
                        StartBtn.setText("Stop");
                    }
                }
            }
        );
        
        JButton PauseBtn = new JButton("Pause");
        PauseBtn.setBounds(105, 117, 100, 40);
        PauseBtn.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(isPaused) {
                        ResumeTimer();
                        PauseBtn.setText("Pause");
                    } else {
                        PauseTimer();
                        PauseBtn.setText("Resume");
                    }
                }
            }
        );

        frame.setLayout(null);
        frame.add(StartBtn);
        frame.add(timeText);
        frame.add(PauseBtn);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}
