package com.compass.sprint4.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.compass.sprint4.dto.AssociadoDto;
import com.compass.sprint4.dto.PartidoDto;
import com.compass.sprint4.enums.CargoPoliticoEnum;
import com.compass.sprint4.enums.PartidoEnum;
import com.compass.sprint4.enums.SexoEnum;
import com.compass.sprint4.exceptions.CargoNotFoundException;
import com.compass.sprint4.exceptions.IdeologiaInvalidException;
import com.compass.sprint4.exceptions.SexoInvalidException;

@Service
public class ValidationService {

	public void validatePartido(PartidoDto partidoDto) {
		boolean isValid = Arrays.stream(PartidoEnum.values())
				.anyMatch(partidoEnum -> partidoEnum.equals(partidoDto.getIdeologia()));
		if (!isValid) {
			throw new IdeologiaInvalidException();
		}
	}

	public void validateCargoPolitico(AssociadoDto associadoDto) {
		boolean isValid = Arrays.stream(CargoPoliticoEnum.values())
				.anyMatch(cargoPoliticoEnum -> cargoPoliticoEnum.getValue().equals(associadoDto.getCargoPolitico()));
		if (!isValid) {
			throw new CargoNotFoundException();
		}
	}

	public void validate(AssociadoDto associadoDto) {
		boolean isValid = Arrays.stream(SexoEnum.values())
				.anyMatch(SexoEnum -> SexoEnum.getValue().equals(associadoDto.getSexo()));
		if (!isValid) {
			throw new SexoInvalidException();
		}
	}
}