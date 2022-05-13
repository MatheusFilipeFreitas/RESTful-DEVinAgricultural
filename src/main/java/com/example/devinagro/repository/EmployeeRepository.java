package com.example.devinagro.repository;

import com.example.devinagro.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT * FROM employee WHERE employee.enterprise_id = :enterpriseId", nativeQuery = true)
    List<Employee> findEmployeeByEnterpriseId(@Param("enterpriseId") Long enterpriseId);


    @Query(value = "SELECT COUNT(employee.id) AS count FROM employee WHERE enterprise_id = :enterpriseId", nativeQuery = true)
    Integer countEmployeeByEnterpriseId(@Param("enterpriseId") Long enterpriseId);
}
