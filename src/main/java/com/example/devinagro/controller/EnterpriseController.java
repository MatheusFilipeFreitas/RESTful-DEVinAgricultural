package com.example.devinagro.controller;

import com.example.devinagro.dto.EmployeeDto;
import com.example.devinagro.dto.EnterpriseDto;
import com.example.devinagro.model.Employee;
import com.example.devinagro.model.Enterprise;
import com.example.devinagro.service.EnterpriseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {

    private EnterpriseService enterpriseService;

    //EndPoint 1)

    @GetMapping("/all")
    public ResponseEntity<List<Enterprise>> findAll(){
        List<Enterprise> list = enterpriseService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Enterprise> findById(@PathVariable Long id){
        Enterprise obj = enterpriseService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping( "/insert")
    public ResponseEntity<Enterprise> insert(@RequestBody Enterprise enterprise){
        enterprise = enterpriseService.add(enterprise);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{id}").buildAndExpand(enterprise.getId()).toUri();
        return ResponseEntity.created(uri).body(enterprise);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Enterprise> update(@PathVariable Long id, @RequestBody EnterpriseDto enterprise){
       Enterprise result = enterpriseService.update(id, enterprise.converter(enterpriseService.findById(id)));
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        enterpriseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
