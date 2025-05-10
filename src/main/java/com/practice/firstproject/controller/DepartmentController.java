package com.practice.firstproject.controller;

import com.practice.firstproject.entity.Department;
import com.practice.firstproject.error.DepartmentNotFoundException;
import com.practice.firstproject.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartments(){
         LOGGER.info("Inside fetchDepartments of DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    // Fetching Department by Id
    @GetMapping("/departments/{departmentId}")
    public Department fetchDepartmentById(@PathVariable("departmentId") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{departmentId}")
    public String deleteDepartment(@PathVariable("departmentId") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department Deleted Successfully";
    }

    // Updating Department
    @PutMapping("/departments/{departmentId}")
    public Department updateDepartment(@PathVariable("departmentId") Long departmentId, @RequestBody Department department){
        LOGGER.info("Inside updateDepartment of DepartmentController");
        department.setDepartmentId(departmentId);
        return departmentService.updateDepartment(departmentId,department);
    }
}
