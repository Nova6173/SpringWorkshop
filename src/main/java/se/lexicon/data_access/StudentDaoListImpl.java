package se.lexicon.data_access;

import se.lexicon.model.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class StudentDaoListImpl implements StudentDao {

    private final List<Student> students = new ArrayList<>();


    @Override
    public Student find(int id) {
        System.out.println("Finding student with ID: " + id);
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Student save(Student student) {
        System.out.println("Saving student with ID: " + student.getId() + ", Name: " + student.getName());
        Optional<Student> existingStudent = students.stream()
                .filter(s -> s.getId() == student.getId())
                .findFirst();
        if (existingStudent.isPresent()) {
            existingStudent.get().setName(student.getName());
        } else {
            students.add(student);
        }
        return student;
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    @Override
    public void delete(int id) {
        System.out.println("Deleting student with ID: " + id);
        students.removeIf(student -> student.getId() == id);
    }
}
