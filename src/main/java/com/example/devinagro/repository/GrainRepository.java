package com.example.devinagro.repository;

import com.example.devinagro.models.Grain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrainRepository extends JpaRepository<Grain, Long> {
    /*TODO: 1- Find Grain by Enterprise Id
            2- Count Employee by Enterprise Id
            3- Grain name by Id
     */
}
