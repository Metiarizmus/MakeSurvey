package Handlers;

import Enums.PersonRole;
import Modeles.Person;

public class PersonSearch implements IPersonSearch{

    @Override
    public boolean existByField(Person person) {
        return person.getRole().equals(PersonRole.ADMIN);
    }

}
