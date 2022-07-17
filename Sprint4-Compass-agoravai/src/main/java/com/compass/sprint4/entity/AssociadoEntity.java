package com.compass.sprint4.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class AssociadoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nomeAssociado;
	private String cargoPolitico;
	private LocalDate dataNascimento;
	private String sexo;
	@ManyToOne(optional = true, cascade = CascadeType.MERGE)
	private PartidoEntity partidoEntity;

	public AssociadoEntity(long id, String nomeAssociado, String cargoPolitico, LocalDate dataNascimento, String sexo,
			PartidoEntity partidoEntity) {
		this.id = id;
		this.nomeAssociado = nomeAssociado;
		this.cargoPolitico = cargoPolitico;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.partidoEntity = partidoEntity;
	}

	AssociadoEntity() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeAssociado() {
		return nomeAssociado;
	}

	public void setNomeAssociado(String nomeAssociado) {
		this.nomeAssociado = nomeAssociado;
	}

	public String getCargoPolitico() {
		return cargoPolitico;
	}

	public void setCargoPolitico(String cargoPolitico) {
		this.cargoPolitico = cargoPolitico;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public PartidoEntity getPartido() {
		return partidoEntity;
	}

	public void setPartido(PartidoEntity partidoEntity) {
		this.partidoEntity = partidoEntity;
	}

	public Object builder() {
		// TODO Auto-generated method stub
		return null;
	}

}