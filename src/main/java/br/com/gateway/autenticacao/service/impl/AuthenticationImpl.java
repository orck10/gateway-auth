package br.com.gateway.autenticacao.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.gateway.autenticacao.dto.RestTemplate;
import br.com.gateway.autenticacao.service.Authentication;

@Service
public class AuthenticationImpl implements Authentication{

	@Override
	public ResponseEntity<?> authentication(HttpSession session) {
		Map<String, String> map = new HashMap<>();
		map.put("X-Auth-Token", session.getId());
		return new ResponseEntity<RestTemplate>(new RestTemplate(map, HttpStatus.OK.toString()),
				HttpStatus.OK);
	}
}
