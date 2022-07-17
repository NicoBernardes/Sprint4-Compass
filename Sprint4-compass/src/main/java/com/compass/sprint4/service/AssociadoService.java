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

import com.compass.sprint4.dto.AssociadoDto;
import com.compass.sprint4.entities.AssociadoEntity;
import com.compass.sprint4.repository.AssociadoRepository;

@Service
public class AssociadoService {

	@Autowired
	private AssociadoRepository associadoRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private ValidationService validationService;

	public List<AssociadoDto> get(String nomeAssociado, String sortDescBy) {
		List<AssociadoEntity> todosAssociados = associadoRepository.findWithFilters(nomeAssociado, Sort.by(Sort.Direction.DESC, sortDescBy));
		List<AssociadoDto> dtos = todosAssociados.stream().map(associadoEntity -> modelMapper.map(associadoEntity, AssociadoDto.class)).collect(Collectors.toList());
		return dtos;
	}

	public AssociadoDto getById(Long id) {
		Optional<AssociadoEntity> entidade = associadoRepository.findById(id);
		return modelMapper.map(entidade, AssociadoDto.class);
	}

	public AssociadoDto save(AssociadoDto AssociadoDto) {
		validationService.validate(AssociadoDto);
		AssociadoEntity entidade = modelMapper.map(AssociadoDto, AssociadoEntity.class);
		AssociadoEntity salvarEntidade = associadoRepository.save(entidade);
		return modelMapper.map(salvarEntidade, AssociadoDto.class);
	}

	public void delete(Long id) {
		associadoRepository.findById(id).orElseThrow(AssociadoNotFoundException::new);
		associadoRepository.deleteById(id);
	}

//	public void update(AssociadoDto request, Long id) {
//		Optional<AssociadoEntity> AssociadoEntity = partidoRepository.findById(id).orElseThrow(PartidoNotFoundException::new);
//		AssociadoEntity entidade = AssociadoEntity.get();
//		modelMapper.map(request, entidade);
//		partidoRepository.save(entidade);
//	}
	
	public void update(AssociadoDto request, Long id) {
		validationService.validate(request);
		AssociadoEntity AssociadoEntity = associadoRepository.findById(id).orElseThrow(AssociadoInvalidException::new);
		modelMapper.map(request, AssociadoEntity);
		associadoRepository.save(AssociadoEntity);
	}

	public LocalDate formatar() {
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String text = date.format(formatter);
		LocalDate parsedDate = LocalDate.parse(text, formatter);
		return parsedDate;
	}
}
