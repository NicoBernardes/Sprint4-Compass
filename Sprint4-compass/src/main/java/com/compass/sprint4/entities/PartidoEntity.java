package com.compass.sprint4.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import com.compass.sprint4.enums.PartidoEnum;

@Table(name = "partido_entity")
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
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataDeFundacao;

	public PartidoEntity(Long id, String nomeDoPartido, String sigla, PartidoEnum ideologia, LocalDate dataDeFundacao) {
		this.id = id;
		this.nomeDoPartido = nomeDoPartido;
		this.sigla = sigla;
		this.ideologia = ideologia;
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

	public LocalDate getDataDeFundacao() {
		return dataDeFundacao;
	}

	public void setDataDeFundacao(LocalDate dataDeFundacao) {
		this.dataDeFundacao = dataDeFundacao;
	}

	public PartidoEnum getIdeologia() {
		return ideologia;
	}

	public void setIdeologia(PartidoEnum ideologia) {
		this.ideologia = ideologia;
	}

}
