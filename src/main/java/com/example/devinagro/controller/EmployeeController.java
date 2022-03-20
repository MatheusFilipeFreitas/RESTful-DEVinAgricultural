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

    //GET ALL
    //localhost:8080/employee/all

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> findAll(){
        List<Employee> list = employeeService.findAll();
        return ResponseEntity.ok().body(list);
    }

    //GET BY ID
    //localhost:8080/employee/insert

    @GetMapping(value = "/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id){
        Employee obj = employeeService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    //GET BY ENTERPRISE ID
    //"{id}" change to the number you want.
    //localhost:8080/employee/enterprise/{id}

    @GetMapping("/enterprise/{id}")
    public ResponseEntity<List<Employee>> findAllByEnterpriseId(@PathVariable Long id){
        List<Employee> list = employeeService.findAllByEnterpriseId(id);
        return ResponseEntity.ok().body(list);
    }

    //COUNT BY ENTERPRISE ID
    //"{id}" change to the number you want.
    //localhost:8080/employee/count/{id}

    @GetMapping(value = "/count/{id}")
    public int countAllByEnterpriseId(@PathVariable Long id){
        return employeeService.countAllByEnterpriseId(id);
    }

    //INSERT
    //localhost:8080/employee/insert

    @PostMapping( "/insert")
    public ResponseEntity<EmployeeDto> insert(@RequestBody EmployeeDto employeeDto){

        //Validate cpf format and phone number format
        // CPF: xxx.xxx.xxx-xx
        // PHONE NUMBER: (xx)xxxxxxxxx
        if((employeeDto.getPhoneNumber().indexOf('(',0) >= 0 && employeeDto.getPhoneNumber().indexOf(')',2)  >= 0  )
             && (employeeDto.getCpf().indexOf('.',3)  >= 0  && employeeDto.getCpf().indexOf('.',7)  >= 0  && employeeDto.getCpf().indexOf('-',11)  >= 0 )){

            //Return Employee obj
            Employee employee = employeeService.add(employeeDto.build());
            URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{id}").buildAndExpand(employee.getId()).toUri();
            return ResponseEntity.created(uri).body(employeeDto);
        }else{
            return null;
        }

    }

    //UPDATE
    //"{id}" change to the number you want.
    //localhost:8080/employee/{id}

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> update(@PathVariable Long id, @RequestBody EmployeeDto employeeDto){

        //Validate cpf format and phone number format
        // CPF: xxx.xxx.xxx-xx
        // PHONE NUMBER: (xx)xxxxxxxxx
        if((employeeDto.getPhoneNumber().indexOf('(',0) >= 0 && employeeDto.getPhoneNumber().indexOf(')',2)  >= 0  )
                && (employeeDto.getCpf().indexOf('.',3)  >= 0  && employeeDto.getCpf().indexOf('.',7)  >= 0  && employeeDto.getCpf().indexOf('-',11)  >= 0 )){

            //Return Employee obj
            employeeService.update(id, employeeDto.converter(employeeService.findById(id)));
            return ResponseEntity.ok().body(employeeDto);
        }else{
            return null;
        }
    }

    //DELETE
    //"{id}" change to the number you want.
    //localhost:8080/employee/{id}

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
