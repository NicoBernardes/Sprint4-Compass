package com.compass.sprint4.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.compass.sprint4.dto.request.PartidoDtoRequest;
import com.compass.sprint4.dto.response.AssociadoDtoResponse;
import com.compass.sprint4.dto.response.PartidoDtoResponse;
import com.compass.sprint4.entity.AssociadoEntity;
import com.compass.sprint4.entity.PartidoEntity;
import com.compass.sprint4.exceptions.PartidoInvalidException;
import com.compass.sprint4.repository.AssociadoRepository;
import com.compass.sprint4.repository.PartidoRepository;
import com.compass.sprint4.validate.PartidoValidate;

@Service
public class PartidoService {
	
	@Autowired
	private PartidoRepository partidoRepository;
	@Autowired
	private PartidoValidate PartidoValidate;
	@Autowired
	private ModelMapper modelMapper;

    public PartidoService(PartidoRepository partidoRepository2, ModelMapper modelMapper2,
			AssociadoRepository associadoRepository) {
		// TODO Auto-generated constructor stub
	}

	public PartidoDtoResponse save(PartidoDtoRequest partidoDtoRequest, UriComponentsBuilder uriComponentsBuilder){
    	PartidoValidate.validateIdeologia(partidoDtoRequest) ;
        PartidoEntity entity = modelMapper.map(partidoDtoRequest, PartidoEntity.class);
        PartidoEntity savedEntity = partidoRepository.save(entity);
        return modelMapper.map(savedEntity, PartidoDtoResponse.class);
    }

    public List<PartidoDtoResponse> getAll(String ideologia){
        List<PartidoEntity> partidos = partidoRepository.findWithFilters(ideologia);
        return partidos.stream().map(PartidoEntity -> modelMapper.map(
                PartidoEntity, PartidoDtoResponse.class)).collect(Collectors.toList());
    }

    public PartidoDtoResponse getById(Long id){
        PartidoEntity PartidoEntity = partidoRepository.findById(id).orElseThrow(PartidoInvalidException::new);
        return modelMapper.map(PartidoEntity, PartidoDtoResponse.class);
    }

    public List<AssociadoDtoResponse> getAllAssociados(Long partidoId){
        PartidoEntity PartidoEntity = partidoRepository.findById(partidoId).orElseThrow(PartidoInvalidException::new);
        List<AssociadoEntity> associados = PartidoEntity.getListaAssociados();
        return associados.stream().map(associadoEntity -> modelMapper.map(
        		associadoEntity, AssociadoDtoResponse.class)).collect(Collectors.toList());
    }

    public void delete(Long id){
        PartidoEntity PartidoEntity = partidoRepository.findById(id).orElseThrow(PartidoInvalidException::new);
        PartidoEntity.getListaAssociados().forEach(associadoEntity -> {
        	associadoEntity.setPartido(null);
        });
        partidoRepository.deleteById(id);
    }

    public void update (PartidoDtoRequest partidoDtoRequest, Long id){
    	PartidoValidate.validateIdeologia(partidoDtoRequest);
        PartidoEntity PartidoEntity = partidoRepository.findById(id).orElseThrow(PartidoInvalidException::new);
        modelMapper.map(partidoDtoRequest, PartidoEntity);
        partidoRepository.save(PartidoEntity);
    }
}
