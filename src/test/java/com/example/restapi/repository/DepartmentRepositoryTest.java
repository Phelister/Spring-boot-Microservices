package com.example.restapi.repository;

import com.example.restapi.entity.Department;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest

class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Department dep =Department.builder()

                .departmentAddress("Cushion")
                .departmentCode("45-L")
                .departmentName("rezak").build();
        testEntityManager.persist(dep);
    }

    @Test
    @DisplayName("Confirm if receiving the right ID")
    public void whenFindDataByID_thenReturnDepartment(){
        Department dep = departmentRepository.findById(1L).get();

        assertEquals(dep.getDepartmentName(),"rezak");
    }
}