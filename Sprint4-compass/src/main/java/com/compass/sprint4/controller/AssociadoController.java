package com.compass.sprint4.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.compass.sprint4.dto.AssociadoDto;
import com.compass.sprint4.service.AssociadoService;

@RestController
@RequestMapping(value = "/associados")
public class AssociadoController {

	@Autowired
	private AssociadoService associadoService;
	
	@GetMapping
	public ResponseEntity<List<AssociadoDto>> get(@RequestParam(required = false) String nomeAssociado,
												@RequestParam(required = false, defaultValue = "id") String sortDescBy) {
		List<AssociadoDto> response = associadoService.get(nomeAssociado, sortDescBy);
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<AssociadoDto> getById(@PathVariable Long id) {
		AssociadoDto response = associadoService.getById(id);
		return ResponseEntity.ok(response);
	}

	@PostMapping
	public ResponseEntity<AssociadoDto> post(@RequestBody @Valid AssociadoDto request) {
		AssociadoDto response = associadoService.save(request);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		associadoService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> post(@RequestBody @Valid AssociadoDto request, @PathVariable Long id) {
		associadoService.update(request, id);
		return ResponseEntity.noContent().build();
	}
	
}
