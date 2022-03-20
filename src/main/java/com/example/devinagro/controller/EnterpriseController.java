package com.example.devinagro.controller;

import com.example.devinagro.dto.EmployeeDto;
import com.example.devinagro.dto.EnterpriseDto;
import com.example.devinagro.model.Employee;
import com.example.devinagro.model.Enterprise;
import com.example.devinagro.service.EnterpriseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {

    private EnterpriseService enterpriseService;

    //localhost:8080/enterprise/insert

    @GetMapping("/all")
    public ResponseEntity<List<Enterprise>> findAll(){
        List<Enterprise> list = enterpriseService.findAll();
        return ResponseEntity.ok().body(list);
    }

    //"{id}" change to the number you want.
    //localhost:8080/enterprise/{id}

    @GetMapping(value = "/{id}")
    public ResponseEntity<Enterprise> findById(@PathVariable Long id){
        Enterprise obj = enterpriseService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    //localhost:8080/enterprise/insert

    @PostMapping( "/insert")
    public ResponseEntity<Enterprise> insert(@RequestBody Enterprise enterprise){

        //Validate the cnpj format
        //CNPJ: xx.xxx.xxx/xxxx-xx
        if(enterprise.getCnpj().indexOf('.',2) >= 0 && enterprise.getCnpj().indexOf('.',6) >= 0 && enterprise.getCnpj().indexOf('/',10) >= 0 && enterprise.getCnpj().indexOf('-',15) >= 0 ){

            //Return Enterprise obj
            enterprise = enterpriseService.add(enterprise);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{id}").buildAndExpand(enterprise.getId()).toUri();
            return ResponseEntity.created(uri).body(enterprise);
        }else{
            return null;
        }
    }

    //"{id}" change to the number you want.
    //localhost:8080/enterprise/{id}

    @PutMapping("/{id}")
    public ResponseEntity<Enterprise> update(@PathVariable Long id, @RequestBody EnterpriseDto enterprise){

        //Validate the cnpj format
        //CNPJ: xx.xxx.xxx/xxxx-xx
        if(enterprise.getCnpj().indexOf('.',2) >= 0 && enterprise.getCnpj().indexOf('.',6) >= 0 && enterprise.getCnpj().indexOf('/',10) >= 0 && enterprise.getCnpj().indexOf('-',15) >= 0 ){

            //Return Enterprise obj
            Enterprise result = enterpriseService.update(id, enterprise.converter(enterpriseService.findById(id)));
            return ResponseEntity.ok().body(result);
        }else{
            return null;
        }
    }

    //"{id}" change to the number you want.
    //localhost:8080/enterprise/{id}

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        enterpriseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
