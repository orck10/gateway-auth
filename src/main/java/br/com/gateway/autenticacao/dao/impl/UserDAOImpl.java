package br.com.gateway.autenticacao.dao.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.gateway.autenticacao.dao.UserDAO;
import br.com.gateway.autenticacao.dto.UserDTO;
import br.com.gateway.autenticacao.repository.UserRepository;

@Component
public class UserDAOImpl implements UserDAO{
	@Autowired
	private UserRepository repo;
	
	public UserDTO getById(UUID id) {
		return repo.findById(id).get();
	}

	@Override
	public List<UserDTO> getAll() {
		return repo.findAll();
	}

	@Override
	public UserDTO save(UserDTO user) {
		return repo.save(user);
	}

	@Override
	public List<UserDTO> getByName(String name) {
		return repo.findByName(name);
	}
}
