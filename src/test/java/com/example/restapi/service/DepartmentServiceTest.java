package com.example.restapi.service;

import com.example.restapi.entity.Department;
import com.example.restapi.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceTest {
//write test cases for both positive and negative scenarios
    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department dep =
                Department.builder()
                        .departmentId(2L)
                        .departmentCode("wow")
                        .departmentAddress("34567")
                        .departmentName("IT").build();
        Mockito.when(departmentRepository.findBydepartmentName("IT")).thenReturn(dep);
    }

    @Test
    @DisplayName("get data based on valid departmentName")
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String name = "IT";
        Department found=departmentService.fetchByName(name);
        assertEquals(name,found.getDepartmentName());

    }
}