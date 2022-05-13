package com.example.devinagro.service;

import com.example.devinagro.dto.EmployeeDto;
import com.example.devinagro.mapper.EmployeeMapper;
import com.example.devinagro.models.Employee;
import com.example.devinagro.models.Enterprise;
import com.example.devinagro.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository repository;
    private EnterpriseService enterpriseService;

    public EmployeeService(EmployeeRepository repository, EnterpriseService service){
        this.repository = repository;
        this.enterpriseService = service;
    }

    public List<Employee> findAll(){
        return repository.findAll();
    }

    public Employee insert(Employee employee){
        return repository.save(employee);
    }

    public Employee update(Long id, Employee employee){
        Employee overrideEmployee = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Model not found!"));
        overrideEmployee.setName(employee.getName());
        overrideEmployee.setLastName(employee.getLastName());
        overrideEmployee.setCpf(employee.getCpf());
        overrideEmployee.setAddress(employee.getAddress());
        overrideEmployee.setBirthDate(employee.getBirthDate());
        overrideEmployee.setPhoneNumber(employee.getPhoneNumber());
        overrideEmployee.setGender(employee.getGender());
        overrideEmployee.setHiringDate(employee.getHiringDate());

        overrideEmployee.setEnterprise(employee.getEnterprise());
        return repository.save(overrideEmployee);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public void addEnterpriseToAnEmployee(Long id, Employee employee){
        Enterprise enterprise = enterpriseService.findById(id);
        employee.setEnterprise(enterprise);
    }

    public Integer countEmployeesByEnterprise(Long id){
        return repository.countEmployeeByEnterpriseId(id);
    }

    public List<Employee> findEmployeeByEnterprise(Long id){
        return repository.findEmployeeByEnterpriseId(id);
    }
}

