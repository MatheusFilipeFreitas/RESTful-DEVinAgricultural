package com.example.devinagro.mapper;

import com.example.devinagro.dto.EmployeeDto;
import com.example.devinagro.models.Employee;

public class EmployeeMapper {

    public static Employee mapEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setLastName(employeeDto.getLastName());
        employee.setCpf(employeeDto.getCpf());
        employee.setAddress(employeeDto.getAddress());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setGender(employeeDto.getGender());
        employee.setBirthDate(employeeDto.getBirthDate());
        employee.setHiringDate(employeeDto.getHiringDate());
        return employee;
    }
}
