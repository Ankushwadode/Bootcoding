package org.bootcoding.service.implementation;

import org.bootcoding.customException.DepartmentNotFoundException;
import org.bootcoding.entity.Department;
import org.bootcoding.repository.DepartmentRepository;
import org.bootcoding.service.DeparmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DeparmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartments(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmetnById(Long departmentId) {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if (!department.isPresent()){
            try {
                throw new DepartmentNotFoundException("Department with "+departmentId+" is not Present.");
            } catch (DepartmentNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return department.get();
    }

    @Override
    public void deleteDepatmentById(Long departmentId) {
        Optional<Department> id = departmentRepository.findById(departmentId);
        if (!id.isPresent()) {
            try{
                throw new DepartmentNotFoundException("Department cannot be deleted with Id "+departmentId+" because it's not Present.");
            } catch (DepartmentNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            departmentRepository.deleteById(departmentId);
        }
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {

        Department depDB = departmentRepository.findById(departmentId).get();

        if (Objects.nonNull(department.getDepartmentName()) &&
                !"".equalsIgnoreCase(department.getDepartmentName())){
            depDB.setDepartmentName(department.getDepartmentName());
        }

        if (Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())){
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        if (Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        return departmentRepository.save(depDB);
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }

}
