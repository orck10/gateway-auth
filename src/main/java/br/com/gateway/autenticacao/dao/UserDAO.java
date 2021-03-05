package br.com.gateway.autenticacao.dao;

import java.util.List;
import java.util.UUID;

import br.com.gateway.autenticacao.dto.UserDTO;

public interface UserDAO {
	public UserDTO getById(UUID id);
	
	public List<UserDTO> getAll();
	
	public UserDTO save(UserDTO user);
	
	public List<UserDTO> getByName(String Name);
}
