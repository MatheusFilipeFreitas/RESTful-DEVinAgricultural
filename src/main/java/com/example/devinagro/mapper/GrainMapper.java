package com.example.devinagro.mapper;

import com.example.devinagro.dto.GrainDto;
import com.example.devinagro.models.Grain;

public class GrainMapper {

    public static Grain mapGrain(GrainDto grainDto){
        Grain grain = new Grain();
        grain.setName(grainDto.getName());
        grain.setAverageHarvest(grainDto.getAverageHarvest());
        return grain;
    }
}
