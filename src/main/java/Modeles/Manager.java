package Modeles;

import Enums.PersonRole;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Manager extends Person{

    public Manager(PersonRole role) {
        super(role);
    }

    SimpleDateFormat format = new SimpleDateFormat("MM.dd.yyyy HH:mm:ss");

    public Manager(String name) {
        super(PersonRole.MANAGER);
        this.setName(name);
        this.setDate(format.format(new Date()));
    }

    public Manager() {
        super(PersonRole.MANAGER);
    }
}
