package com.example.restapi.service;

import com.example.restapi.entity.Department;
import com.example.restapi.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {



    public Department saveDepartment(Department dep);

    public List<Department> fetchDepartment();

    public Department fetchDepBYID(Long departmentId) throws DepartmentNotFoundException;

    public void deleteByID(Long departmentId);

    public Department updateByID(Long departmentId, Department dep);

    public Department fetchByName(String departmentName);
    //one service can have multiple implementations
}
