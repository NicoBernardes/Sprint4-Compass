package com.compass.sprint4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compass.sprint4.service.AssociadoService;

@RestController
@RequestMapping(value = "/associados")
public class AssociadoController {

	@Autowired
	private AssociadoService associadoService;
	
	
	
	
}
