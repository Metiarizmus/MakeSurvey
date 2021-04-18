package Repository;

import Handlers.IPersonSearch;
import Modeles.Admin;
import Modeles.Person;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class UserRepository{

    private List<Person> persons = new ArrayList<>();

    public boolean saveUser(Person person) {
        if (person == null) {
            return false;
        }
        if (person.getName() == null ||
                person.getName().isEmpty()
        ) {
            throw new IllegalArgumentException("Name not found");
        }
        return persons.add(person);
    }


    public List<Person> findUsers(){
        return persons;
    }

    public boolean removeUser(Person person) {
        if(person == null) {
            return false;
        }
        return persons.remove(person);

    }

    public void removeById(int id) {
        if(id!=0) {
            for (int i = 0; i < persons.size(); i++) {
                if(persons.get(i).getId() == id){
                    persons.remove(i);
                }
            }
        }

    }

    public List<Person> findUsers(IPersonSearch searchResponse) {
        List<Person> filteredPersons = new LinkedList<>();
        for (Person person: persons) {
            if (searchResponse.existByField(person)) {
                filteredPersons.add(person);
            }
        }
        return filteredPersons;
    }


    public List<Person> getPersonBySort(Comparator<Person> comparator){
        persons.sort(comparator);
        return persons;
    }


}
