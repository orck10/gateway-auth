package br.com.gateway.autenticacao.dao.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.gateway.autenticacao.dao.UserDAO;
import br.com.gateway.autenticacao.model.User;
import br.com.gateway.autenticacao.repository.UserRepository;

@Component
public class UserDAOImpl implements UserDAO{
	@Autowired
	private UserRepository repo;
	
	public User getById(UUID id) {
		return repo.findById(id).get();
	}

	@Override
	public List<User> getAll() {
		return repo.findAll();
	}

	@Override
	public User save(User user) {
		return repo.save(user);
	}

	@Override
	public List<User> getByName(String name) {
		return repo.findByName(name);
	}
}
