package com.compass.sprint4.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.compass.sprint4.dto.request.AssociadoDtoRequest;
import com.compass.sprint4.dto.request.VinculoDtoRequest;
import com.compass.sprint4.dto.response.AssociadoDtoResponse;
import com.compass.sprint4.entity.AssociadoEntity;
import com.compass.sprint4.entity.PartidoEntity;
import com.compass.sprint4.exceptions.AssociadoInvalidException;
import com.compass.sprint4.exceptions.PartidoInvalidException;
import com.compass.sprint4.repository.AssociadoRepository;
import com.compass.sprint4.repository.PartidoRepository;
import com.compass.sprint4.validate.AssociadoValidate;

@Service
public class AssociadoService {
	
	@Autowired
	private AssociadoRepository associadoRepository;
	
	@Autowired
	private PartidoRepository partidoRepository;
	
	@Autowired
	private AssociadoValidate associadoValidate;
	
	@Autowired
	private ModelMapper modelMapper;

	public AssociadoService(AssociadoRepository associadoRepository2, ModelMapper modelMapper2,
			PartidoRepository partidoRepository2) {
	}

	public AssociadoDtoResponse save(AssociadoDtoRequest associadoDtoRequest) {
		associadoValidate.validateCargoPolitico(associadoDtoRequest);
		associadoValidate.validateSexo(associadoDtoRequest);
		AssociadoEntity entity = modelMapper.map(associadoDtoRequest, AssociadoEntity.class);
		AssociadoEntity savedEntity = associadoRepository.save(entity);
		return modelMapper.map(savedEntity, AssociadoDtoResponse.class);
	}

	public void addAssociadoToPartido(VinculoDtoRequest vinculoDtoRequest) {
		Long idAssociate = vinculoDtoRequest.getIdAssociado();
		associadoRepository.findById(idAssociate).orElseThrow(AssociadoInvalidException::new);
		Long idPartido = vinculoDtoRequest.getIdPartido();
		associadoRepository.findById(idPartido).orElseThrow(PartidoInvalidException::new);

		AssociadoEntity entity = associadoRepository.getReferenceById(idAssociate);

		if (entity.getPartido() == null) {
			PartidoEntity referenciaById = partidoRepository.getReferenceById(idPartido);
			entity.setPartido(referenciaById);
			associadoRepository.save(entity);
		} else {
			throw new AssociadoInvalidException();
		}
	}

	public List<AssociadoDtoResponse> getAll(String cargoPolitico, String sortBy) {
		List<AssociadoEntity> associates = associadoRepository.findWithFilters(cargoPolitico,
				Sort.by(Sort.Direction.ASC, sortBy));
		return associates.stream().map(AssociadoEntity -> modelMapper.map(AssociadoEntity, AssociadoDtoResponse.class))
				.collect(Collectors.toList());
	}

	public AssociadoDtoResponse getById(Long id) {
		AssociadoEntity AssociadoEntity = associadoRepository.findById(id).orElseThrow(AssociadoInvalidException::new);
		return modelMapper.map(AssociadoEntity, AssociadoDtoResponse.class);
	}

	public void update(AssociadoDtoRequest associadoDtoRequest, Long id) {
		associadoValidate.validateCargoPolitico(associadoDtoRequest);
		associadoValidate.validateSexo(associadoDtoRequest);
		AssociadoEntity AssociadoEntity = associadoRepository.findById(id).orElseThrow(AssociadoInvalidException::new);
		modelMapper.map(associadoDtoRequest, AssociadoEntity);
		associadoRepository.save(AssociadoEntity);
	}

	public void delete(Long id) {
		associadoRepository.findById(id).orElseThrow(AssociadoInvalidException::new);
		associadoRepository.deleteById(id);
	}

	public void deleteByPoliticalParty(Long idAssociado, Long idPartido) {
		partidoRepository.findById(idPartido).orElseThrow(PartidoInvalidException::new);
		associadoRepository.findById(idAssociado).orElseThrow(AssociadoInvalidException::new);

		AssociadoEntity referenciaByIdAssociado = associadoRepository.getReferenceById(idAssociado);
		PartidoEntity referenciaByIdPartido = partidoRepository.getReferenceById(idPartido);
		boolean equals = referenciaByIdAssociado.getPartido().equals(referenciaByIdPartido);

		if (equals) {
			referenciaByIdAssociado.setPartido(null);
			associadoRepository.save(referenciaByIdAssociado);
		} else {
			throw new AssociadoInvalidException();
		}

	}
}
