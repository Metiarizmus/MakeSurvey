package Services.interfaces;

import Enums.PersonRole;
import Modeles.Person;

import java.util.List;

public interface IUserService {

    List<Person> findAllUsers();
    List<Person> findUsersByRole(PersonRole role);
    List<Person> findUserById(int id);
    List<Integer> findIdsByRole(PersonRole role);
    boolean saveUser(Person person);
    boolean removeUser(Person role);
    boolean removeUser(int id);

}
