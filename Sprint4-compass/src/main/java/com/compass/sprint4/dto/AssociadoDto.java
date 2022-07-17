package com.compass.sprint4.dto;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.compass.sprint4.enums.CargoPoliticoEnum;
import com.compass.sprint4.enums.SexoEnum;

public class AssociadoDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nomeAssociado;
	@NotBlank
	private CargoPoliticoEnum cargoPolitico;
	@NotNull
	private Date dataNascimento;
	private SexoEnum sexo;

	public AssociadoDto() {

	}

	public AssociadoDto(Long id, @NotBlank String nomeAssociado, @NotBlank CargoPoliticoEnum cargoPolitico,
			@NotNull Date dataNascimento, SexoEnum sexo) {
		super();
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public SexoEnum getSexo() {
		return sexo;
	}

	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}

}
