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

import com.compass.sprint4.dto.PartidoDto;
import com.compass.sprint4.service.PartidoService;

@RestController
@RequestMapping(value = "/partidos")
public class PartidoController {

	@Autowired
	private PartidoService partidoService;

	@GetMapping
	public ResponseEntity<List<PartidoDto>> get(@RequestParam(required = false) String ideologia,
												@RequestParam(required = false, defaultValue = "id") String sortDescBy) {
		List<PartidoDto> response = partidoService.get(ideologia, sortDescBy);
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<PartidoDto> getById(@PathVariable Long id) {
		PartidoDto response = partidoService.getById(id);
		return ResponseEntity.ok(response);
	}

	@PostMapping
	public ResponseEntity<PartidoDto> post(@RequestBody @Valid PartidoDto request) {
		PartidoDto response = partidoService.save(request);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		partidoService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> post(@RequestBody @Valid PartidoDto request, @PathVariable Long id) {
		partidoService.update(request, id);
		return ResponseEntity.noContent().build();
	}
}
