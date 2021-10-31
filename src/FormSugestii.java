import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

public class FormSugestii {
    private JPanel rootPanel3;
    private JTextArea textArea1;
    private JButton adaugaSugestiiButton;

    void setvisible(){


        JFrame frame2= new JFrame("Sugestii");
        frame2.setContentPane(new FormSugestii().rootPanel3);
        frame2.pack();
        frame2.setVisible(true);
    }

    public FormSugestii() {
        adaugaSugestiiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textS = textArea1.getText();
                try {
                    FileWriter fw = new FileWriter("Sugestii.txt");
                    fw.append(textS);
                    fw.close();
                } catch (Exception z) {
                    System.out.println(z);
                }
                System.out.println("Scris cu succes.");
            }
        });
    }
}

