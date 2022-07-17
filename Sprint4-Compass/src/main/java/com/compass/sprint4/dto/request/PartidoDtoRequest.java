package com.compass.sprint4.dto.request;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PartidoDtoRequest {
    @NotBlank
    private String nome;
    @NotBlank
    private String sigla;
    @NotBlank
    private String ideologia;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dataFundacao;

    
	public PartidoDtoRequest(@NotBlank String nome, @NotBlank String sigla, @NotBlank String ideologia,
			@NotNull LocalDate dataFundacao) {
		this.nome = nome;
		this.sigla = sigla;
		this.ideologia = ideologia;
		this.dataFundacao = dataFundacao;
	}

	public PartidoDtoRequest() {
		
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
    
    
}
