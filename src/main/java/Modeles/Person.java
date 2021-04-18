package Modeles;

import Enums.PersonRole;

import java.io.Serializable;
import java.util.Objects;

public abstract class Person implements Serializable {

    private static int identificator = 0;

    private int id;
    private String name;
    private PersonRole role;

    public Person(PersonRole role){
        identificator++;
        id=identificator;
        this.role=role;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setRole(PersonRole role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PersonRole getRole() {
        return role;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name) && role == person.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, role);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role=" + role +
                '}';
    }
}
