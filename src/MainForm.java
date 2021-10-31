import GameStop.GameLogging;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;


public class MainForm {
    private JPanel rootPanel;
    private JButton button1;
    public GameLogging log = GameLogging.getInstance();


    public MainForm() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log.logare("Buton apasat");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame=new JFrame("Inventar magazin");
        frame.setContentPane(new MainForm().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }

}
