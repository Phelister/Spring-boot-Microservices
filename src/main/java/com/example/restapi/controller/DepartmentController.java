package com.example.restapi.controller;

import com.example.restapi.entity.Department;
import com.example.restapi.error.DepartmentNotFoundException;
import com.example.restapi.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {
    //depservice
    @Autowired
    private DepartmentService departmentService;
    private final Logger Logs = LoggerFactory.getLogger(DepartmentController.class);

     @PostMapping("/department")
     //to convert json body to department type
    public Department saveDepartment(@Valid @RequestBody Department dep){
         //public Department saveDepartment(@Valid @RequestBody Department dep,@RequestHeader String ipaddress){
        // System.out.println(ipaddress);
        // if()
         Logs.info("inside save department of department controller");
         return departmentService.saveDepartment(dep);
    }

    @GetMapping("/department")
    public List<Department> fetchDepartment(){
         return departmentService.fetchDepartment();
    }

    @GetMapping("/department/{id}")
    public Department fetchDepBYID(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
         return departmentService.fetchDepBYID(departmentId);
    }

    @DeleteMapping("/department/{id}")
    public String deleteByID(@PathVariable("id") Long departmentId){
        departmentService.deleteByID(departmentId);
        return "ID deleted successfully";
    }
    @PutMapping("/department/{id}")
    public Department updateByID(@PathVariable("id")Long departmentId, @RequestBody Department dep){
         return departmentService.updateByID(departmentId, dep);
    }
    @GetMapping("/department/name/{name}")
    public Department fetchByName(@PathVariable("name") String departmentName){
         return departmentService.fetchByName(departmentName);
    }
}
