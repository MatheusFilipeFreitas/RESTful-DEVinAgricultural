package com.example.devinagro.dto;

import com.example.devinagro.models.Enterprise;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
public class EmployeeDto {

    private String name;
    private String lastName;
    @Pattern(regexp = "(^(\\d{3}.\\d{3}.\\d{3}-\\d{2}))", message = "invalid CPF")
    private String cpf;
    private String address;
    @Pattern(regexp = "^\\(\\d{2}\\)\\d{5}\\d{4}$", message = "invalid Phone Number")
    private String phoneNumber;
    private String gender;
    private LocalDate birthDate;
    private LocalDate hiringDate;
    private Long enterprise;
}
