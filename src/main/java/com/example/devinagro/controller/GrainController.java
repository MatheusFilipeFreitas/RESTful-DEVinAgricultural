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

    @GetMapping("/all")
    public ResponseEntity<List<Grain>> findAll(){
        List<Grain> list = grainService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Grain> findById(@PathVariable Long id){
        Grain obj = grainService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping( "/insert")
    public ResponseEntity<Grain> insert(@RequestBody Grain grain){
        grain = grainService.add(grain);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{id}").buildAndExpand(grain.getId()).toUri();
        return ResponseEntity.created(uri).body(grain);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grain> update(@PathVariable Long id, @RequestBody GrainDto grain){
        Grain result = grainService.update(id, grain.converter(grainService.findById(id)));
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        grainService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
