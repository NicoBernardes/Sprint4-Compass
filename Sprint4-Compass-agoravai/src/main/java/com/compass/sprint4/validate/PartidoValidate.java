package com.compass.sprint4.validate;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.compass.sprint4.dto.request.PartidoDtoRequest;
import com.compass.sprint4.enums.IdeologiaEnum;
import com.compass.sprint4.exceptions.IdeologiaInvalidException;
@Component
public class PartidoValidate {
    public void validateIdeologia(PartidoDtoRequest partidoDtoRequest){
        boolean isValid = Arrays.stream(IdeologiaEnum.values()).anyMatch(ideologiaEnum ->
                ideologiaEnum.getValue().equals(partidoDtoRequest.getIdeologia()));

        if (!isValid){
            throw new IdeologiaInvalidException();
        }
    }
}
