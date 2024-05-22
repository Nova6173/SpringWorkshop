package se.lexicon.service;

import se.lexicon.model.Student;

import java.util.List;

public interface StudentManagement {

    Student create();
    Student save(Student student);
    Student find(int id);
    void remove(int id);

    void delete(int id);

    List<Student> findAll();
    Student edit (Student student);
}
