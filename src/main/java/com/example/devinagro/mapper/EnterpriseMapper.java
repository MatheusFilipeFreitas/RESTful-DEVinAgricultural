package com.example.devinagro.mapper;

import com.example.devinagro.dto.EnterpriseDto;
import com.example.devinagro.models.Enterprise;

public class EnterpriseMapper {

    public static Enterprise mapEnterprise(EnterpriseDto enterpriseDto){
        Enterprise enterprise = new Enterprise();
        enterprise.setName(enterpriseDto.getName());
        enterprise.setCnpj(enterpriseDto.getCnpj());
        enterprise.setAddress(enterpriseDto.getAddress());
        return enterprise;
    }
}
