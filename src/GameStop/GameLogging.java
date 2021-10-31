package GameStop;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class GameLogging {
     private static GameLogging instance;
     private String log;
     private StringBuffer sb = new StringBuffer();


     private GameLogging() {

         sb.append("undefined");
     }

     public static GameLogging getInstance() {
         if (null == instance) {
             instance = new GameLogging();
         }


         return instance;
     }
     public void logare(String text)
     {
         sb.delete(0,sb.length());
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
         LocalDateTime now = LocalDateTime.now();
         this.log=text;
         try{
             FileWriter fw= new FileWriter("Logging.log");
             sb.append(dtf.format(now));
             sb.append(" ");
             sb.append(text);
             fw.write(sb.toString());
             fw.close();
         }catch(Exception e)
         {
             System.out.println(e);
         }
         System.out.println("Loggat cu succes.");
     }





}
