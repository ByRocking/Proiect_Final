package GameStop;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class GameLogging {                  // clasa pentru logare de tip Singleton
     private static GameLogging instance;
     private String log;
     private StringBuffer sb = new StringBuffer();


     private GameLogging() {            // constructor privat

         sb.append("");
     }

     public static GameLogging getInstance() {
         if (null == instance) {
             instance = new GameLogging();
         }


         return instance;
     }
     public void logare(String text)            // metoda pentru schimbarea variabilei din clasa
     {

         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");        // creare format de data
         LocalDateTime now = LocalDateTime.now();
         this.log=text;
         try{
             FileWriter fw= new FileWriter("Logging.log");          // scriere logare in fisierul Logging.log
             sb.append(dtf.format(now));
             sb.append(" ");
             sb.append(text);
             fw.write(sb.toString());
             fw.close();
         }catch(Exception e)
         {
             System.out.println(e);
         }
         System.out.println("Loggat cu succes.");           // mesaj de confirmare daca s-a reusit logarea
         sb.append("\n");
     }





}
