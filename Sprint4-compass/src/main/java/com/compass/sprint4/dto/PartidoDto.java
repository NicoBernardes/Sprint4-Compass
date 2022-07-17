package com.compass.sprint4.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.compass.sprint4.enums.PartidoEnum;

public class PartidoDto {

	@NotBlank
	private String nomeDoPartido;
	@NotBlank
	private String sigla;
	@NotNull
	private PartidoEnum ideologia;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataDeFundacao;

	public PartidoDto(String nomeDoPartido, String sigla, PartidoEnum ideologia,
			LocalDate dataDeFundacao) {
		this.nomeDoPartido = nomeDoPartido;
		this.sigla = sigla;
		this.ideologia = ideologia;
		this.dataDeFundacao = dataDeFundacao;
	}

	public PartidoDto() {

	}

	public String getNomeDoPartido() {
		return nomeDoPartido;
	}

	public String getSigla() {
		return sigla;
	}

	public LocalDate getDataDeFundacao() {
		return dataDeFundacao;
	}

	public PartidoEnum getIdeologia() {
		return ideologia;
	}

	public void setNomeDoPartido(String nomeDoPartido) {
		this.nomeDoPartido = nomeDoPartido;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public void setIdeologia(PartidoEnum ideologia) {
		this.ideologia = ideologia;
	}

	public void setDataDeFundacao(LocalDate dataDeFundacao) {
		this.dataDeFundacao = dataDeFundacao;
	}

}
