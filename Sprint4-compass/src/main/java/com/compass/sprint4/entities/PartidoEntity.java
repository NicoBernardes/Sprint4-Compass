package com.compass.sprint4.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.compass.sprint4.enums.PartidoEnum;
import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class PartidoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nomeDoPartido;
	@NotBlank
	private String sigla;
	@NotNull
	private PartidoEnum ideologia;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataDeFundacao;

	public PartidoEntity(String nomeDoPartido, String sigla, Date dataDeFundacao) {
		this.nomeDoPartido = nomeDoPartido;
		this.sigla = sigla;
		this.dataDeFundacao = dataDeFundacao;
	}

	public PartidoEntity() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDoPartido() {
		return nomeDoPartido;
	}

	public void setNomeDoPartido(String nomeDoPartido) {
		this.nomeDoPartido = nomeDoPartido;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Date getDataDeFundacao() {
		return dataDeFundacao;
	}

	public void setDataDeFundacao(Date dataDeFundacao) {
		this.dataDeFundacao = dataDeFundacao;
	}

	public PartidoEnum getIdeologia() {
		return ideologia;
	}

	public void setIdeologia(PartidoEnum ideologia) {
		this.ideologia = ideologia;
	}

}
