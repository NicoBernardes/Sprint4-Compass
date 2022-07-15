package com.compass.sprint4.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class AssociadoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nomeAssociado;
	@NotNull
	private Date dataNascimento;

	public AssociadoEntity(String nomeAssociado, Date dataNascimento) {
		this.nomeAssociado = nomeAssociado;
		this.dataNascimento = dataNascimento;
	}
	
	public AssociadoEntity() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeAssociado() {
		return nomeAssociado;
	}

	public void setNomeAssociado(String nomeAssociado) {
		this.nomeAssociado = nomeAssociado;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNasc(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
