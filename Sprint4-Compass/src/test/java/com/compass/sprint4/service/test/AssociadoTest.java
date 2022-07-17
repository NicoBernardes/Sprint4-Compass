package com.compass.sprint4.service.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import com.compass.sprint4.repository.AssociadoRepository;
import com.compass.sprint4.repository.PartidoRepository;
import com.compass.sprint4.service.AssociadoService;
import com.compass.sprint4.validate.AssociadoValidate;

class AssociadoServiceTest {

	private ModelMapper modelMapper;
	private PartidoRepository partidoRepository;
	private AssociadoRepository associadoRepository;
	private AssociadoValidate associadoValidate;

	@BeforeEach
	public void setUp() {
		new AssociadoService(associadoRepository, modelMapper, partidoRepository);
	}

	@DisplayName("deveria retornar um cargo valido")
	@Test
	void validacaoDeCargoPolitico() {
		String presidente = associadoValidate.validateCargoPolitico("Presidente");
		Assertions.assertEquals("Presidente", presidente);
	}

}
