package com.example.devinagro.service;

import com.example.devinagro.model.Grain;
import com.example.devinagro.repository.GrainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class GrainService {

    private GrainRepository grainRepository;

    public List<Grain> findAll(){
        return grainRepository.findAll();
    }

    public Grain findById(Long id){
        return grainRepository.getById(id);
    }

    public Grain add(Grain grain){
        return grainRepository.save(grain);
    }

    public Grain update(Long id, Grain grain){
          /*
        SEE Uptade using DTO class

        Employee searchEmployee = employeeRepository.getById(id);
        searchEmployee.setName(employee.getName());
        searchEmployee.setLastName(employee.getLastName());
        searchEmployee.setCpf(employee.getCpf());
        searchEmployee.setAddress(employee.getAddress());
        searchEmployee.setPhoneNumber(employee.getPhoneNumber());
        searchEmployee.setBirthDate(employee.getBirthDate());
        searchEmployee.setHiringDate(employee.getHiringDate());
        searchEmployee.setEnterprise(employee.getEnterprise());
        */
        return grainRepository.save(grain);
    }

    public void delete(Long id){
        grainRepository.deleteById(id);
    }

}
