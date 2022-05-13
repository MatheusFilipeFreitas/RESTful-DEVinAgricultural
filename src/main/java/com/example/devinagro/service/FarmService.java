package com.example.devinagro.service;

import com.example.devinagro.dto.FarmNextHarvestDto;
import com.example.devinagro.mapper.FarmMapper;
import com.example.devinagro.models.Enterprise;
import com.example.devinagro.models.Farm;
import com.example.devinagro.repository.FarmRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FarmService {

    /*
        TODO: 1- Add Grain Service
              2- showGrainStock(id);
              3- showGrainByFarm(farmList);
     */


    private final FarmRepository repository;
    private final EnterpriseService enterpriseService;

    public FarmService (FarmRepository farmRepository, EnterpriseService enterpriseService){
        this.repository = farmRepository;
        this.enterpriseService = enterpriseService;
    }

    public List<Farm> findAll() {
        return repository.findAll();
    }

    public Farm insert(Farm farm){
        return repository.save(farm);
    }

    public Farm update(Long id, Farm farm) {
        Farm overrideFarm = repository.findById(id) //
                .orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada"));
        overrideFarm.setName(farm.getName());
        overrideFarm.setAddress(farm.getAddress());
        overrideFarm.setStock(farm.getStock());
        //addEnterpriseId(overrideFarm, farm.getEnterprise());
        //addGrainId(overrideFarm, farm.getGrain());
        return repository.save(overrideFarm);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Farm createStock(Long id, Double value){
        Farm overrideFarm = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Model not found!"));
        overrideFarm.setStock(overrideFarm.getStock() - value);
        if(overrideFarm.getStock() < 0){
            overrideFarm.setStock(0.);
        }
        repository.save(overrideFarm);
        return overrideFarm;
    }

    public Farm useStock(Long id, Double value){
        Farm overrideFarm = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Model not found!"));
        overrideFarm.setLastHarvest(LocalDate.now());
        overrideFarm.setStock(overrideFarm.getStock() + value);
        repository.save(overrideFarm);
        return overrideFarm;
    }

    public void addEnterpriseId(Farm farm, Long id){
        Enterprise enterprise = enterpriseService.findById(id);
        farm.setEnterprise(enterprise);
    }

    //TODO: addGrainId(farm,id);

    public List<Farm> findFarmsByEnterprise(Long id){
        enterpriseService.findById(id);
        return repository.findFarmByEnterpriseId(id);
    }

    public Integer countFarmByEnterprise(Long id){
        enterpriseService.findById(id);
        return repository.countFarmByEnterpriseId(id);
    }

    public List<FarmNextHarvestDto> showNextHarvest(Long id){
        enterpriseService.findById(id);
        List<FarmNextHarvestDto> list = new ArrayList<>();
        for(Farm farm: repository.findAll()){
            FarmNextHarvestDto farmNextHarvestDto = FarmMapper.mapNextHarvestDto(farm);
            farmNextHarvestDto.setNextHarvest(nextHarvestDate(farm.getLastHarvest(), 12)); //TODO: Add Grain average time to averageDate!
        }
        return list;
    }

    public LocalDate nextHarvestDate(LocalDate lastHarvest, int averageDate){
        LocalDate nextHarvest;
        if(lastHarvest == null){
            nextHarvest = LocalDate.now().plusDays(averageDate);
        }else{
            nextHarvest = lastHarvest.plusDays(averageDate);
        }
        return nextHarvest;
    }


}
