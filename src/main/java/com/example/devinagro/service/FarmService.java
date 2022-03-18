package com.example.devinagro.service;

import com.example.devinagro.dto.FarmDto;
import com.example.devinagro.model.Enterprise;
import com.example.devinagro.model.Farm;
import com.example.devinagro.repository.FarmRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@AllArgsConstructor
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

    public Farm update(Long id, Farm farm){
        return farmRepository.save(farm);
    }

    public void delete(Long id){
        farmRepository.deleteById(id);
    }

    public List<Farm> findAllEnterprisesById(Long id){
        return farmRepository.findAllByEnterpriseId(id);
    }

    public int countEnterprisesById(Long id){
        return farmRepository.countAllByEnterpriseId(id);
    }

    public List<Farm> findAllEnterprisesByIdAttributes(Long id){
        return farmRepository.findAllByEnterpriseId(id);
    }


}
