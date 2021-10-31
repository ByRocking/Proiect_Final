import GameStop.GameLogging;
import GameStop.Joc;
import GameStop.Magazin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Formattable;


public class MainForm {
    private JPanel rootPanel;
    private JButton adaugaJocButton;
    private JTextField textNume;
    private JTextField textPublisher;
    private JTextField textPret;
    private JButton stergeJocButton;
    private JCheckBox inStockCheckBox;
    private JList Jlist1;
    private JButton buttonStergeTot;
    private JButton adaugareReclamatiiButton;
    private JButton adaugareSugestiiButton;
    public GameLogging log = GameLogging.getInstance();
    ArrayList<Joc> game = new ArrayList<>();
    ArrayList<Magazin> store=new ArrayList<>();
    public static String NumeJoc;
    public static String PublisherJoc;
    public static int PretJoc;
    public static int ID=0;

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


    DefaultListModel dm = new DefaultListModel();
    public MainForm() {
        adaugaJocButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean ok=true;
                if (textNume.getText().equals("") || textPret.getText() == null) {
                    JOptionPane.showMessageDialog(null, "Error, inserati valoare valida in Nume Joc", "Error", JOptionPane.OK_OPTION);
                    ok=false;
                } else {
                    NumeJoc = textNume.getText();

                }
                if (textPublisher.getText().equals("") || textPret.getText() == null){
                    JOptionPane.showMessageDialog(null, "Error, inserati valoare valida in Nume Publisher", "Error", JOptionPane.OK_OPTION);
                    ok=false;
                }
                else
                    PublisherJoc = textPublisher.getText();
                if (textPret.getText().equals("") || textPret.getText() == null){
                    JOptionPane.showMessageDialog(null, "Error, inserati valoare valida in Pret", "Error", JOptionPane.OK_OPTION);
                    ok=false;
                }
                else if (isNumeric(textPret.getText()))
                    PretJoc = Integer.parseInt(textPret.getText());
                else{
                    JOptionPane.showMessageDialog(null, "Error, inserati valoare valida in Pret", "Error", JOptionPane.OK_OPTION);
                    ok=false;
                }


                boolean stock = inStockCheckBox.isSelected();
                if(ok) {
                    game.add(new Joc(NumeJoc, PublisherJoc, PretJoc));
                    store.add(new Magazin(game.get(ID),stock,ID));
                    ID++;
                    Jlist1.setModel(dm);
                    dm.addElement(store.get(store.size()-1).toString());
                }

            }
        });
        stergeJocButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nr=Jlist1.getSelectedIndex();
                dm.removeElementAt(nr);
                store.remove(nr);
                game.remove(nr);
                ID--;
                if(ID<0)
                    ID=0;
            }
        });
        buttonStergeTot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dm.clear();;
                Jlist1.setModel(dm);
                game.clear();
                store.clear();
                ID=0;
            }
        });

        adaugareReclamatiiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormReclamatii form2= new FormReclamatii();
                form2.setvisible();

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
