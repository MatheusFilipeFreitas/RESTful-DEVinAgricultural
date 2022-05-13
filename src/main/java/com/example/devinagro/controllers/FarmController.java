package com.example.devinagro.controllers;

import com.example.devinagro.dto.FarmDto;
import com.example.devinagro.dto.FarmNextHarvestDto;
import com.example.devinagro.mapper.FarmMapper;
import com.example.devinagro.models.Farm;
import com.example.devinagro.service.FarmService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/farm")
public class FarmController {

    private FarmService service;

    public FarmController(FarmService service){
        this.service = service;
    }

    @GetMapping("/all")
    public List<Farm> findAll(){
        return service.findAll();
    }

    @PostMapping
    public Farm insert(@RequestBody @Valid FarmDto farmDto){
        return service.insert(FarmMapper.mapFarm(farmDto));
    }

    @PutMapping("/{id}")
    public Farm update(@PathVariable Long id, @RequestBody @Valid FarmDto farmDto){
        return service.update(id, FarmMapper.mapFarm(farmDto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @PostMapping("/stock/create/{id}")
    public Farm createStock(@PathVariable Long id, @RequestParam(value = "value") Double value){
        return service.createStock(id, value);
    }

    @PostMapping("/stock/use/{id}")
    public Farm useStock(@PathVariable Long id, @RequestParam(value = "value") Double value){
        return service.useStock(id, value);
    }

    @GetMapping("/farms-by/all")
    public List<Farm> showFarmsByEnterprise(@RequestParam(value = "id") Long id){
        return service.findFarmsByEnterprise(id);
    }

    @GetMapping("/farms-by/count")
    public Integer countFarmsByEnterprise(@RequestParam(value = "id") Long id){
        return service.countFarmByEnterprise(id);
    }

    @GetMapping("/next-harvest/list")
    public List<FarmNextHarvestDto> showFarmNextHarvest(@RequestParam(value = "id") Long id){
        return service.showNextHarvest(id);
    }

    //TODO: showStockByEnterprise(id);

}
