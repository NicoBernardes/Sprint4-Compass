package com.compass.sprint4.exceptions;

import java.net.http.HttpHeaders;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException extends ResponseEntityExceptionHandler {

	private static final String PARTIDO_NOT_FOUND = "Partido não encontrado";
	private static final String IDEOLOGIA_INVALIDA = "Ideologia Inválida";
	private static final String ERRO_INTERNO = "Erro interno no servidor";
	private static final String SEXO_INVALIDO = "Sexo Inválido";
	private static final String CARGO_NOT_FOUND = "Cargo inválido";

	@ExceptionHandler(value = { Exception.class })
	protected ResponseEntity<ErrorMessage> handlerException(Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorMessage(ERRO_INTERNO));
	}

	@ExceptionHandler(value = { PartidoNotFoundException.class })
	protected ResponseEntity<ErrorMessage> handlerPartidoNotFound(PartidoNotFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage(PARTIDO_NOT_FOUND));
	}
	@ExceptionHandler(value = { CargoNotFoundException.class })
	protected ResponseEntity<ErrorMessage> handlerCargoNotFound(CargoNotFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage(CARGO_NOT_FOUND));
	}
	
	@ExceptionHandler(value = { IdeologiaInvalidException.class })
	protected ResponseEntity<ErrorMessage> handlerIdeologiaNotFound(IdeologiaInvalidException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage(IDEOLOGIA_INVALIDA));
	}

	@ExceptionHandler(value = { SexoInvalidException.class })
	protected ResponseEntity<ErrorMessage> handlerSexoInvalido(SexoInvalidException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage(SEXO_INVALIDO));
	}

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> validationList = ex.getBindingResult().getFieldErrors().stream()
				.map(fieldError -> "Campo '" + fieldError.getField() + "'" + fieldError.getDefaultMessage())
				.collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessage(validationList));
	}
}
