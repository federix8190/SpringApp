package com.core.federix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	/*@PostMapping
	public Answer createAnswer(@RequestHeader("Authorization") String authorization, @RequestBody Answer answer) {
		return answerService.addAnswersToPerson(jwtUtil.getEmailFromJwtToken(authorization), answer);
	}*/

}
