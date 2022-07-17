package com.compass.sprint4.dto.request;

import lombok.Data;

@Data
public class VinculoDtoRequest {
    private Long idAssociado;
    private Long idPartido;
    
	public VinculoDtoRequest(Long idAssociado, Long idPartido) {
		this.idAssociado = idAssociado;
		this.idPartido = idPartido;
	}
    
	public VinculoDtoRequest() {
		
	}

	public Long getIdAssociado() {
		return idAssociado;
	}

	public void setIdAssociado(Long idAssociado) {
		this.idAssociado = idAssociado;
	}

	public Long getIdPartido() {
		return idPartido;
	}

	public void setIdPartido(Long idPartido) {
		this.idPartido = idPartido;
	}
	
	
}
