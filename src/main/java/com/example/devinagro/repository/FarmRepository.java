package com.example.devinagro.repository;

import com.example.devinagro.models.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FarmRepository extends JpaRepository<Farm, Long> {
    @Query(value = "SELECT * FROM farm WHERE farm.enterprise_id = :enterpriseId", nativeQuery = true)
    List<Farm> findFarmByEnterpriseId(@Param("enterpriseId") Long enterpriseId);

    @Query(value = "SELECT COUNT(farm.id) AS count FROM farm WHERE enterprise_id = :enterpriseId", nativeQuery = true)
    Integer countFarmByEnterpriseId(@Param("enterpriseId") Long enterpriseId);
}
