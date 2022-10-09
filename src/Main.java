import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

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
                    System.out.println("Start");
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
