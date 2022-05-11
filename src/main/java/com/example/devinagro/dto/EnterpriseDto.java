package com.example.devinagro.dto;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class EnterpriseDto {

    private String name;
    @Pattern(regexp = "(^\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2}$)", message = "invalid CNPJ!")
    private String cnpj;
    private String address;

}
