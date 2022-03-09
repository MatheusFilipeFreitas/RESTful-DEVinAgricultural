package com.example.devinagro.service;

import com.example.devinagro.model.Enterprise;
import com.example.devinagro.repository.EnterpriseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseService {

    private EnterpriseRepository enterpriseRepository;

    public List<Enterprise> findAll(){
        return enterpriseRepository.findAll();
    }

    public Enterprise findById(Long id){
        return enterpriseRepository.getById(id);
    }

    public Enterprise add(Enterprise enterprise){
        return enterpriseRepository.save(enterprise);
    }

    public Enterprise update(Enterprise enterprise){
        return enterpriseRepository.save(enterprise);
    }

    public void delete(Enterprise enterprise){
        enterpriseRepository.delete(enterprise);
    }
}
