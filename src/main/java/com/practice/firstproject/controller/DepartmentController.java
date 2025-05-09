package com.practice.firstproject.controller;

import com.practice.firstproject.entity.Department;
import com.practice.firstproject.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartments(){
        return departmentService.fetchDepartmentList();
    }

    // Fetching Department by Id
    @GetMapping("/departments/{departmentId}")
    public Department fetchDepartmentById(@PathVariable Long departmentId){
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
        department.setDepartmentId(departmentId);
        return departmentService.updateDepartment(departmentId,department);
    }
}
