
import Modeles.Admin;
import Modeles.Manager;
import Modeles.Person;
import Modeles.Worker;

import Report.Report;
import Repository.UserRepository;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {

        UserRepository userRepository = new UserRepository();
        userRepository.saveUser(new Admin("Nastya"),"19.03.2015 13:15:43");
        userRepository.saveUser(new Admin("Nastya3"));
        userRepository.saveUser(new Manager("Reinhart"));
        userRepository.saveUser(new Worker("Nikolas"));
        userRepository.saveUser(new Worker("Alex"));
        userRepository.saveUser(new Manager("Polina"));
        userRepository.saveUser(new Admin("Max"),"01.01.2019 23:59:48");
        userRepository.saveUser(new Worker("Soda"));


       /*for (Person q : userRepository.findUsers()){
           System.out.println(q);
       }*/


         Report report = new Report();

        try {
            for (Person q : report.readFile()){
                System.out.println(q);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        report.writeFile(userRepository.findUsers());













        //  PersonSearch search = new PersonSearch();
       // userRepository.removeUser();


    /*    class SearchName implements IPersonSearch {
            @Override
            public boolean existByField(Person person) {
                return person.getName().contentEquals("Nastya");
            }
        }*/


      //  SearchName searchName = new SearchName();

       /* new IPersonSearch() {
            @Override
            public boolean existByField(Person person) {
                return person.getName().contentEquals("Nastya");
            }
        }*/

/*
        System.out.println(userRepository
                .findUsers((person) ->
                        person.getName().contentEquals("Nastya")));*/

   /*     List<Person> users = userRepository.findUsers();
        List<Person> response = users.stream()
                .filter((el) -> el.getName().equals("Nastya"))
                .collect(Collectors.toList());
        System.out.println(response);*/
    }
}
