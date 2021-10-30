import javax.swing.*;
import java.awt.*;

public class MainForm {
    private JPanel rootPanel;

    public static void main(String[] args) {
        JFrame frame=new JFrame("Inventar magazin");
        frame.setContentPane(new MainForm().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

}
