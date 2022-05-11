package com.example.devinagro.repository;

import com.example.devinagro.models.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmRepository extends JpaRepository<Farm, Long> {
    /*TODO: 1- Find Farm by Enterprise Id
            2- Count Farm by Enterprise Id
     */
}
