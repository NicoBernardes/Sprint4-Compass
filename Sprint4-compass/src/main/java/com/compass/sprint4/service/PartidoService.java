package com.compass.sprint4.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.compass.sprint4.dto.PartidoDto;
import com.compass.sprint4.entities.PartidoEntity;
import com.compass.sprint4.exceptions.PartidoNotFoundException;
import com.compass.sprint4.repository.PartidoRepository;

@Service
public class PartidoService {

	@Autowired
	private PartidoRepository partidoRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private ValidationService validationService;

	public List<PartidoDto> get(String ideologia, String sortDescBy) {
		List<Object[]> todosPartidos = partidoRepository.findWithFilters(ideologia, Sort.by(Sort.Direction.DESC, sortDescBy));
		List<PartidoDto> dtos = todosPartidos.stream().map(partidoEntity -> modelMapper.map(partidoEntity, PartidoDto.class)).collect(Collectors.toList());
		return dtos;
	}

	public PartidoDto getById(Long id) {
		Optional<PartidoEntity> entidade = partidoRepository.findById(id);
		return modelMapper.map(entidade, PartidoDto.class);
	}

	public PartidoDto save(PartidoDto partidoDto) {
		validationService.validatePartido(partidoDto);
		PartidoEntity entidade = modelMapper.map(partidoDto, PartidoEntity.class);
		PartidoEntity salvarEntidade = partidoRepository.save(entidade);
		return modelMapper.map(salvarEntidade, PartidoDto.class);
	}

	public void delete(Long id) {
		partidoRepository.findById(id).orElseThrow(PartidoNotFoundException::new);
		partidoRepository.deleteById(id);
	}
	
	public void update(PartidoDto request, Long id) {
		validationService.validatePartido(request);
		PartidoEntity partidoEntity = partidoRepository.findById(id).orElseThrow(PartidoNotFoundException::new);
		modelMapper.map(request, partidoEntity);
		partidoRepository.save(partidoEntity);
	}

	public LocalDate formatar() {
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String text = date.format(formatter);
		LocalDate parsedDate = LocalDate.parse(text, formatter);
		return parsedDate;
	}


}
