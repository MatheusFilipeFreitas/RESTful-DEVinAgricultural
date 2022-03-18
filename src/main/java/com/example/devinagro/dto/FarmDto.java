package com.example.devinagro.dto;

import com.example.devinagro.model.Enterprise;
import com.example.devinagro.model.Farm;
import com.example.devinagro.model.Grain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FarmDto {

    @JsonIgnore
    private Long id;

    private String name;

    private String location;

    private double startInventory;

    private String lastHarvest;

    private String nextHarvest;

    private Grain grain;

    @JsonIgnore
    private Enterprise enterprise;


    public Farm converter(Farm farm){
        farm.setName(name);
        farm.setLocation(location);
        farm.setStartInventory(startInventory);
        farm.setLastHarvest(lastHarvest);
        farm.setNextHarvest(nextHarvest);
        farm.setGrain(grain);
        farm.setEnterprise(enterprise);
        return farm;
    }


}
