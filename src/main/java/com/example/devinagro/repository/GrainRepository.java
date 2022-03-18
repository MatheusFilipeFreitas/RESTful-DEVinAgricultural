package com.example.devinagro.repository;

import com.example.devinagro.model.Grain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrainRepository extends JpaRepository<Grain, Long> {

    public List<Grain> findAllByEnterpriseId(Long id);

}
