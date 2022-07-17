package com.compass.sprint4.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.compass.sprint4.entities.PartidoEntity;

@Repository
public interface PartidoRepository extends JpaRepository<PartidoEntity, Long>{

	@Query("SELECT ideologia FROM PartidoEntity WHERE (:ideologia IS NULL OR :ideologia = ideologia)")
	List<Object[]> findWithFilters(@Param("ideologia")String ideologia, Sort sort);
}
	