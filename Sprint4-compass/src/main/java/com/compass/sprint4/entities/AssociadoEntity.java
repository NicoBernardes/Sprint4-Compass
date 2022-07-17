package com.compass.sprint4.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.compass.sprint4.enums.CargoPoliticoEnum;
import com.compass.sprint4.enums.SexoEnum;


@Entity
public class AssociadoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nomeAssociado;
	@NotBlank
	private CargoPoliticoEnum cargoPolitico;
	@NotNull
	private LocalDate dataNascimento;
	private SexoEnum sexo;

	public AssociadoEntity() {

	}

	public AssociadoEntity(Long id, String nomeAssociado, CargoPoliticoEnum cargoPolitico, LocalDate dataNascimento,
			SexoEnum sexo) {
		this.id = id;
		this.nomeAssociado = nomeAssociado;
		this.cargoPolitico = cargoPolitico;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
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

	public CargoPoliticoEnum getCargoPolitico() {
		return cargoPolitico;
	}

	public void setCargoPolitico(CargoPoliticoEnum cargoPolitico) {
		this.cargoPolitico = cargoPolitico;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public SexoEnum getSexo() {
		return sexo;
	}

	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}

}
