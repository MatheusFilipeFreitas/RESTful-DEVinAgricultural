package com.example.devinagro.service;

import com.example.devinagro.model.Employee;
import com.example.devinagro.model.Enterprise;
import com.example.devinagro.repository.EnterpriseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EnterpriseService {

    private EnterpriseRepository enterpriseRepository;

    public List<Enterprise> findAll(){
        return enterpriseRepository.findAll();
    }

    public Enterprise findById(Long id){
        return enterpriseRepository.getById(id);
    }

    public Enterprise add(Enterprise enterprise){
        return enterpriseRepository.save(enterprise);
    }

    public Enterprise update(Long id, Enterprise enterprise){
        /*
        SEE Uptade using DTO class

        Employee searchEmployee = employeeRepository.getById(id);
        searchEmployee.setName(employee.getName());
        searchEmployee.setLastName(employee.getLastName());
        searchEmployee.setCpf(employee.getCpf());
        searchEmployee.setAddress(employee.getAddress());
        searchEmployee.setPhoneNumber(employee.getPhoneNumber());
        searchEmployee.setBirthDate(employee.getBirthDate());
        searchEmployee.setHiringDate(employee.getHiringDate());
        searchEmployee.setEnterprise(employee.getEnterprise());
        */
        return enterpriseRepository.save(enterprise);
    }

    public void delete(Long id){
        enterpriseRepository.deleteById(id);
    }
}
