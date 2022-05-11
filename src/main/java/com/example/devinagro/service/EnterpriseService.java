package com.example.devinagro.service;

import com.example.devinagro.models.Enterprise;
import com.example.devinagro.repository.EnterpriseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseService {

    private final EnterpriseRepository repository;

    public EnterpriseService(EnterpriseRepository repository){
        this.repository = repository;
    }

    public List<Enterprise> findAll(){
        return repository.findAll();
    }

}
