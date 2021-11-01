import GameStop.GameLogging;                //importare pachet Gamestop cu clase si interfete create de noi
import GameStop.Joc;
import GameStop.Magazin;

import javax.swing.*;                       //importare pachete java
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
    private JButton stergeJocButton;                // creare butoane/obiecte pentru Formuri
    private JCheckBox inStockCheckBox;
    private JList Jlist1;
    private JButton buttonStergeTot;
    private JButton adaugareReclamatiiButton;
    private JButton adaugareSugestiiButton;
    public GameLogging log = GameLogging.getInstance();     // Instantierea obiectului log de tip GameLogging, clasa singleton
    ArrayList<Joc> game = new ArrayList<>();                // Instantierea ArrayList de tip Joc
    ArrayList<Magazin> store=new ArrayList<>();             // Instantierea ArrayList de tip Magazin
    public static String NumeJoc;                           // Variabile pentru stockare datele date de utilizator
    public static String PublisherJoc;
    public static int PretJoc;
    public static int ID=0;                                 // Contor pentru ID-ul jocurilor
    String Textlog1;                                        // Variabila pentru logarea butoanelor




    public static boolean isNumeric(String strNum) {                        // functie ce returneaza daca un string este numeric
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


    DefaultListModel dm = new DefaultListModel();                       // Creare model de lista pentru Jlist
    public MainForm() {
        adaugaJocButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                boolean ok=true;
                if (textNume.getText().equals("") || textPret.getText() == null) {
                    JOptionPane.showMessageDialog(null, "Error, inserati valoare valida in Nume Joc", "Error", JOptionPane.OK_OPTION);
                    ok=false;                       // conditii pentru salvarea datelor in variabile
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
                if(ok) {     // daca toate conditiile sunt stabilite, creeaza obiecte de tip Joc si Magazin
                    game.add(new Joc(NumeJoc, PublisherJoc, PretJoc));
                    store.add(new Magazin(game.get(ID),stock,ID));
                    Textlog1=game.get(ID).getNume();
                    Textlog1 +=" Joc Creat si adaugat in lista";   // logare
                    log.logare(Textlog1);
                    ID++;
                    Jlist1.setModel(dm);
                    dm.addElement(store.get(store.size()-1).toString());    // adaugare in Jlist
                }



            }
        });
        stergeJocButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nr=Jlist1.getSelectedIndex();      // preia indexul al itemului selectat din Jlist
                dm.removeElementAt(nr);                 // sterge elementul la indexul selectat
                Textlog1=game.get(nr).getNume();
                store.remove(nr);           // stergere din arraylist Magazin si Joc
                game.remove(nr);

                Textlog1 +=" Jocul a fost sters cu succes";         // logare
                log.logare(Textlog1);
                ID--;
                if(ID<0)
                    ID=0;
            }
        });
        buttonStergeTot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dm.clear();;                    // stergere lista
                Jlist1.setModel(dm);
                game.clear();                   // stergere iteme din arraylist Joc
                store.clear();                  // stergere iteme din arraylist Magazin

                Textlog1 =" Toate jocurile au fost sterse cu succes";       //logare
                log.logare(Textlog1);
                ID=0;
            }
        });

        adaugareReclamatiiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormReclamatii form2= new FormReclamatii();             // creare obiect tip form reclamatii si apelare la functia setvisible care afiseaza formul
                form2.setvisible();
                Textlog1 =" Deschidere FORM reclamatii";                // logare
                log.logare(Textlog1);
            }
        });
        adaugareSugestiiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormSugestii form3 = new FormSugestii();                // la fel ca si tip form reclamatii, dar sugestii
                form3.setvisible();
                Textlog1 =" Deschidere FORM sugestii";
                log.logare(Textlog1);                                           // logare
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame=new JFrame("Inventar magazin");                        // creare Form principal
        frame.setContentPane(new MainForm().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }

}
