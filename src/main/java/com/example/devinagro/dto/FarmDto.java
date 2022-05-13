package com.example.devinagro.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class FarmDto {
    private String name;
    private String address;
    private LocalDate lastHarvest;
    private Double stock;

    private Long enterprise;
    private Long grain;
}
