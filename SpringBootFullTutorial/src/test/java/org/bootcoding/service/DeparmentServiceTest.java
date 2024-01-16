package org.bootcoding.service;

import org.bootcoding.entity.Department;
import org.bootcoding.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DeparmentService deparmentService;

    @Mock
    private DepartmentRepository repository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentId(1L)
                .departmentAddress("A-building")
                .departmentCode("B-01")
                .departmentName("IT")
                .build();

        Mockito.when(repository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
    }

    @Test
    @DisplayName("get data by valid department name.")
    public void ValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName = "IT";
        Department found = deparmentService.getDepartmentByName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());
    }
}