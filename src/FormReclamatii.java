import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

public class FormReclamatii extends MainForm {
    private JPanel rootPanel2;
    private JTextArea textArea1;
    private JButton adaugaReclamatieButton;


    public FormReclamatii() {

        adaugaReclamatieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textR = textArea1.getText();
                try {
                    FileWriter fw = new FileWriter("Reclamatii.txt");       // scriere in fisierul "Reclamatii.txt"
                    fw.append(textR);
                    fw.close();
                } catch (Exception z) {
                    System.out.println(z);
                }
                System.out.println("Scris cu succes.");
            }


        });
    }

    void setvisible(){


       JFrame frame2= new JFrame("Reclamatii");         // functie pentru afisare form
       frame2.setContentPane(new FormReclamatii().rootPanel2);
       frame2.pack();
       frame2.setVisible(true);
   }



}
