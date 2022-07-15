package com.compass.sprint4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compass.sprint4.entities.PartidoEntity;

@Repository
public interface PartidoRepository extends JpaRepository<PartidoEntity, Long>{

}
	