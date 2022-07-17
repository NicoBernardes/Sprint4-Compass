package com.compass.sprint4.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.compass.sprint4.entities.AssociadoEntity;

@Repository
public interface AssociadoRepository extends JpaRepository<AssociadoEntity, Long>{

	@Query("SELECT nomeAssociado FROM AssociadoEntity WHERE (:nomeAssociado IS NULL OR :nomeAssociado = nomeAssociado)")
	List<AssociadoEntity> findWithFilters(@Param("nomeAssociado")String nomeAssociado, Sort sort);
}
