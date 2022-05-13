package com.example.devinagro.service;

import com.example.devinagro.models.Enterprise;
import com.example.devinagro.models.Grain;
import com.example.devinagro.repository.EnterpriseRepository;
import com.example.devinagro.repository.GrainRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class GrainService {

    private final GrainRepository repository;
    private final EnterpriseService enterpriseService;

    public GrainService(GrainRepository repository, EnterpriseService enterpriseService){
        this.repository = repository;
        this.enterpriseService = enterpriseService;
    }

    public List<Grain> findAll(){
        return repository.findAll();
    }

    public Grain insert(Grain grain){
        return repository.save(grain);
    }

    public Grain update(Long id, Grain grain){
        Grain grainOverride = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Model not found!"));
        grainOverride.setName(grain.getName());
        grainOverride.setAverageHarvest(grain.getAverageHarvest());
        return repository.save(grainOverride);
    }

    public void delete(Long id){
        repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Model not found!"));
        repository.deleteById(id);
    }

    //TODO: addEnterprise(grain, id)

    public Integer countGrainsByEnterprise(Long id){
        enterpriseService.findById(id);
        return repository.countFarmsByEnterprise(id);
    }

    public String grainName(Long id){
        repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Model not found!"));
        return repository.grainNameById(id);
    }

    public List<Grain> findGrainByEnterprise(Long id){
        enterpriseService.findById(id);
        return  repository.findGrainsByEnterpriseId(id);
    }
}
