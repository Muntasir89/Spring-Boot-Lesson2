package com.practice.firstproject.repository;

import com.practice.firstproject.entity.Guardian;
import com.practice.firstproject.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void  saveStudent() {
        Student student = Student.builder()
                .emailId("monim@gmail.com")
                .firstName("Monim")
                .lastName("Khan")
//                .guardianName("Khan")
//                .guardianEmail("khan@gmail.com")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .name( "Guardian")
                .email("guardian@gmail.com")
                .mobile("01712345678")
                .build();

        Student student = Student.builder()
                .firstName("Monim")
                .emailId("monim@gmail.com")
                .lastName("Kumar")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }
    @Test
    public void printStudentByFirstName() {
        List<Student>students = studentRepository.findByFirstName("Monim");

        System.out.println("studentList = "+students);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student>students = studentRepository.findByFirstNameContaining("Monim");

        System.out.println("studentList = "+students);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student>students = studentRepository.findByGuardianName("Guardian");

        System.out.println("studentList = "+students);
    }

    @Test
    public void printAllStudents() {
        List<Student> students = studentRepository.findAll();

        System.out.println("studentList = "+students);
    }

    @Test
    public void getStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("monim@gmail.com");
        System.out.println("student = "+student);
    }

    @Test
    public void printStudentFirstNameByEmailAddress(){
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("monim@gmail.com");
        System.out.println("firstName = "+firstName);
    }
}