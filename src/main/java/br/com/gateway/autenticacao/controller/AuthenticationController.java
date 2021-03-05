package br.com.gateway.autenticacao.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gateway.autenticacao.service.Authentication;

@RestController
@RequestMapping("/auth/")
public class AuthenticationController {
	@Autowired
	private Authentication service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<?> auth(HttpSession session) {
		return service.authentication(session);
	}
}
