package Modeles;

import Enums.PersonRole;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Admin extends Person {

    public Admin(PersonRole role) {
        super(role);
    }

    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public Admin(String name) {
        super(PersonRole.ADMIN);
        this.setName(name);
        this.setDate(format.format(new Date()));
    }

    public Admin() {
        super(PersonRole.ADMIN);
    }

}
