package com.compass.sprint4.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compass.sprint4.entities.AssociadoEntity;

@Repository
public interface AssociadoRepository extends JpaRepository<AssociadoEntity, Long>{

}
