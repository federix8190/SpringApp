package com.core.federix.controllers;

import com.core.federix.models.Persona;
import com.core.federix.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@RestController
@RequestMapping("/test")
public class TestController {

	/*@Autowired
	private AnswerService answerService;

	@Autowired
	private JwtUtil jwtUtil;*/

	@Autowired
	private TestService service;

	@GetMapping
	public String get() {
		return "Holaaa";
	}

	@GetMapping(value="/persons")
	public List<Persona> persons() {

		List<Persona> lista = new ArrayList<>();
		lista.add(new Persona(1, "Juan", "Perez", 19));
		lista.add(new Persona(2, "Fede", "Torres", 31));
		lista.add(new Persona(3, "Silvia", "Sandoval", 25));
		lista.add(new Persona(4, "Hermann", "Bottger", 35));
		lista.add(new Persona(5, "Daniel", "Rojas", 26));
		lista.add(new Persona(6, "Carlos", "Gonzalez", 29));
		lista.add(new Persona(7, "Matias", "Ross", 24));
		lista.add(new Persona(8, "Jazmin", "Cubilla", 25));
		return lista;
	}

	@GetMapping(value="/planilla")
	public ResponseEntity<byte[]> excel() throws Exception {

		ByteArrayOutputStream salida = service.export();
		byte[] res = salida.toByteArray();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/vnd.ms-excel");
		headers.set("Content-Disposition", "attachment; filename=\"Planilla.xlsx\"");
		return new ResponseEntity<>(res, headers, HttpStatus.OK);
	}

	/**
	 * Para probar --> {"id":1,"edad":20,"nombre":"luis","apellido":""}
	 * @param p
	 */
	@PostMapping(value="/persons")
	public void save(@RequestBody Persona p) {//@RequestHeader("Authorization") String authorization) {
		System.err.println("Persona : " + p);
	}

}
