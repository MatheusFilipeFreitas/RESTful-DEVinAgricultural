package com.example.devinagro.repository;

import com.example.devinagro.model.Enterprise;
import com.example.devinagro.model.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FarmRepository extends JpaRepository<Farm, Long> {

    public List<Farm> findAllByEnterpriseId(Long id);

    public int countAllByEnterpriseId(Long id);

    public List<Farm> findTopByOrderByIdDesc();
}
