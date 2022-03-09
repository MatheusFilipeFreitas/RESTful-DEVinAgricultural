package com.example.devinagro.service;

import com.example.devinagro.model.Grain;
import com.example.devinagro.repository.GrainRepository;

import java.util.List;

public class GrainService {

    private GrainRepository grainRepository;

    public List<Grain> findAll(){
        return grainRepository.findAll();
    }

    public Grain findById(Long id){
        return grainRepository.getById(id);
    }

    public Grain add(Grain grain){
        return grainRepository.save(grain);
    }

    public Grain update(Grain grain){
        return grainRepository.save(grain);
    }

    public void delete(Grain grain){
        grainRepository.delete(grain);
    }

}
