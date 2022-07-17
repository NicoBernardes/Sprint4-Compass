package com.compass.sprint4.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class PartidoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String sigla;
	private String ideologia;
	private LocalDate dataFundacao;
	@OneToMany(mappedBy = "partidoEntity")
	private List<AssociadoEntity> listaAssociados = new ArrayList<>();
	

	
	public PartidoEntity(long id, String nome, String sigla, String ideologia, LocalDate dataFundacao,
			List<AssociadoEntity> listaAssociados) {
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
		this.ideologia = ideologia;
		this.dataFundacao = dataFundacao;
		this.listaAssociados = listaAssociados;
	}
	
	
	public PartidoEntity() {
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public List<AssociadoEntity> getListaAssociados() {
		return listaAssociados;
	}
	public void setListaAssociados(List<AssociadoEntity> listaAssociados) {
		this.listaAssociados = listaAssociados;
	}


	public static Object builder() {
		return null;
	}
	
	
}