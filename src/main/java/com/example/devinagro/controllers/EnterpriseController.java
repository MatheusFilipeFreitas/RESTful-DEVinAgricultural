package com.example.devinagro.controllers;

import com.example.devinagro.models.Enterprise;
import com.example.devinagro.service.EnterpriseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {

    /*TODO: 1- Enterprise Service
            2- Controller Constructor
            4- Insert
            5- Update
            6- Delete
     */

    private EnterpriseService service;

    public EnterpriseController(EnterpriseService service){
        this.service = service;
    }

    @GetMapping("/all")
    public List<Enterprise> findAll(){
        return service.findAll();
    }
}
