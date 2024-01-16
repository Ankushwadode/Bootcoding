package org.bootcoding.controller;

import org.bootcoding.entity.Department;
import org.bootcoding.service.DeparmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DeparmentService deparmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentAddress("campus A-building")
                .departmentCode("IT-06")
                .departmentName("IT")
                .departmentId(1L)
                .build();
    }

    @Test
    void saveDepartments() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentAddress("campus A-building")
                .departmentCode("IT-06")
                .departmentName("IT")
                .build();

        Mockito.when(deparmentService.saveDepartments(inputDepartment)).thenReturn(department);

        mockMvc.perform(
                post("/api/v1/department/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"departmentName\":\"IT\",\n" +
                        "    \"departmentAddress\": \"campus A-building\",\n" +
                        "    \"departmentCode\": \"IT-06\"\n" +
                        "}"))
                .andExpect(status().isOk()
        );
    }

    @Test
    void getDepartmentById() throws Exception {
        Mockito.when(deparmentService.getDepartmetnById(1L)).thenReturn(department);

        mockMvc.perform(
                get("/api/v1/department/get/1")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName")
                        .value(department.getDepartmentName())
                );
    }
}