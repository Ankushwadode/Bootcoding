package org.bootcoding.controller;

import jakarta.validation.Valid;
import org.bootcoding.entity.Department;
import org.bootcoding.service.DeparmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

    @Autowired
    private DeparmentService deparmentService;

    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/save")
    public Department saveDepartments(@Valid @RequestBody Department department){
        logger.info("saveDepartment() from department controller");
        return deparmentService.saveDepartments(department);
    }

    @GetMapping("/getAll")
    public List<Department> getDepartmentList(){
        logger.info("getAllDepartmentList() from department controller");
        return deparmentService.getDepartmentList();
    }

    @GetMapping("/get/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId){
        logger.info("getDepartmentById() from department controller");
        return deparmentService.getDepartmetnById(departmentId);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDepartmentById(@PathVariable("id") Long departmentId){
        logger.info("deleteDepartmentById() from department controller");
        deparmentService.deleteDepatmentById(departmentId);
    }

    @PutMapping("/update/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,@RequestBody Department department){
        logger.info("updateDepartment() from department controller");
        return deparmentService.updateDepartment(departmentId,department);
    }

    @GetMapping("/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName){
        logger.info("getDepartmentByName() from department controller");
        return deparmentService.getDepartmentByName(departmentName);
    }

}
