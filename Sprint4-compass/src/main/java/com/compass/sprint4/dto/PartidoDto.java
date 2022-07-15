package com.compass.sprint4.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.compass.sprint4.enums.PartidoEnum;

public class PartidoDto {

	@NotBlank
	private String nomeDoPartido;
	@NotBlank
	private String sigla;
	@NotNull
	private PartidoEnum ideologia;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date dataDeFundacao;

	public PartidoDto(@NotBlank String nomeDoPartido, @NotBlank String sigla, @NotNull PartidoEnum ideologia,
			Date dataDeFundacao) {
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

	public Date getDataDeFundacao() {
		return dataDeFundacao;
	}

	public PartidoEnum getIdeologia() {
		return ideologia;
	}

//	public LocalDate formatar() {
//		LocalDate date = LocalDate.now();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		String text = date.format(formatter);
//		LocalDate parsedDate = LocalDate.parse(text, formatter);
//		return parsedDate;
//	}
}
