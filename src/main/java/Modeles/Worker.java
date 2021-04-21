package Modeles;

import Enums.PersonRole;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Worker extends Person{

    public Worker(PersonRole role) {
        super(role);
    }

    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public Worker(String name) {
        super(PersonRole.WORKER);
        this.setName(name);
        this.setDate(format.format(new Date()));
    }

    public Worker() {
        super(PersonRole.WORKER);
    }

}
