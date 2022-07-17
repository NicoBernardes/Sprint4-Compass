package com.compass.sprint4.handler;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessage {

	private String campo;
	private String mensagem;
	private List<String> validacaoErro;

	public ErrorMessage(String campo, String mensagem) {
		this.campo = campo;
		this.mensagem = mensagem;
	}

    public ErrorMessage(List<String> validacaoErro) {
        this.validacaoErro = validacaoErro;
    }

    public ErrorMessage(String mensagem) {
        this.mensagem = mensagem;
    }
}
