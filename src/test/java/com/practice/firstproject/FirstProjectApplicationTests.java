package com.practice.firstproject;

import com.practice.firstproject.service.DepartmentService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FirstProjectApplicationTests {
    @Autowired
    private DepartmentService departmentService;

    @BeforeEach
    void setUp() {
    }
}
