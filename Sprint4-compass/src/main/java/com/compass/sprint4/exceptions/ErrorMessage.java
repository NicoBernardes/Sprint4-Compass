package com.compass.sprint4.exceptions;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessage {

	private String mensagem;
	private List<String> validacaoErro;

	public ErrorMessage(String mensagem) {
		this.mensagem = mensagem;
	}

	public ErrorMessage(List<String> validacaoErro) {
		this.validacaoErro = validacaoErro;
	}

	public ErrorMessage(String mensagem, List<String> validacaoErro) {
		this.mensagem = mensagem;
		this.validacaoErro = validacaoErro;
	}
	
	public ErrorMessage() {
		
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public List<String> getValidacaoErro() {
		return validacaoErro;
	}

	public void setValidacaoErro(List<String> validacaoErro) {
		this.validacaoErro = validacaoErro;
	}

}
