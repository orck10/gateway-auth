package br.com.gateway.autenticacao.service;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;

public interface Authentication {
	public ResponseEntity<?> authentication(HttpSession session);
}
