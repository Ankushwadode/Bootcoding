package org.bootcoding.controller;

import jakarta.validation.Valid;
import org.bootcoding.entity.Department;
import org.bootcoding.service.DeparmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

    @Autowired
    private DeparmentService deparmentService;

    @PostMapping("/save")
    public Department saveDepartments(@Valid @RequestBody Department department){
        return deparmentService.saveDepartments(department);
    }

    @GetMapping("/getAll")
    public List<Department> getDepartmentList(){
        return deparmentService.getDepartmentList();
    }

    @GetMapping("/get/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId){
        return deparmentService.getDepartmetnById(departmentId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        deparmentService.deleteDepatmentById(departmentId);
        return "Department Deleted Successfully.....";
    }

    @PutMapping("/update/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,@RequestBody Department department){
        return deparmentService.updateDepartment(departmentId,department);
    }

    @GetMapping("/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName){
        return deparmentService.getDepartmentByName(departmentName);
    }

}
