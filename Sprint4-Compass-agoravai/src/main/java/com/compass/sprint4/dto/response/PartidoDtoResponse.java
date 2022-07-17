package com.compass.sprint4.dto.response;

import java.time.LocalDate;
import java.util.List;

import com.compass.sprint4.entity.AssociadoEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PartidoDtoResponse {
	private Long id;
	private String nome;
	private String sigla;
	private String ideologia;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate dataFundacao;
	private List<AssociadoEntity> associados;

	public PartidoDtoResponse(Long id, String nome, String sigla, String ideologia, LocalDate dataFundacao,
			List<AssociadoEntity> associados) {
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
		this.ideologia = ideologia;
		this.dataFundacao = dataFundacao;
		this.associados = associados;
	}

	public PartidoDtoResponse() {
		
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getIdeologia() {
		return ideologia;
	}

	public void setIdeologia(String ideologia) {
		this.ideologia = ideologia;
	}

	public LocalDate getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public List<AssociadoEntity> getAssociados() {
		return associados;
	}

	public void setAssociados(List<AssociadoEntity> associados) {
		this.associados = associados;
	}

}
