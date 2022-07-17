package com.compass.sprint4.controller;

import java.net.URI;
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
import org.springframework.web.util.UriComponentsBuilder;

import com.compass.sprint4.dto.request.PartidoDtoRequest;
import com.compass.sprint4.dto.response.AssociadoDtoResponse;
import com.compass.sprint4.dto.response.PartidoDtoResponse;
import com.compass.sprint4.service.PartidoService;

@RestController
@RequestMapping("/partidos")
public class PartidoController {
	@Autowired
	private PartidoService partidoService;

	@GetMapping
	public ResponseEntity<List<PartidoDtoResponse>> getAllPartidos(@RequestParam(required = false) String ideologia) {
		List<PartidoDtoResponse> response = partidoService.getAll(ideologia);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PartidoDtoResponse> getById(@PathVariable Long id) {
		PartidoDtoResponse response = partidoService.getById(id);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{partidoId}/associados")
	public ResponseEntity<List<AssociadoDtoResponse>> listAllAssociados(@PathVariable Long partidoId) {
		List<AssociadoDtoResponse> response = partidoService.getAllAssociados(partidoId);
		return ResponseEntity.ok(response);
	}

	@PostMapping
	public ResponseEntity<PartidoDtoResponse> save(@RequestBody @Valid PartidoDtoRequest partidoDtoRequest,
			UriComponentsBuilder uriComponentsBuilder) {
		PartidoDtoResponse save = partidoService.save(partidoDtoRequest, uriComponentsBuilder);
		URI uri = uriComponentsBuilder.path("partidos/{id}").buildAndExpand(save.getId()).toUri();
		return ResponseEntity.created(uri).body(save);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody @Valid PartidoDtoRequest partidoDtoRequest,
			@PathVariable Long id) {
		partidoService.update(partidoDtoRequest, id);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirPartido(@PathVariable Long id) {
		partidoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
