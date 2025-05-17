package com.practice.firstproject.repository;

import com.practice.firstproject.entity.Course;
import com.practice.firstproject.entity.CourseMaterial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial() {
        Course course = Course.builder()
                .title(".net")
                .credit(6)
                .build();


        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("https://www.google.com")
//                .course(course)
                .build();

        courseMaterialRepository .save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterial(){
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println("courseMaterials = "+courseMaterials);
    }
}