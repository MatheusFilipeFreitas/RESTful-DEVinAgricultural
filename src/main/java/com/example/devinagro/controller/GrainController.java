package com.example.devinagro.controller;

import com.example.devinagro.dto.GrainDto;
import com.example.devinagro.model.Grain;
import com.example.devinagro.service.GrainService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/grain")
public class GrainController {

    private GrainService grainService;

    //localhost:8080/grain/all

    @GetMapping("/all")
    public ResponseEntity<List<Grain>> findAll(){
        List<Grain> list = grainService.findAll();
        return ResponseEntity.ok().body(list);
    }

    //"{id}" change to the number you want.
    //localhost:8080/grain/{id}

    @GetMapping(value = "/{id}")
    public ResponseEntity<Grain> findById(@PathVariable Long id){
        Grain obj = grainService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    //"{id}" change to the number you want.
    //localhost:8080/grain/enterprise/{id}

    @GetMapping("/enterprise/{id}")
    public ResponseEntity<List<Grain>> findAllByEnterpriseId(@PathVariable Long id){
        List<Grain> list = grainService.findAllByEnterpriseId(id);
        return ResponseEntity.ok().body(list);
    }

    //localhost:8080/grain/insert

    @PostMapping( "/insert")
    public ResponseEntity<Grain> insert(@RequestBody Grain grain){
        grain = grainService.add(grain);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{id}").buildAndExpand(grain.getId()).toUri();
        return ResponseEntity.created(uri).body(grain);
    }

    //"{id}" change to the number you want.
    //localhost:8080/grain/{id}

    @PutMapping("/{id}")
    public ResponseEntity<Grain> update(@PathVariable Long id, @RequestBody GrainDto grain){
        Grain result = grainService.update(id, grain.converter(grainService.findById(id)));
        return ResponseEntity.ok().body(result);
    }

    //"{id}" change to the number you want.
    //localhost:8080/grain/{id}

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        grainService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
