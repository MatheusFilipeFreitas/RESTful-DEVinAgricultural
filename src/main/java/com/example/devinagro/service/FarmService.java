package com.example.devinagro.service;

import com.example.devinagro.model.Farm;
import com.example.devinagro.repository.FarmRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmService {

    private FarmRepository farmRepository;

    public List<Farm> findAll(){
        return farmRepository.findAll();
    }

    public Farm findById(Long id){
        return farmRepository.getById(id);
    }

    public Farm add(Farm farm){
        return farmRepository.save(farm);
    }

    public Farm update(Farm farm){
        return farmRepository.save(farm);
    }

    public void delete(Farm farm){
        farmRepository.delete(farm);
    }
}
