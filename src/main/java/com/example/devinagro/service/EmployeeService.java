package com.example.devinagro.service;

import com.example.devinagro.dto.EmployeeDto;
import com.example.devinagro.model.Employee;
import com.example.devinagro.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Employee findById(Long id){
        return employeeRepository.getById(id);
    }

    public Employee add(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee update(Long id, Employee employee){
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
        return employeeRepository.save(employee);
    }

    public void delete(Long id){
        employeeRepository.deleteById(id);
    }
}
