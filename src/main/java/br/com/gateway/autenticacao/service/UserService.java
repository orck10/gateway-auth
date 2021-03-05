package br.com.gateway.autenticacao.service;

import org.springframework.http.ResponseEntity;

public interface UserService {
	public ResponseEntity<?> getAll();
	
	public ResponseEntity<?> save(String name, String password);
}
