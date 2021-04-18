
import Modeles.Admin;
import Modeles.Manager;
import Modeles.Person;
import Modeles.Worker;

import Report.Report;
import Repository.UserRepository;

import java.io.File;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        UserRepository userRepository = new UserRepository();
        userRepository.saveUser(new Admin("Nastya"));
        userRepository.saveUser(new Admin("Nastya3"));
        userRepository.saveUser(new Manager("Reinhart"));
        userRepository.saveUser(new Worker("Nikolas"));
        userRepository.saveUser(new Worker("Alex"));
        userRepository.saveUser(new Manager("Polina"));
        userRepository.saveUser(new Admin("Max"));
        userRepository.saveUser(new Worker("Soda"));


        /*for (Person q : userRepository.getPersonBySort(Comparator.comparing(Person::getRole))){
            System.out.println(q);
        }*/

         Report report = new Report();
         report.getListDirectoryAndFile(new File("C:\\Users\\Николай\\IdeaProjects\\Survey\\src\\main\\java"));







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
