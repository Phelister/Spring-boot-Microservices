package com.example.restapi.repository;

import com.example.restapi.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//entity name and primary key id;
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    //will be case sensitive
    public Department findBydepartmentName(String departmentName);
    //not case sensitive any input is allowable upper or lower case
    public Department findByDepartmentNameIgnoreCase(String departmentName);
}
