package com.example.devinagro.controllers;

import com.example.devinagro.dto.EmployeeDto;
import com.example.devinagro.mapper.EmployeeMapper;
import com.example.devinagro.models.Employee;
import com.example.devinagro.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService service;

    public EmployeeController(EmployeeService service){
        this.service = service;
    }

    @GetMapping("/all")
    public List<Employee> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Employee insert(@RequestBody @Valid EmployeeDto employeeDto) {
        return service.insert(EmployeeMapper.mapEmployee(employeeDto));
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody @Valid EmployeeDto employeeDto) {
        return service.update(id, EmployeeMapper.mapEmployee(employeeDto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping("/count")
    public Integer countEmployeeByEnterprise(@RequestParam(value = "enterpriseId") Long id){
        return service.countEmployeesByEnterprise(id);
    }

    @GetMapping("/find")
    public List<Employee> findEmployeeByEnterprise(@RequestParam(value = "enterpriseId") Long id){
        return service.findEmployeeByEnterprise(id);
    }
}
