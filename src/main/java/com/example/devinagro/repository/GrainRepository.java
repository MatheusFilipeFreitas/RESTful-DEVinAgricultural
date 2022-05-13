package com.example.devinagro.repository;

import com.example.devinagro.models.Grain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrainRepository extends JpaRepository<Grain, Long> {
    @Query(value = "SELECT * FROM grain WHERE grain.enterprise_id = :enterpriseId", nativeQuery = true)
    List<Grain> findGrainsByEnterpriseId(@Param("enterpriseId") Long enterpriseId);

    @Query(value = "SELECT COUNT(grain.id) AS count FROM grain WHERE enterprise_id = :enterpriseId", nativeQuery = true)
    Integer countFarmsByEnterprise(@Param("enterpriseId") Long enterpriseId);

    @Query(value = "SELECT name FROM grain WHERE grain.id = :grainId", nativeQuery = true)
    String grainNameById(Long grainId);
}
