package com.compass.sprint4.validate;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.compass.sprint4.dto.request.AssociadoDtoRequest;
import com.compass.sprint4.enums.CargoPoliticoEnum;
import com.compass.sprint4.enums.SexoEnum;
import com.compass.sprint4.exceptions.CargoInvalidException;
import com.compass.sprint4.exceptions.SexoInvalidException;
@Component
public class AssociadoValidate {
	public void validateCargoPolitico(AssociadoDtoRequest associadoDtoRequest) {
		boolean isValid = Arrays.stream(CargoPoliticoEnum.values()).anyMatch(
				cargoPoliticoEnum -> cargoPoliticoEnum.getValue().equals(associadoDtoRequest.getCargoPolitico()));

		if (!isValid) {
			throw new CargoInvalidException();
		}
	}

	public void validateSexo(AssociadoDtoRequest associadoDtoRequest) {
		boolean isValid = Arrays.stream(SexoEnum.values())
				.anyMatch(sexoEnum -> sexoEnum.getValue().equalsIgnoreCase(associadoDtoRequest.getSexo()));

		if (!isValid) {
			throw new SexoInvalidException();
		}
	}

	public String validateCargoPolitico(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
