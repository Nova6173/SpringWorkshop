package se.lexicon.data_access;

import se.lexicon.model.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDaoListImpl implements StudentDao {
    private List<Student> students = new ArrayList<>();


    @Override
    public Student find(int id) {

        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst().orElse(null);
    }

    @Override
    public Student save(Student student) {
        students.add(student);
        return student;
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    @Override
    public void delete(int id) {
        students.removeIf(student -> student.getId() == id);
    }
}
