package ch.halabi.model;

import java.util.Objects;

public class Student {

    private int id;
    private String name;
    private String surname;

    public Student(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return name.equalsIgnoreCase(student.name) &&
                surname.equalsIgnoreCase(student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public String toString() {
        return id + " - " + name + " " + surname;
    }
}
