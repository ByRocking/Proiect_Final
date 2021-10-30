import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;


public class MainForm {
    private JPanel rootPanel;




    public static void main(String[] args) {
        JFrame frame=new JFrame("Inventar magazin");
        frame.setContentPane(new MainForm().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        try{
            FileWriter fw= new FileWriter("Logging.log");
            fw.write("test");
            fw.close();
        }catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println("Success...");

    }

}
