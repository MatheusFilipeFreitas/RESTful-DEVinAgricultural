package com.example.devinagro.dto;

import com.example.devinagro.model.Enterprise;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnterpriseDto {

    private String name;
    private String cnpj;
    private String location;

    public Enterprise converter(Enterprise enterprise){
        enterprise.setName(name);
        enterprise.setCnpj(cnpj);
        enterprise.setLocation(location);
        return enterprise;
    }
}
