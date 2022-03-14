package com.example.devinagro.controller;

import com.example.devinagro.model.Employee;
import com.example.devinagro.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> findAll(){
        List<Employee> list = employeeService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id){
        Employee obj = employeeService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping( "/insert")
    public ResponseEntity<Employee> insert(@RequestBody Employee employee){
        employee = employeeService.add(employee);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{id}").buildAndExpand(employee.getId()).toUri();
        return ResponseEntity.created(uri).body(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody Employee employee){
        employee = employeeService.update(id, employee);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{id}").buildAndExpand(employee.getId()).toUri();
        return ResponseEntity.ok().body(employee);
    }

}
