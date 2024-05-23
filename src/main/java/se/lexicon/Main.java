package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ComponentScanConfig;
import se.lexicon.data_access.StudentDao;
import se.lexicon.model.Student;
import se.lexicon.service.StudentManagement;
import se.lexicon.util.UserInputService;


public class Main {


    public static void main(String[] args) {

        //Create a new context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ComponentScanConfig.class);
        context.refresh();

        //Get beans
        StudentDao studentDao = context.getBean(StudentDao.class);
        UserInputService userInputService = context.getBean(UserInputService.class);
        StudentManagement studentManagement = context.getBean(StudentManagement.class);

        //Create and save a new student

       Student newStudent = studentManagement.create();
        if (newStudent != null) {
            System.out.println("Created student ID:" + newStudent.getId() + " name:" + newStudent.getName());
        }else{
            System.out.println("Could not create student");
        }



        //Find the student with ID nr 1
        System.out.println("Finding the created student with ID nr 1");
        Student student = studentManagement.find(1);
        if(student != null){
            System.out.println("student found: " + student.getName());
        }else{
            System.out.println("Student not found");
        }


        ////Edit the student wit id nr 1
        System.out.println("Editing the created student with id nr 1");
        student = studentManagement.find(1);
        if (student != null) {
            studentManagement.edit(student);
            System.out.println("Student edited: " + student.getName() );
        }else{
            System.out.println("Student with ID nr 1 not found, cannot edit");
        }

        //Display all students
        System.out.println("Displaying all students");
        for (Student s : studentManagement.findAll() ){
            System.out.println(s.getName());
        }


        //Delete the student
        System.out.println("Deleting the created student");
        student = studentManagement.find(1);
        if (student != null) {
            studentManagement.remove(student.getId());
            System.out.println("Student with ID 1 has been deleted");
        }else{
            System.out.println("Student with ID 1 not found, cannot delete");
        }


        //Test UserInputService
        System.out.println("Enter a student name: ");
        String name = userInputService.getString();
        newStudent = new Student();
        newStudent.setId(2);
        newStudent.setName(name);
        studentDao.save(newStudent);

        Student updatedStudent = studentDao.find(2);
        if (updatedStudent !=null){
            System.out.println("Updated student name; " + updatedStudent.getName());
        }else{
            System.out.println("Student with ID 2 not found after the update");
        }


        //Test setup
        student = new Student();
        student.setId(1);
        student.setName("John");
        studentDao.save(student);

        //Test
        Student found = studentDao.find(2);
        if(found != null){
            System.out.println(found.getName());



        }
        context.close();
    }
}