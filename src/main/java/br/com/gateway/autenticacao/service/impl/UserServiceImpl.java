package br.com.gateway.autenticacao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.gateway.autenticacao.dao.UserDAO;
import br.com.gateway.autenticacao.dto.RestTemplate;
import br.com.gateway.autenticacao.dto.RestTemplateError;
import br.com.gateway.autenticacao.dto.UserDTO;
import br.com.gateway.autenticacao.model.User;
import br.com.gateway.autenticacao.service.UserService;
import br.com.gateway.autenticacao.utils.StringUtils;

@Service
public class UserServiceImpl implements UserService{
	
	@Value("${project.util.key}")
	private String key;
	
	@Autowired
	private UserDAO dao;
	
	@Override
	public ResponseEntity<?> getAll() {
		RestTemplate response = new RestTemplate(
			 	new UserDTO().parseList(dao.getAll(), false),
				HttpStatus.OK.toString());
		return new ResponseEntity<RestTemplate>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> save(String name, String password) {
		String erro = "";
		if(name != null && !name.isEmpty() && password != null && !password.isEmpty()) {
			String passwordHash = new StringUtils().encrypt(key, password);
			if(dao.getByName(name).isEmpty()) {
				UserDTO dto = new UserDTO().parse(
						dao.save(new User(null, name, passwordHash, null)), 
						false);
				RestTemplate response = new RestTemplate(
						dto,
						HttpStatus.CREATED.toString());
				return new ResponseEntity<RestTemplate>(response, HttpStatus.CREATED);
			}else {
				erro = "Usuario já cadastrado";
			}
		}
		else {
			erro = "Nome e senha são obrigatórios";
		}
		return new ResponseEntity<RestTemplate>(
				errorResponseBadRequest(erro,"Requisição invalida"), 
				HttpStatus.BAD_REQUEST);
	}
	
	protected RestTemplate errorResponseBadRequest(String message, String error) {
		RestTemplateError errorResponse = new RestTemplateError(error, message);
		return new RestTemplate(
				errorResponse,
				HttpStatus.BAD_REQUEST.toString());
	}
}
