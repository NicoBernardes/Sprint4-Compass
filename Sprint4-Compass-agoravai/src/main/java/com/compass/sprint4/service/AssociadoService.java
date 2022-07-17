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

	public AssociadoDtoResponse save(AssociadoDtoRequest associateDTO) {
		associadoValidate.validateCargoPolitico(associateDTO);
		associadoValidate.validateSexo(associateDTO);
		AssociadoEntity entity = modelMapper.map(associateDTO, AssociadoEntity.class);
		AssociadoEntity savedEntity = associadoRepository.save(entity);
		return modelMapper.map(savedEntity, AssociadoDtoResponse.class);
	}

	public void addAssociateToPoliticalParty(VinculoDtoRequest request) {
		Long idAssociate = request.getIdAssociado();
		associadoRepository.findById(idAssociate).orElseThrow(AssociadoInvalidException::new);
		Long idPoliticalParty = request.getIdPartido();
		associadoRepository.findById(idPoliticalParty).orElseThrow(PartidoInvalidException::new);

		AssociadoEntity entity = associadoRepository.getReferenceById(idAssociate);

		if (entity.getPartido() == null) {
			PartidoEntity referenceById = partidoRepository.getReferenceById(idPoliticalParty);
			entity.setPartido(referenceById);
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

	public void update(AssociadoDtoRequest associateDTO, Long id) {
		associadoValidate.validateCargoPolitico(associateDTO);
		associadoValidate.validateSexo(associateDTO);
		AssociadoEntity AssociadoEntity = associadoRepository.findById(id).orElseThrow(AssociadoInvalidException::new);
		modelMapper.map(associateDTO, AssociadoEntity);
		associadoRepository.save(AssociadoEntity);
	}

	public void delete(Long id) {
		associadoRepository.findById(id).orElseThrow(AssociadoInvalidException::new);
		associadoRepository.deleteById(id);
	}

	public void deleteByPoliticalParty(Long idAssociate, Long idPoliticalParty) {
		partidoRepository.findById(idPoliticalParty).orElseThrow(PartidoInvalidException::new);
		associadoRepository.findById(idAssociate).orElseThrow(AssociadoInvalidException::new);

		AssociadoEntity referenceByIdAssociate = associadoRepository.getReferenceById(idAssociate);
		PartidoEntity referenceByIdPoliticalParty = partidoRepository.getReferenceById(idPoliticalParty);
		boolean equals = referenceByIdAssociate.getPartido().equals(referenceByIdPoliticalParty);

		if (equals) {
			referenceByIdAssociate.setPartido(null);
			associadoRepository.save(referenceByIdAssociate);
		} else {
			throw new AssociadoInvalidException();
		}

	}
}
