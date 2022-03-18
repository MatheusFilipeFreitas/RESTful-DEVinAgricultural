package com.example.devinagro.controller;

import com.example.devinagro.dto.EmployeeDto;
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

    //localhost:8080/employee/all

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> findAll(){
        List<Employee> list = employeeService.findAll();
        return ResponseEntity.ok().body(list);
    }

    //localhost:8080/employee/insert

    @GetMapping(value = "/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id){
        Employee obj = employeeService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    //"{id}" change to the number you want.
    //localhost:8080/employee/enterprise/{id}

    @GetMapping("/enterprise/{id}")
    public ResponseEntity<List<Employee>> findAllByEnterpriseId(@PathVariable Long id){
        List<Employee> list = employeeService.findAllByEnterpriseId(id);
        return ResponseEntity.ok().body(list);
    }

    //"{id}" change to the number you want.
    //localhost:8080/employee/count/{id}

    @GetMapping(value = "/count/{id}")
    public int countAllByEnterpriseId(@PathVariable Long id){
        return employeeService.countAllByEnterpriseId(id);
    }

    //localhost:8080/employee/insert

    @PostMapping( "/insert")
    public ResponseEntity<Employee> insert(@RequestBody Employee employee){
        if((employee.getPhoneNumber().indexOf('(',0) >= 0 && employee.getPhoneNumber().indexOf(')',2)  >= 0  )
             && (employee.getCpf().indexOf('.',3)  >= 0  && employee.getCpf().indexOf('.',7)  >= 0  && employee.getCpf().indexOf('-',11)  >= 0 )){
            employee = employeeService.add(employee);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{id}").buildAndExpand(employee.getId()).toUri();
            return ResponseEntity.created(uri).body(employee);
        }else{
            return null;
        }

    }

    //"{id}" change to the number you want.
    //localhost:8080/employee/{id}

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody EmployeeDto employee){
        if((employee.getPhoneNumber().indexOf('(',0) >= 0 && employee.getPhoneNumber().indexOf(')',2)  >= 0  )
                && (employee.getCpf().indexOf('.',3)  >= 0  && employee.getCpf().indexOf('.',7)  >= 0  && employee.getCpf().indexOf('-',11)  >= 0 )){
            Employee result = employeeService.update(id, employee.converter(employeeService.findById(id)));
            return ResponseEntity.ok().body(result);
        }else{
            return null;
        }
    }

    //"{id}" change to the number you want.
    //localhost:8080/employee/{id}

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
