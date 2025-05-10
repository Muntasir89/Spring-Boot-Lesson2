package com.practice.firstproject.repository;

import com.practice.firstproject.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    public Department findByDepartmentName(String departmentName);
    Department findByDepartmentNameIgnoreCase(String departmentName);
}
