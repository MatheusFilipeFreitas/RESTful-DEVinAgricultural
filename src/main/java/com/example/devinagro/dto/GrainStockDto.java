package com.example.devinagro.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GrainStockDto implements Comparable<GrainStockDto>{

    private String name;
    private Double stock;

    @Override
    public int compareTo(GrainStockDto othergrainStockDto){
        if(this.stock > othergrainStockDto.getStock()){
            return 1;
        }
        if (this.stock < othergrainStockDto.getStock()){
            return -1;
        }
        return 0;
    }
}
