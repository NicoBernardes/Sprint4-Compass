package com.compass.sprint4.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AssociadoDto {

	@NotBlank
	private String nomeAssociado;
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dataNasc;

	public AssociadoDto(String nomeAssociado, Date dataNasc) {
		this.nomeAssociado = nomeAssociado;
		this.dataNasc = dataNasc;
	}

	public AssociadoDto() {

	}

	public String getNomeAssociado() {
		return nomeAssociado;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

}
