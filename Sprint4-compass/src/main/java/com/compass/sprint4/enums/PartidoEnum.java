package com.compass.sprint4.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum PartidoEnum {
	
	@JsonProperty("Direita")
	DIREITA("Direita"), 
	@JsonProperty("Centro")
	CENTRO("Centro"),  
	@JsonProperty("Esquerda")
	ESQUERDA("Esquerda");

	private String value;
	
	PartidoEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return value;
	}

}
