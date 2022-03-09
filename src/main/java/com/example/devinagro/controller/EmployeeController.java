package com.example.devinagro.controller;

import com.example.devinagro.model.Employee;
import com.example.devinagro.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> findAll(){
        List<Employee> list = employeeService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id){
        Employee obj = employeeService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
