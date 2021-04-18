package Report;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Report {

    public void getFile(){
        try (
            FileInputStream fin= new FileInputStream("D://input.txt");
            FileOutputStream fos = new FileOutputStream("D://output.txt");
            BufferedOutputStream bs = new BufferedOutputStream(fos))
        {
           byte[] buffer = new byte[fin.available()] ;
           //считываем буфер
           fin.read(buffer,0, buffer.length);
           //записываем их буфера в файл
           bs.write(buffer,0, buffer.length);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }finally {

        }

    }

    public void getListDirectoryAndFile(File file) {

        if(file.isDirectory()){
            for (File q : file.listFiles()){
                if(q.isDirectory()){
                    System.out.println(q.getName() + " \t folder");

                    getListDirectoryAndFile(q);

                } else System.out.println(q.getName() + "\t file");
            }
        }


    }

}
