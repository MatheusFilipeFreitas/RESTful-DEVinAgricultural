package com.example.devinagro.controllers;

import com.example.devinagro.dto.EnterpriseDto;
import com.example.devinagro.mapper.EnterpriseMapper;
import com.example.devinagro.models.Enterprise;
import com.example.devinagro.service.EnterpriseService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {

    private EnterpriseService service;

    public EnterpriseController(EnterpriseService service){
        this.service = service;
    }

    @GetMapping("/all")
    public List<Enterprise> findAll(){
        return service.findAll();
    }

    @PostMapping
    public Enterprise insert(@RequestBody @Valid EnterpriseDto enterpriseDto){
        return service.insert(EnterpriseMapper.mapEnterprise(enterpriseDto));
    }

    @PutMapping("/{id}")
    public Enterprise update(@RequestBody @Valid EnterpriseDto enterpriseDto, @PathVariable Long id){
        return service.update(id, EnterpriseMapper.mapEnterprise(enterpriseDto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
