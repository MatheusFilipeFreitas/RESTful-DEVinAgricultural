package com.example.devinagro.service;

import com.example.devinagro.models.Enterprise;
import com.example.devinagro.repository.EnterpriseRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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

    public Enterprise insert(Enterprise enterprise){
        return repository.save(enterprise);
    }

    public Enterprise update(Long id, Enterprise enterprise){
        Enterprise overrideEnterprise = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Model not found!"));
        overrideEnterprise.setName(enterprise.getName());
        overrideEnterprise.setCnpj(enterprise.getCnpj());
        overrideEnterprise.setAddress(enterprise.getAddress());
        return repository.save(overrideEnterprise);
    }

    public void delete(Long id){
        repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Model not found!"));
        repository.deleteById(id);
    }

    public Enterprise findById(Long id){
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Model not found"));
    }

}
