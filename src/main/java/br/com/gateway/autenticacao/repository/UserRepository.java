package br.com.gateway.autenticacao.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.gateway.autenticacao.dto.UserDTO;

public interface UserRepository extends MongoRepository<UserDTO, UUID> {
	public List<UserDTO> findByName(String name);
}
