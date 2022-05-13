package com.example.devinagro.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class FarmNextHarvestDto {

    private Long id;
    private LocalDate nextHarvest;
}
