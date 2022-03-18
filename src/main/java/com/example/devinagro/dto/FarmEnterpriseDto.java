package com.example.devinagro.dto;

import com.example.devinagro.model.Enterprise;
import com.example.devinagro.model.Farm;
import com.example.devinagro.model.Grain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FarmEnterpriseDto {

    private Long id;

    private String name;

    @JsonIgnore
    private String location;

    @JsonIgnore
    private double startInventory;

    @JsonIgnore
    private String lastHarvest;

    private String nextHarvest;

    @JsonIgnore
    private Grain grain;

    @JsonIgnore
    private Enterprise enterprise;


    public Farm converter(Farm farm){
        farm.setId(id);
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
