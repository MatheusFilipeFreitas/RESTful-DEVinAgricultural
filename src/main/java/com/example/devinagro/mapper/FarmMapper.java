package com.example.devinagro.mapper;

import com.example.devinagro.dto.FarmDto;
import com.example.devinagro.dto.FarmNextHarvestDto;
import com.example.devinagro.models.Farm;

public class FarmMapper {

    public static Farm mapFarm(FarmDto farmDto){
        Farm farm = new Farm();
        farm.setName(farmDto.getName());
        farm.setAddress(farmDto.getAddress());
        farm.setStock(farmDto.getStock());
        farm.setLastHarvest(farmDto.getLastHarvest());
        return farm;
    }

    public static FarmNextHarvestDto mapNextHarvestDto(Farm farm){
        FarmNextHarvestDto farmNextHarvestDto = new FarmNextHarvestDto();
        farmNextHarvestDto.setId(farm.getId());
        return farmNextHarvestDto;
    }
}
