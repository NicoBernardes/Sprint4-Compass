package com.compass.sprint4.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compass.sprint4.dto.PartidoDto;
import com.compass.sprint4.entities.PartidoEntity;
import com.compass.sprint4.repository.PartidoRepository;

@Service
public class PartidoService {

	@Autowired
	private PartidoRepository partidoRepository;
	@Autowired
	private ModelMapper modelMapper;

	public List<PartidoDto> get() {
		List<PartidoEntity> todosPartidos = partidoRepository.findAll();
		List<PartidoDto> dtos = todosPartidos.stream().map(partidoEntity -> modelMapper.map(partidoEntity, PartidoDto.class)).collect(Collectors.toList());
		return dtos;
	}
	
	public PartidoDto getById(Long id) {
		Optional<PartidoEntity> entidade = partidoRepository.findById(id);
		return modelMapper.map(entidade, PartidoDto.class);
	}
	
	public PartidoDto save(PartidoDto partidoDto) {
		PartidoEntity entidade = modelMapper.map(partidoDto, PartidoEntity.class);
		PartidoEntity salvarEntidade = partidoRepository.save(entidade);
		return modelMapper.map(salvarEntidade, PartidoDto.class);
	}

	public void delete(Long id) {
		partidoRepository.findById(id);
		partidoRepository.deleteById(id);
	}
	
	public void update(PartidoDto request, Long id) {
		Optional<PartidoEntity> partidoEntity = partidoRepository.findById(id);
		PartidoEntity entidade = partidoEntity.get();
		modelMapper.map(request, entidade);
		partidoRepository.save(entidade);
	}
	
}