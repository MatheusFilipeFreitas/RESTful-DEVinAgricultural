package com.example.devinagro.dto;

import com.example.devinagro.model.Employee;
import com.example.devinagro.model.Enterprise;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private String name;
    private String lastName;
    private String cpf;
    private String address;
    private String phoneNumber;
    private String birthDate;
    private String hiringDate;
    private Enterprise enterprise;

    public Employee converter(Employee employee){
        employee.setName(name);
        employee.setLastName(lastName);
        employee.setCpf(cpf);
        employee.setAddress(address);
        employee.setPhoneNumber(phoneNumber);
        employee.setBirthDate(birthDate);
        employee.setHiringDate(hiringDate);
        employee.setEnterprise(enterprise);
        return employee;
    }
}
