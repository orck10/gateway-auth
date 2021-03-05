package br.com.gateway.autenticacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gateway.autenticacao.dto.UserDTO;
import br.com.gateway.autenticacao.service.UserService;

@RestController
@RequestMapping("/user/")
public class UserController {
	
	@Autowired
	private UserService service;
	
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<?> getUsers() {
		return service.getAll();
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<?> save(@RequestBody UserDTO dto) {
		return service.save(dto.getName(), dto.getPassword());
	}
}
