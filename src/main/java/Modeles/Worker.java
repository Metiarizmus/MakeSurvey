package Modeles;

import Enums.PersonRole;

public class Worker extends Person{

    public Worker(PersonRole role) {
        super(role);
    }
    public Worker(String name) {
        super(PersonRole.WORKER);
        this.setName(name);
    }

    public Worker() {
        super(PersonRole.WORKER);
    }

}
