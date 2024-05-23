package se.lexicon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.data_access.StudentDao;
import se.lexicon.model.Student;
import se.lexicon.util.UserInputService;

import java.util.List;

@Component
public class StudentManagementConsoleImpl implements StudentManagement {

    private final UserInputService userInputService;
    private final StudentDao studentDao;

    @Autowired
    public StudentManagementConsoleImpl(UserInputService userInputService, StudentDao studentDao) {
        this.userInputService = userInputService;
        this.studentDao = studentDao;
    }

    @Override
    public Student create() {
        System.out.println("Creating a new student: ");
        Student student = new Student();
        System.out.println("Enter student ID: ");
        student.setId(userInputService.getInt());
        System.out.println("Enter student name: ");
        student.setName(userInputService.getString());
        return student;
    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Student find(int id) {
        return studentDao.find(id);
    }

    @Override
    public void delete(int id) {
        studentDao.delete(id);
    }

    @Override
    public void remove(int id) {
        studentDao.delete(id);
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student edit(Student student) {
        if (student == null) {
            System.out.println("Student not found");
            return null;
        }
        System.out.println("Editing student name: " + student.getName());
        System.out.println("Enter new name: ");
        String name = userInputService.getString();
        student.setName(name);
        return studentDao.save(student);
    }
}
