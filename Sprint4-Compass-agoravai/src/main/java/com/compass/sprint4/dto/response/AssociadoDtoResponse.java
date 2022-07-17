package com.compass.sprint4.dto.response;

import java.time.LocalDate;

import com.compass.sprint4.entity.PartidoEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class AssociadoDtoResponse {
	private Long id;

	private String nome;

	private String cargoPolitico;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate dataNascimento;

	private String sexo;

	private PartidoEntity partido;

	
	public AssociadoDtoResponse(Long id, String nome, String cargoPolitico, LocalDate dataNascimento, String sexo,
			PartidoEntity partido) {
		this.id = id;
		this.nome = nome;
		this.cargoPolitico = cargoPolitico;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.partido = partido;
	}

	public AssociadoDtoResponse() {
		
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		return partido;
	}

	public void setPartido(PartidoEntity partido) {
		this.partido = partido;
	}

	
	
}

