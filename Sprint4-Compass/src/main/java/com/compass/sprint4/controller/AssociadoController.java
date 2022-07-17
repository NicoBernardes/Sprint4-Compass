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

import com.compass.sprint4.dto.request.AssociadoDtoRequest;
import com.compass.sprint4.dto.request.VinculoDtoRequest;
import com.compass.sprint4.dto.response.AssociadoDtoResponse;
import com.compass.sprint4.service.AssociadoService;

@RestController
@RequestMapping("/associados")
public class AssociadoController {


	    @Autowired
	    private AssociadoService associadoService;

	    @PostMapping
	    public ResponseEntity<AssociadoDtoResponse> addAssociado(@RequestBody @Valid AssociadoDtoRequest associadoDtoRequest, UriComponentsBuilder uriComponentsBuilder){
	        AssociadoDtoResponse save = associadoService.save(associadoDtoRequest);
	        URI uri = uriComponentsBuilder.path("associados/{id}").buildAndExpand(save.getId()).toUri();
	        return ResponseEntity.created(uri).body(save);
	    }

	    @PostMapping("/partidos")
	    public ResponseEntity<Void> addAssociateToPoliticalParty (@RequestBody @Valid VinculoDtoRequest request){
	        associadoService.addAssociateToPoliticalParty(request);
	        return ResponseEntity.status(201).build();
	    }

	    @GetMapping
	    public ResponseEntity<List<AssociadoDtoResponse>> listAllAssociates(@RequestParam(required = false) String cargoPolitico,
	            @RequestParam(required = false, defaultValue = "id") String sortBy){
	        List<AssociadoDtoResponse> response = associadoService.getAll(cargoPolitico, sortBy);
	        return ResponseEntity.ok(response);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<AssociadoDtoResponse> getAssociate(@PathVariable Long id){
	        AssociadoDtoResponse response = associadoService.getById(id);
	        return ResponseEntity.ok(response);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Void> updateAssociate(@RequestBody @Valid AssociadoDtoRequest associateDTO, @PathVariable Long id){
	        associadoService.update(associateDTO, id);
	        return ResponseEntity.noContent().build();
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteAssociate(@PathVariable Long id){
	        associadoService.delete(id);
	        return ResponseEntity.noContent().build();
	    }

	    @DeleteMapping("/{idAssociate}/partidos/{idPoliticalParty}")
	    public ResponseEntity<Void> deleteAssociateByPoliticalParty(@PathVariable Long idAssociate, @PathVariable Long idPoliticalParty){
	        associadoService.deleteByPoliticalParty(idAssociate, idPoliticalParty);
	        return ResponseEntity.noContent().build();
	    }
}
