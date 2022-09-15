package com.example.restapi.service;

import com.example.restapi.entity.Department;
import com.example.restapi.error.DepartmentNotFoundException;
import com.example.restapi.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    private DepartmentRepository depRepo;

    @Override
    public Department saveDepartment(Department dep) {
        //to save in the table
        return depRepo.save(dep);
    }

    @Override
    public List<Department> fetchDepartment() {
        //get all departments and return
        return depRepo.findAll();
    }

    @Override
    public Department fetchDepBYID(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> y = depRepo.findById(departmentId);
        if(!y.isPresent()){
            throw new DepartmentNotFoundException("Cant see department");
        }
        return y.get();
    }

    @Override
    public void deleteByID(Long departmentId) {
          depRepo.deleteById(departmentId);
    }

    @Override
    public Department updateByID(Long departmentId, Department dep) {
        Department depDB= depRepo.findById(departmentId).get();

        if((Objects.nonNull(dep.getDepartmentName())) && !"".equalsIgnoreCase(dep.getDepartmentName())){
            depDB.setDepartmentName(dep.getDepartmentName());
        }

        if((Objects.nonNull(dep.getDepartmentAddress())) && !"".equalsIgnoreCase(dep.getDepartmentAddress())){
            depDB.setDepartmentAddress(dep.getDepartmentAddress());
        }
        if((Objects.nonNull(dep.getDepartmentCode())) && !"".equalsIgnoreCase(dep.getDepartmentCode())){
            depDB.setDepartmentCode(dep.getDepartmentCode());
        }
        return depRepo.save(depDB);
    }

    @Override
    public Department fetchByName(String departmentName){
        //no particular methodology to fetch by name from hence create the method
        return depRepo.findBydepartmentName(departmentName);
    }
}
