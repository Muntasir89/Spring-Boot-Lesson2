package com.practice.firstproject.repository;

import com.practice.firstproject.entity.Course;
import com.practice.firstproject.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course courseJava = Course.builder()
                .title("Java")
                .credit(1)
                .build();
        Course coursePython = Course.builder()
                .title("Python")
                .credit(2)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Issac")
                .lastName("Newton")
//                .courses(List.of(courseJava, coursePython))
                .build();
        teacherRepository.save(teacher);
    }
}