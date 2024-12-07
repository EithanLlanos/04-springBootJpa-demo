//Base
//
//package com.springBoot.crudDemo;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class CrudDemoApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(CrudDemoApplication.class, args);
//	}
//
//}


// setting up a Simple example

//package com.springBoot.crudDemo;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//
//@SpringBootApplication
//public class CrudDemoApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(CrudDemoApplication.class, args);
//    }
//
//    @Bean
//    public CommandLineRunner commandLineRunner(String[] args) {
//        return runner -> {
//            System.out.println("Hello World!");
//        };
//    }
//
//}


// Setting createStudemt method

package com.springBoot.crudDemo;

import com.springBoot.crudDemo.dao.StudentDAO;
import com.springBoot.crudDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            // createStudent(studentDAO);

            // createMultipleStudents(studentDAO);

            // readStudent(studentDAO);

            // queryForStudents(studentDAO);

            queryForStudentsByLastName(studentDAO);
        };
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {

        // get a list of students
        List<Student> theStudents = studentDAO.findByLastName("Duck");

        // display list of students
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);

        }
    }

    private void queryForStudents(StudentDAO studentDAO) {

        // get a list of students
        List<Student> theStudents = studentDAO.findAll();

        // display list of students
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

    private void readStudent(StudentDAO studentDAO) {

        // create a student object
        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Daffy", "Duck", "daffyduckd@gmail.com");

        // save the student
        System.out.println("Saving the student ...");
        studentDAO.save(tempStudent);

        // display id of the saved student
        int theId = tempStudent.getId();
        System.out.println("Saved student. Generated id: " + theId);

        // retrieved student based on primary key
        System.out.println("Retrieving student with id: " + theId);
        Student myStudent = studentDAO.findById(theId);

        // display student
        System.out.println("Found the student: " + myStudent);
    }

    private void createStudent(StudentDAO studentDAO) {

        // create the student object
        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Eithan", "Llanos", "eithanllanosb@gmail.com");

        // save the student object
        System.out.println("Saving the student ...");
        studentDAO.save(tempStudent);

        // display id of the saved student
        System.out.println("Saved student. Generated id: " + tempStudent.getId());


    }

    private void createMultipleStudents(StudentDAO studentDAO) {

        // create the student object
        System.out.println("Creating new student objects ...");
        Student tempStudent1 = new Student("Plateo", "Nostaquio", "plateonostaquiok@gmail.com");
        Student tempStudent2 = new Student("Linéa", "Frank", "lineafrankr@gmail.com");
        Student tempStudent3 = new Student("Eleanor", "Rose", "eleanorrosed@gmail.com");

        // save the student object
        System.out.println("Saving the students ...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

        // display id of the saved students
        System.out.println("Saved students " + tempStudent1.getFirstName() + " " + tempStudent1.getLastName() + "   Generated id: " + tempStudent1.getId());
        System.out.println("Saved students " + tempStudent2.getFirstName() + " " + tempStudent2.getLastName() + "   Generated id: " + tempStudent2.getId());
        System.out.println("Saved students " + tempStudent3.getFirstName() + " " + tempStudent3.getLastName() + "   Generated id: " + tempStudent3.getId());
    }
}
