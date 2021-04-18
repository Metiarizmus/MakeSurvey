package Modeles;

import Enums.PersonRole;

public class Admin extends Person {

    public Admin(PersonRole role) {
        super(role);
    }

    public Admin(String name) {
        super(PersonRole.ADMIN);
        this.setName(name);
    }

    public Admin() {
        super(PersonRole.ADMIN);
    }

}
