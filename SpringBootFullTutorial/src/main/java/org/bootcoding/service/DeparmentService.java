package org.bootcoding.service;

import org.bootcoding.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DeparmentService {

    Department saveDepartments(Department department);

    List<Department> getDepartmentList();

    Department getDepartmetnById(Long id);

    void deleteDepatmentById(Long departmentId);

    Department updateDepartment(Long departmentId, Department department);

    Department getDepartmentByName(String departmentName);
}
