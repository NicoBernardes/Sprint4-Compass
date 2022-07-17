package com.compass.sprint4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.compass.sprint4.entity.PartidoEntity;

@Repository
public interface PartidoRepository extends JpaRepository<PartidoEntity, Long> {
    @Query("SELECT partido FROM PartidoEntity partido WHERE (:ideologia IS NULL OR :ideologia = partido.ideologia)")
    List<PartidoEntity> findWithFilters(String ideologia);
}
