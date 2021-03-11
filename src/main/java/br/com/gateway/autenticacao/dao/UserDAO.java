package br.com.gateway.autenticacao.dao;

import java.util.List;
import java.util.UUID;

import br.com.gateway.autenticacao.model.User;

public interface UserDAO {
	public User getById(UUID id);
	
	public List<User> getAll();
	
	public User save(User user);
	
	public List<User> getByName(String Name);
}
