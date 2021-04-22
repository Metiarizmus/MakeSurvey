package Logger;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Log {



    public void addLog(String log) {
        SimpleDateFormat format = new SimpleDateFormat("MM.dd.yyyy HH:mm:ss");
        String data = format.format(new Date());


        PrintWriter writer = null;

        try {
            writer = new PrintWriter(new FileWriter("C:\\Users\\Николай\\IdeaProjects\\Survey\\src\\main\\java\\Logger\\Logi",true));
            writer.write(data+ " " +log+"\n");

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            writer.close();
        }


    }

}
