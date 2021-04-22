package Report;

import Modeles.Person;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Copy {

    public void readFileToCopy() throws IOException, ClassNotFoundException {

        FileInputStream input = null;
        FileOutputStream output = null;

        try {
             input = new FileInputStream("C:\\Users\\Николай\\IdeaProjects\\Survey\\src\\main\\java\\Logger\\Logi");
             output = new FileOutputStream("C:\\Users\\Николай\\IdeaProjects\\Survey\\src\\main\\java\\Logger\\CopyLogi");

            while(input.available() > 0) {
                int data = input.read();
                output.write(data);
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            input.close();
            output.close();
        }





    }


}
