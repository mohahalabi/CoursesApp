package ch.halabi.model;

import java.util.ArrayList;

public class Course {
    private String name;
    private int id;


    private ArrayList<Student> partecipanti = new ArrayList<>();

    public Course(int id, String name) {
        this.name = name;
        this.id = id;
    }


    public void addStudent(Student newStudent) {
        partecipanti.add(newStudent);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Student> getPartecipanti() {
        return partecipanti;
    }


    @Override
    public String toString() {
        return id + " - " + name;
    }
}
