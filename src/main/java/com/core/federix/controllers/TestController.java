package com.core.federix.controllers;

import com.core.federix.models.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

	/*@Autowired
	private AnswerService answerService;

	@Autowired
	private JwtUtil jwtUtil;*/

	@GetMapping
	public String get() {
		return "Holaaa";
	}

	@GetMapping(value="/persons")
	public List<Persona> persons() {
		List<Persona> res = new ArrayList<>();
		res.add(new Persona(1, "Juan", "Perez", 18));
		res.add(new Persona(2, "Fede", "Torres", 31));
		res.add(new Persona(3, "Carlos", "Gonzalez", 46));
		res.add(new Persona(1, "Jazmin", "Cubilla", 25));
		return res;
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
