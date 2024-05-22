package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.data_access.StudentDao;
import se.lexicon.model.Student;
import se.lexicon.service.StudentManagement;
import se.lexicon.util.UserInputService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        StudentDao studentDao = (StudentDao) context.getBean(UserInputService.class);
        UserInputService userInputService = context.getBean(UserInputService.class);
        StudentManagement studentManagement = context.getBean(StudentManagement.class);

        //Create a new student
        System.out.println("Creating & saving a new student");
        studentManagement.save(studentManagement.create());

        //Find the student
        System.out.println("Finding the created student");
        System.out.println(studentManagement.find(1));

        ////Edit the student
        System.out.println("Updating the created student");
        studentManagement.edit(studentManagement.find(1));

        //Display all students
        System.out.println("Displaying all students");
        studentManagement.findAll().forEach(System.out::println);

        //Delete the student
        System.out.println("Deleting the created student");
        studentManagement.delete(studentManagement.find(1).getId());

        //Test UserInputService
        System.out.println("Enter a student name: ");
        String name = userInputService.getString();
        Student newStudent = new Student();
        newStudent.setName(name);
        studentDao.save(newStudent);
        System.out.println("Updated student name:" + studentDao.find(1).getName());


        //Test setup
        Student student = new Student();
        student.setId(1);
        student.setName("John");
        studentDao.save(student);

        //Test
        Student found = studentDao.find(1);
        if(found != null){
            System.out.println(found.getName());



        }
    }
}