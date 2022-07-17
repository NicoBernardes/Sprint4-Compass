package com.compass.sprint4.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.compass.sprint4.entity.AssociadoEntity;

@Repository
public interface AssociadoRepository extends JpaRepository<AssociadoEntity, Long> {

    @Query("SELECT associado FROM AssociadoEntity associado WHERE (:cargoPolitico IS NULL OR :cargoPolitico = associado.cargoPolitico)")
    public List<AssociadoEntity> findWithFilters(@Param("cargoPolitico") String cargoPolitico, Sort sortBy);
}