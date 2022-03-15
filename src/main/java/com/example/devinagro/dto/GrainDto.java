package com.example.devinagro.dto;

import com.example.devinagro.model.Enterprise;
import com.example.devinagro.model.Grain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GrainDto {

    private String name;
    private Long averageDays;
    private Enterprise enterprise;

    public Grain converter(Grain grain){
        grain.setName(name);
        grain.setAverageDays(averageDays);
        grain.setEnterprise(enterprise);
        return grain;
    }
}
