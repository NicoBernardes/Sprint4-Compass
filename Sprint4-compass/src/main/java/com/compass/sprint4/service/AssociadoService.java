package com.compass.sprint4.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compass.sprint4.dto.AssociadoDto;
import com.compass.sprint4.entities.AssociadoEntity;
import com.compass.sprint4.repository.AssociadoRepository;

@Service
public class AssociadoService {

	@Autowired
	private AssociadoRepository associadoRepository;
	@Autowired
	private ModelMapper modelMapper;

	public List<AssociadoDto> get() {
		List<AssociadoEntity> todosAssociados = associadoRepository.findAll();
		List<AssociadoDto> dtos = todosAssociados.stream().map(associadoEntity -> modelMapper.map(associadoEntity, AssociadoDto.class)).collect(Collectors.toList());
		return dtos;
	}
	
	public AssociadoDto save(AssociadoDto associadoDto) {
		AssociadoEntity entidade = modelMapper.map(associadoDto, AssociadoEntity.class);
		AssociadoEntity salvarEntidade = associadoRepository.save(entidade);
		return modelMapper.map(salvarEntidade, AssociadoDto.class);
	}

}
