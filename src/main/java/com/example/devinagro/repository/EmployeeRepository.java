package com.example.devinagro.repository;

import com.example.devinagro.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    /*TODO: 1- Find Employee by Enterprise Id
            2- Count Employee by Enterprise Id
     */
}
