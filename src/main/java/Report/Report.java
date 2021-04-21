package Report;

import Modeles.Person;
import Repository.UserRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//Создать метод в классе Отчет, который позволяет записать информацию о клиентах в файл (имя, роль, дата регистрации) - его создавали на прошлое занятие

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

    public void writeFile(List<Person> list) throws IOException {
            FileOutputStream fos = new FileOutputStream("D://output.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
    }

    public List<Person> readFile() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("D://output.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Person> newlist = (List<Person>) ois.readObject();
        ois.close();
        return newlist;
    }

}
