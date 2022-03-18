package com.example.devinagro.controller;

import com.example.devinagro.dto.EnterpriseDto;
import com.example.devinagro.dto.FarmDto;
import com.example.devinagro.dto.FarmEnterpriseDto;
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

    //localhost:8080/farm/insert

    @GetMapping("/all")
    public ResponseEntity<List<Farm>> findAll(){
        List<Farm> list = farmService.findAll();
        return ResponseEntity.ok().body(list);
    }

    //"{id}" change to the number you want.
    //localhost:8080/farm/{id}

    @GetMapping(value = "/{id}")
    public ResponseEntity<Farm> findById(@PathVariable Long id){
        Farm obj = farmService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    //"{id}" change to the number you want.
    //localhost:8080/farm/enterprise/{id}

    @GetMapping(value = "enterprise/{id}")
    public ResponseEntity<List<Farm>> findByEnterprise(@PathVariable Long id){
        List<Farm> list = farmService.findAllEnterprisesById(id);
        return ResponseEntity.ok().body(list);
    }

    //"{id}" change to the number you want.
    //localhost:8080/farm/count/{id}

    @GetMapping(value = "count/{id}")
    public int countByEnterprise(@PathVariable Long id){
        return farmService.countEnterprisesById(id);
    }

    //"{id}" change to the number you want.
    //localhost:8080/farm/attributes/{id}

    @GetMapping(value = "attributes/{id}")
    public ResponseEntity<List<Farm>> findByEnterpriseAttributes(@PathVariable Long id){
        List<Farm> list = farmService.findAllEnterprisesByIdAttributes(id);
        return ResponseEntity.ok().body(list);
    }

    //localhost:8080/farm/insert

    @PostMapping( "/insert")
    public ResponseEntity<Farm> insert(@RequestBody Farm farm){
        farm = farmService.add(farm);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{id}").buildAndExpand(farm.getId()).toUri();
        return ResponseEntity.created(uri).body(farm);
    }

    //"{id}" change to the number you want.
    //localhost:8080/farm/{id}

    @PutMapping("/{id}")
    public ResponseEntity<Farm> update(@PathVariable Long id, @RequestBody FarmDto farm){
        Farm result = farmService.update(id, farm.converter(farmService.findById(id)));
        return ResponseEntity.ok().body(result);
    }

    //"{id}" change to the number you want.
    //localhost:8080/farm/{id}

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        farmService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
