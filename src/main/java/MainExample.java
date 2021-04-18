import Modeles.Person;
import Repository.UserRepository;

public class MainExample {
    public static void main(String[] args) {

        UserRepository repository = new UserRepository();
        System.out.println("start program");
        Person person = repository.findUsers().get(1);
        System.out.println("end program");


    }
}
