package com.example.devinagro.controller;

import com.example.devinagro.dto.EnterpriseDto;
import com.example.devinagro.dto.FarmDto;
import com.example.devinagro.model.Enterprise;
import com.example.devinagro.model.Farm;
import com.example.devinagro.service.EnterpriseService;
import com.example.devinagro.service.FarmService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/farm")
public class FarmController {

    private FarmService farmService;
    private EnterpriseService enterpriseService;

    @GetMapping("/all")
    public ResponseEntity<List<Farm>> findAll(){
        List<Farm> list = farmService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Farm> findById(@PathVariable Long id){
        Farm obj = farmService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping( "/insert")
    public ResponseEntity<Farm> insert(@RequestBody Farm farm){
        farm = farmService.add(farm);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{id}").buildAndExpand(farm.getId()).toUri();
        return ResponseEntity.created(uri).body(farm);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Farm> update(@PathVariable Long id, @RequestBody FarmDto farm){
        Farm result = farmService.update(id, farm.converter(farmService.findById(id)));
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        farmService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "enterprise/{id}")
    public ResponseEntity<List<Farm>> findByEnterprise(@PathVariable Long id){
        List<Farm> list = farmService.findAllEnterprisesById(id);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "count/{id}")
    public int countByEnterprise(@PathVariable Long id){
        return farmService.countEnterprisesById(id);
    }

}
