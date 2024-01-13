package org.bootcoding.repository;

import org.bootcoding.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

//    public Department findByDepartmentName(String departmentName); case-sensitive method

    public Department findByDepartmentNameIgnoreCase(String departmentName); // cse-insensitive method

}
